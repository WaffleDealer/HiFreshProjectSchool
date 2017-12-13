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
import java.util.function.Predicate;

/**
 * @author Chuck Fon Lee
 */
public class ReceptManager extends MemoryRepository {
    private ContractManager bestaandeContracten;
    private List<Recept> bestaandeRecepten;
    private Map<Recept,Double> returnRecepten;
    private MemoryRepository<Recept> mR;

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

    /**
     * @author Chuck Fon Lee
     */
    public Map<Recept,Double> zoekRecepten(int jaar, int week, List<Operatie> filter,List<Sort> sorter) {

        mR = new MemoryRepository<>();
        for (Recept recept : bestaandeRecepten) {
            mR.put(recept);
        }
        returnRecepten = new HashMap<>();
        List<Recept> f = new ArrayList<>();
        Comparator<Recept> sortComparator=null;

        for (Sort sort : sorter) {
            if (sort.getOrder().equals(Order.ASCENDING)) {
                sortComparator = new Comparator<>() {
                    @Override
                    public int compare(Recept o1, Recept o2) {
                        return o1.getNaam().compareToIgnoreCase(o2.getNaam());
                    }
                };
            } else {
                 sortComparator = new Comparator<>() {
                    @Override
                    public int compare(Recept o1, Recept o2) {
                        return o2.getNaam().compareToIgnoreCase(o1.getNaam());
                    }
                };
            }
        }

        for (Operatie operatie : filter) {
            switch (operatie.getOperator()) {
                case CONTAINS: f=mR.findWhere(( x -> x.getNaam().toLowerCase().contains(operatie.getValue().toLowerCase())),sortComparator);
                break;
            }
        }

        LocalDate geldigePeriode = LocalDate.ofYearDay(jaar,week*7);

        for (Recept r : f) {
            double gemPrijsRec=0;
            List<Ingredient> i = r.getIngredienten();

            for (Ingredient x : i) {
                gemPrijsRec+=bestaandeContracten.getGemProdPrijs(x.getProduct(),geldigePeriode,x.getPersoonsHoeveelheid());
            }
            returnRecepten.put(r,gemPrijsRec);
        }
        return returnRecepten;
    }
}
