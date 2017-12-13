package be.kdg.hiFresh.domain.recept;

import be.kdg.hiFresh.domain.recept.WeekAanbod;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Chuck Fon Lee
 */
public class WeekaanbodManager {
    private List<WeekAanbod> bestaandeWeekaanboden;

    public WeekaanbodManager() {
        bestaandeWeekaanboden = new ArrayList<>();
    }

    public List<WeekAanbod> getLijstWeekaanboden(int aantal) {
        List<WeekAanbod> returnWeekaanboden = new ArrayList<WeekAanbod>();

        for (int i=0;i<aantal;i++) {
            returnWeekaanboden.add(bestaandeWeekaanboden.get(i));
        }
        return returnWeekaanboden;
    }

    public void voegToeWeekaanbod(WeekAanbod w) {
        bestaandeWeekaanboden.add(w);
    }

}
