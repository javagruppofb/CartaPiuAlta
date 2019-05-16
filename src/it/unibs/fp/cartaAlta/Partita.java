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
			int puntata = punta();
			System.out.println(player.getNome() + ": " + cartaGiocatore.toString());
			System.out.println("Banco: " + cartaMazzo.toString());
			switch (cartaGiocatore.confronta(cartaMazzo)) {
			case -1:
				System.out.println("Mi dispiace, hai perso ");
				break;
			case 0:
				System.out.println("Pareggio: ti riprendi i soldi ");
				player.accredita(puntata);
				break;
			case 1:
				System.out.println("Hai vinto: ");
				player.accredita(puntata * 2); 
				break;
			}
			player.toString();

		} while (InputDati.yesOrNo(RICHIESTA_CONTINUA) && player.puoGiocare());

	}

	public int punta() {
		int puntata = InputDati.leggiIntero("Quanto desidera puntare? ");
		boolean puntataValida;
		do {
			puntataValida = player.punta(puntata);
			if (!puntataValida)
				System.out.println("La sua puntata non è valida, si prega di reinserirla ");
		} while (!puntataValida);
		return puntata;
	}

}
