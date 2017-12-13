package be.kdg.hiFresh.domain.recept;

import be.kdg.foundation.operatie.Operatie;
import be.kdg.foundation.operatie.Operator;
import be.kdg.foundation.operatie.Order;
import be.kdg.foundation.operatie.Sort;
import be.kdg.hiFresh.domain.leverancier.ContractManager;
import be.kdg.hiFresh.domain.recept.Ingredient;
import be.kdg.hiFresh.domain.recept.Recept;
import be.kdg.infra.MemoryRepository;

import java.time.LocalDate;
import java.util.*;
/**
 * @author Chuck Fon Lee
 */
public class ReceptManager extends MemoryRepository {
    private ContractManager bestaandeContracten;
    private List<Recept> bestaandeRecepten;
    private TreeMap<Recept,Double> returnRecepten;

    public ReceptManager() {
        bestaandeRecepten = new ArrayList<>();
    }

    public ReceptManager(ContractManager contracten ) {
        bestaandeRecepten = new ArrayList<>();
        bestaandeContracten = contracten;
    }

    public void voegToeRecept(Recept r) {
        bestaandeRecepten.add(r);
    }

    public ContractManager getBestaandeContracten() {
        return bestaandeContracten;
    }

    public Map<Recept,Double> zoekRecepten(int jaar, int week, List<Operatie> filter,List<Sort> sorter) {
        returnRecepten = new TreeMap<Recept,Double>((o1,o2) -> {
            for (Sort sort : sorter) {
                if(sort.getOrder().equals(Order.ASCENDING)) {
                    if (sort.getField().equalsIgnoreCase("naam")) {
                        return o1.getNaam().compareTo(o2.getNaam());
                    }
                } else {
                    if (sort.getField().equalsIgnoreCase("naam")) {
                        return o2.getNaam().compareTo(o1.getNaam());
                    }
                }
            }
            return 0;
        });

        List<Recept> f = new ArrayList<>();
        for (Operatie operatie : filter) {
            if (operatie.getOperator().equals(Operator.CONTAINS) && operatie.getField().equalsIgnoreCase("naam")) {
                for (Recept recept : bestaandeRecepten) {
                    if (recept.getNaam().toLowerCase().contains(operatie.getValue().toLowerCase())){
                        f.add(recept);
                    }
                }
            }
        }

        LocalDate geldigePeriode = LocalDate.ofYearDay(jaar,week*7);

        for (Recept r : f) {
            double gemPrijsRec=0;
            List<Ingredient> p = new ArrayList<>();
            p = r.getIngredienten();

            for (Ingredient x : p) {
                gemPrijsRec+=bestaandeContracten.getGemProdPrijs(x.getProduct(),geldigePeriode,x.getPersoonsHoeveelheid());
            }
            returnRecepten.put(r,gemPrijsRec);
        }
        return returnRecepten;
    }
}
