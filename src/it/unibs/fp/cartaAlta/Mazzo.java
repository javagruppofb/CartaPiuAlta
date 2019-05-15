package it.unibs.fp.cartaAlta;
import it.unibs.fp.mylib.*;
import java.util.ArrayList;
import java.util.Vector;

public class Mazzo {
	private String seme[];
	private String nome[];
	private int val[];
	private ArrayList<Carta> c = new ArrayList<Carta>();

	public Mazzo(String[] seme, String[] nome, int[] val) {
		this.seme = seme;
		this.nome = nome;
		this.val = val;

		for (int i = 0; i < seme.length; i++) {
			for (int j = 0; j < nome.length; j++) {
				c.add(new Carta(seme[i], nome[j], val[j]));
			}
		}
	}
	
	public Carta estrai() {
		return c.get(NumeriCasuali.estraiIntero(0, c.size()-1));
	}

}
