package be.kdg.hiFresh.domain.leverancier;

import be.kdg.hiFresh.domain.recept.Product;
import org.threeten.extra.YearWeek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Contract {
	private static Logger logger = Logger.getLogger("be.kdg.hiFresh.domain.leverancier.Contract");
	private final LocalDate datum;
	private final int nummer;
	private final Leverancier leverancier;
//	private List<ContractPeriode> cPeriodes;
	// TODO: implementeer klasse


	public Contract(Leverancier leverancier, int i, LocalDate of) {
		this.leverancier = leverancier;
		this.nummer = i;
		this.datum=of;
	}

	public void add(ContractPeriode periode){
//		cPeriodes.add(periode);
		// TODO

	}


}
