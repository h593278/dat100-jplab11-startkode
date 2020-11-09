package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;



public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig=0;
	
	public Blogg() {
		innleggtabell = new Innlegg[20]; 
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde]; 
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i=0; i<nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i=0; i<nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig<innleggtabell.length; 
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || !ledigPlass()) {
			return false;
		}
		innleggtabell[nesteledig]=innlegg;
		nesteledig++;
		return true;
	}
	
	public String toString() {
		String str=nesteledig+"\n";
		for (int i=0; i<nesteledig; i++) {
			str+=innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] beholder = new Innlegg[innleggtabell.length*2];
		for (int i=0; i<nesteledig; i++) {
			beholder[i]=innleggtabell[i];
		}
		innleggtabell=beholder;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		} if (!ledigPlass()) {
			utvid();
		}
		innleggtabell[nesteledig]=innlegg;
		nesteledig++;
		return true;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int pos=finnInnlegg(innlegg);
		if (pos==-1) {
			return false;
		}
		nesteledig--;
		innleggtabell[pos]=innleggtabell[nesteledig];		
		innleggtabell[nesteledig]=null;
		return true;
	}
	
	public int[] search(String keyword) {
		
		int j=0;
		
		for (int i=0; i<nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {	
				j++;
			} 
		}
		int[] tab=new int[j];
		
		int k=0;
		for (int i=0; i<nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				tab[k]=innleggtabell[i].getId();
				k++;
			}
		}
		return tab;
	}
}