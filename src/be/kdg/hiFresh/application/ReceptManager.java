package be.kdg.hiFresh.application;

import be.kdg.hiFresh.domain.leverancier.Contract;
import be.kdg.hiFresh.domain.recept.Recept;

import java.util.ArrayList;
import java.util.List;

public class ReceptManager {
    private ContractManager bestaandeContracten;
    private List<Recept> bestaandeRecepten;
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
}
