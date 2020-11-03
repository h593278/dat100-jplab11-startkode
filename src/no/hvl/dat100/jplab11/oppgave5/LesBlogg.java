package no.hvl.dat100.jplab11.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
			//veit ikkje om eg lokke filen....
		try{
			Scanner leser = new Scanner (new File(mappe+filnavn));
			
			int antall = Integer.parseInt(leser.nextLine());

			Blogg blogFraFil = new Blogg(antall);
			
			for (int i=0; i<antall; i++) {
				String type=leser.nextLine();

				int id=Integer.parseInt(leser.nextLine());
				String bruker=leser.nextLine();
				String dato=leser.nextLine();
				int likes=Integer.parseInt(leser.nextLine());
				String tekst=leser.nextLine();
				
				if (type.equals(TEKST)) {
					Tekst t=new Tekst(id, bruker, dato, likes, tekst);
					blogFraFil.leggTil(t);
					//blogFraFil.getSamling()[i]=new Tekst(id, bruker, dato, likes, tekst);
					
					
				} else if (type.equals(BILDE)) {
					String url=leser.nextLine();
					//blogFraFil.getSamling()[i]=new Bilde(id, bruker, dato, likes, tekst, url);
					Bilde t=new Bilde(id, bruker, dato, likes, tekst, url);
					blogFraFil.leggTil(t);

				}

			}
			//System.out.println(blogFraFil.getAntall());
			for (int i=0; i<0; i++) {
				//System.out.print(blogFraFil.getSamling()[i].toString());
			}
			
			return blogFraFil;

			
		} catch (FileNotFoundException e) {
			System.out.println("feilmelding");

		} 
		return null;
		//throw new UnsupportedOperationException(TODO.method());

	}
}
