package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		String melding="";
		PrintWriter skriver=null;
		try {
		skriver = new PrintWriter(mappe+filnavn);
		
		//System.out.println(samling.getClass().getSimpleName());
		
		if (samling.getClass().getSimpleName().equals("HtmlBlogg")) {		//Skriver ut nettside oppgåve 6
			
			skriver.print(samling.toString());
		} 
		
		else {				//skriver til fil
			
			skriver.println(samling.getAntall());
			
			for (int i=0; i<samling.getAntall(); i++) {
				skriver.print(samling.getSamling()[i].toString());
			}
		}
		
		return true;
		}
		catch (FileNotFoundException e) {
			melding="Filen finnes ikkje";
			return false;
		}
		finally {
			if (skriver != null) {
				skriver.close();
			}
			System.out.println(melding);
		}
		//throw new UnsupportedOperationException(TODO.method());
	}
}
