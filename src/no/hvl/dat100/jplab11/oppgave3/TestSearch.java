package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave2.Bilde;

public class TestSearch {

	public static void main(String[] args) {
		
		Blogg blogg = new Blogg(3);
		
		
		Bilde t=new Bilde(1, "he", "5.5.2020", 5, "hei på dei!", "url");
		blogg.leggTil(t);
		Bilde v=new Bilde(2, "hei", "5.5.2020", 5, "he på dei!", "url");
		blogg.leggTil(v);
		Bilde r=new Bilde(3, "ei", "5.5.2020", 5, "æ!", "url");
		blogg.leggTil(r);
				
		int[] pos = blogg.search("hei");
		
		for (int i=0; i<pos.length; i++) {
			System.out.println(pos[i]);
		}
	}
}
