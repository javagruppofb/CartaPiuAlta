package it.unibs.fp.cartaAlta;

import it.unibs.fp.mylib.*;

public class Partita {
	private static final String RICHIESTA_CONTINUA = "Vuoi continuare a giocare? ";
	private Mazzo mazzo;
	private Gioatore player;
	
	public Partita(Mazzo mazzo, Gioatore player) {
		this.mazzo = mazzo;
		this.player = player;
	}
	
	public void play() {
		
		do {
			Carta cartaGiocatore = mazzo.estrai();
			Carta cartaMazzo = mazzo.estrai();
			System.out.println(player.getNome()+": "+cartaGiocatore.toString());
			System.out.println("Banco: " + cartaMazzo.toString());
		}while(InputDati.yesOrNo(RICHIESTA_CONTINUA) && player.puoGiocare());
		
	}
	
	public void punta() {
		
	}
}
