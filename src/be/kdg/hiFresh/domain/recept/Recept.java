package be.kdg.hiFresh.domain.recept;


import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;
/**
 * @author Jan de Rijke.
 */
public class Recept {
	//geschreven door Chuck Fon Lee
	private String naam;
	private Duration bereidingsTijd;
	private int moeilijkheid;
	private List<String> instructies;
	private List<Ingredient> ingredienten;
	private List<Label> labels;



	public Recept(
		String naam,
		Duration bereidingsTijd,
		int moeilijkheid,
		List<String> instructies,
		List<Ingredient> ingredienten
	) {
		this.naam = naam;
		this.bereidingsTijd = bereidingsTijd;
		this.moeilijkheid = moeilijkheid;
		this.instructies = instructies;
		this.ingredienten = ingredienten;
		labels = new ArrayList<>();
	}

	public void addLabel(Label label) {
		labels.add(label);
		//TODO
	}


	public String getNaam() {
		//TODO
		return naam;
//		return null; //vervang dit door return naam eens goedgekeurd
	}

	public List<Ingredient> getIngredienten() {
		return ingredienten;
	}
}
