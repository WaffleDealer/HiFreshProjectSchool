package be.kdg.hiFresh.domain.recept;


import be.kdg.foundation.qualified.Hoeveelheid;

import java.time.MonthDay;
import java.util.logging.Logger;
/**
 * @author Jan de Rijke.
 */
public class Product {
	private String naam;
	private MonthDay startHoogseizoen;
	private MonthDay eindeHoogseizoen;
	private Hoeveelheid standaard;
	// TODO: implementeer klasse


	public Product(String naam,MonthDay startHoogseizoen,MonthDay eindeHoogseizoen, Hoeveelheid
		stdHoeveelheid) {
		this.naam = naam;
		this.startHoogseizoen = startHoogseizoen;
		this.eindeHoogseizoen = eindeHoogseizoen;
		this.standaard = stdHoeveelheid;
		// TODO
	}


	public Product(String naam, Hoeveelheid stdHoeveelheid) {
		this.naam = naam;
		standaard = stdHoeveelheid;
		// TODO
	}



	public Hoeveelheid getStandaardHoeveelheid (){
		// TODO:
		return standaard;
//		return null; //vervang dit door return standaard eens goedgekeurd
	}


}
