package be.kdg.hiFresh.application;


import be.kdg.foundation.operatie.Operatie;
import be.kdg.foundation.operatie.Sort;
import be.kdg.hiFresh.domain.recept.*;

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
/**
 * @author Chuck Fon Lee
 */
	public BackOfficeController(ReceptManager rM,WeekaanbodManager pM) {
		productenMan = pM;
		receptenMan = rM;
	} //TODO indien nodig
	/**
     * @author Chuck Fon Lee
     */
	public List<WeekAanbod> getLijstWeekaanbod() {
		// TODO
		return productenMan.getLijstWeekaanboden(WEEK_PAGE_SIZE); //placeholder om compileerbaar te maken
	}
	/**
     * @author Chuck Fon Lee
     */
	public Map<Recept, Double> zoekRecepten(
		int jaar, int week, List<Operatie>
		filter,
		List<Sort> sorter
	) {
		receptenMan.zoekRecepten(jaar,week,filter,sorter);

		// TODO
		return null; //placeholder om compileerbaar te maken
	}

}
