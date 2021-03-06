package be.kdg.hiFresh.application;

import be.kdg.hiFresh.domain.leverancier.ContractManager;
import be.kdg.hiFresh.domain.recept.ReceptManager;
import be.kdg.hiFresh.domain.recept.WeekaanbodManager;
/**
 * @author Chuck Fon Lee
 */
public class Startup {
    private ReceptManager rM;
    private ContractManager cM;
    private WeekaanbodManager waM;
    private BackOfficeController controller;

    public Startup() {
        cM = new ContractManager();
        rM = new ReceptManager(cM);
        waM = new WeekaanbodManager();
        controller = new BackOfficeController(rM,waM);
    }

    public ReceptManager getrM() {
        return rM;
    }

    public WeekaanbodManager getWaM() {
        return waM;
    }

    public BackOfficeController getController() {
        return controller;
    }
}
