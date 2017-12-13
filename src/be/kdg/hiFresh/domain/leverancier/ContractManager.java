package be.kdg.hiFresh.domain.leverancier;

import be.kdg.foundation.qualified.Hoeveelheid;
import be.kdg.hiFresh.domain.leverancier.Contract;
import be.kdg.hiFresh.domain.leverancier.ContractPeriode;
import be.kdg.hiFresh.domain.recept.Product;
import org.threeten.extra.YearWeek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Chuck Fon Lee
 */
public class ContractManager {
    private List<Contract> bestaandeContracten;

    public ContractManager() {
        bestaandeContracten= new ArrayList<>();
    }

    public void voegToeContract(Contract c) {
        bestaandeContracten.add(c);
    }

    public List<Contract> getBestaandeContracten() {
        return bestaandeContracten;
    }

    public double getGemProdPrijs(Product x, LocalDate geldigePeriode, Hoeveelheid hoev) {
        double aantalContractPeriodes=0;
        double totaalPrijs=0;
        for (Contract c : bestaandeContracten) {
            for (ContractPeriode cP : c.getcPeriodes()) {
                if(cP.isGeldigVoor(x, geldigePeriode)) {
                    totaalPrijs += cP.getEenheidsPrijs()*hoev.getAantal();
                    aantalContractPeriodes++;
                }
            }
        }
        return totaalPrijs/aantalContractPeriodes;
    }
}
