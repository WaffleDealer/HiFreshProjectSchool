package be.kdg.hiFresh.application;


import be.kdg.foundation.operatie.Operatie;
import be.kdg.foundation.operatie.Sort;
import be.kdg.hiFresh.domain.leverancier.Contract;
import be.kdg.hiFresh.domain.recept.*;
import org.threeten.extra.YearWeek;

import java.util.*;

/**
 * @author Jan de Rijke.
 */
// Dit is de controllerklasse van het BackOffice subsysteem
public class BackOfficeController {

	private static int WEEK_PAGE_SIZE = 2; 	// Constante die vastlegt hoeveel weken weekaanbod wordt teruggegeven.
	private WeekaanbodManager productenMan;
	private ReceptManager receptenMan;

	public BackOfficeController() {

	}

	public BackOfficeController(ReceptManager rM,WeekaanbodManager pM) {
		productenMan = pM;
		receptenMan = rM;
	} //TODO indien nodig

	public List<WeekAanbod> getLijstWeekaanbod() {
		// TODO
		return productenMan.getLijstWeekaanboden(WEEK_PAGE_SIZE); //placeholder om compileerbaar te maken
	}

	public Map<Recept, Double> zoekRecepten(
		int jaar, int week, List<Operatie>
		filter,
		List<Sort> sorter
	) {
		YearWeek geldigheid = YearWeek.of(jaar,week);
		// TODO
		return null; //placeholder om compileerbaar te maken
	}

}
