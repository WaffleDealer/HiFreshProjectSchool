package be.kdg.foundation.contact;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class ContactInfo {
	private Adres adres;
	private String email;
	private String[] tel;
	// TODO: implementeer klasse
	//geschreven door Chuck Fon Lee




	public ContactInfo(Adres adres, String email, String... tel) {
		this.adres = adres;
		this.email = email;
		this.tel = tel;
	}
}
