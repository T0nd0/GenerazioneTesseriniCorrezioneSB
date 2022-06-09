package com.acme.autorizzazioni.tesserini.generazione;

import java.util.List;

import com.acme.autorizzazioni.licenze.Licenza;
import com.acme.autorizzazioni.licenze.LicenzaScadutaException;
import com.acme.autorizzazioni.tesserini.Tesserino;
import com.acme.autorizzazioni.tesserini.TesserinoCaccia;
import com.acme.autorizzazioni.tesserini.TesserinoFactory;
import com.acme.autorizzazioni.tesserini.TesserinoPesca;
import com.acme.autorizzazioni.tesserini.WrongTesserinoTypeException;

public class TesserinoGenerator {
	public final static int ANNO_IN_CORSO = 2022;
	public static void generate(Licenza licenza) throws LicenzaScadutaException, WrongTesserinoTypeException {
		//genera tesserino
		if(!licenza.isValid()) {
			throw new LicenzaScadutaException("La licenza di " + licenza.getTitolare().getCognome()+ " è scaduta");
		}
		Tesserino tesserino = null;
		
		if(licenza.getClass().getSimpleName().equals("LicenzaCaccia")) {
			
			
		} else {
			tesserino = TesserinoFactory.create(TesserinoFactory.TESSERINO_PESCA);
		}
		
		
		System.out.println("tesserino caccia inviato ad atc" + licenza.);
		
		
	}
	
	private Tesserino generaTesserinoCaccia(Licenza licenza) {
		Tesserino tesserino = TesserinoFactory.create(TesserinoFactory.TESSERINO_CACCIA);
		tesserino.setAnnoValidita(ANNO_IN_CORSO);
		return tesserino;
	}
	
	private Tesserino generaTesserinoCaccia(Licenza licenza) {
		Tesserino tesserino = TesserinoFactory.create(TesserinoFactory.TESSERINO_PESCA);
		tesserino.setAnnoValidita(ANNO_IN_CORSO);
		return tesserino;
	}
	
	
	public static void generate (List<Licenza> licenze) throws LicenzaScadutaException, WrongTesserinoTypeException {
		for (Licenza licenza : licenze) {
			
			generate(licenza);
		}
	}

	
}
