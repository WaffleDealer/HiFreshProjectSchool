package be.kdg.hiFresh.domain.recept;

import org.threeten.extra.YearWeek;

import java.util.*;

/**
 * @author Jan de Rijke.
 * Weekaanbod met geordende recepten
 * Het eerste recept staat op plaats 1
 */


public class WeekAanbod {
	private YearWeek week;
	private double VerkoopPrijsPerPersoon;
	private Map<Integer,Recept> receptenVoorWeekaanbod;
	// TODO: implementeer klasse

	public static final int SIZE =10;

  public WeekAanbod(YearWeek week, double prijs) {
	  // TODO
	  this.week = week;
	  VerkoopPrijsPerPersoon = prijs;
	  receptenVoorWeekaanbod = new TreeMap<>();
  }



	/**
	 *
	 * @param recept recept dat toegevoegd moet worden
	 * @param plaats plaats in de lijst. Eventueel bestaande recepten worden naar onder geshift
	 * @return Indien een recept uit de lijst valt omdat het voorbij de maximum size geshift wordt,
	 * wordt dit gereturned, anders returns null
	 */
	public Recept voegToe(Recept recept,int plaats){
		// TODO
			if (receptenVoorWeekaanbod.get(plaats) == null) {
				receptenVoorWeekaanbod.put(plaats,recept);
			} else {
				for (int deRest = plaats; deRest<11;deRest++) {
					receptenVoorWeekaanbod.put(deRest+1,receptenVoorWeekaanbod.get(deRest));
				}
				receptenVoorWeekaanbod.put(plaats,recept);
			}
		return receptenVoorWeekaanbod.get(11);
	}


	public  Map<Integer,Recept>  getRecepten() {
		return receptenVoorWeekaanbod;
	}
}
