package be.kdg.hiFresh.application;

import be.kdg.hiFresh.domain.leverancier.Contract;

import java.util.ArrayList;
import java.util.List;

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
}
