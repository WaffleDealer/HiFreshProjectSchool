package be.kdg.hiFresh.domain.recept;

import be.kdg.foundation.operatie.Operatie;
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
    private TreeMap<Recept,Double> returnRecepten = new TreeMap<>();

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

        MemoryRepository mr = new MemoryRepository();
        mr.put(bestaandeRecepten);
        for (Operatie o : filter) {
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
