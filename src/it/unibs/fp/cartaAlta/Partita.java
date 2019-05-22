package it.unibs.fp.cartaAlta;

import it.unibs.fp.mylib.*;

public class Partita {
	private static final String REINSERIMENTO_PUNTATA = "La sua puntata non � valida, si prega di reinserirla ";
	private static final String RICHIESTA_PUNTATA = "Quanto desidera puntare? ";
	private static final String MSG_VITTORIA = "Hai vinto: ";
	private static final String MSG_PAREGGIO = "Pareggio: ti riprendi i soldi ";
	private static final String MSG_SCONFITTA = "Mi dispiace, hai perso ";
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
				System.out.println(MSG_SCONFITTA);
				break;
			case 0:
				System.out.println(MSG_PAREGGIO);
				player.accredita(puntata);
				break;
			case 1:
				System.out.println(MSG_VITTORIA);
				player.accredita(puntata * 2); 
				break;
			}
			System.out.println(player.toString());

		} while (InputDati.yesOrNo(RICHIESTA_CONTINUA) && player.puoGiocare());

	}

	public int punta() {
		int puntata;
		boolean puntataValida;
		do {
			puntata = InputDati.leggiIntero(RICHIESTA_PUNTATA);
			puntataValida = player.punta(puntata);
			if (puntataValida == false)
				System.out.println(REINSERIMENTO_PUNTATA);
		} while (puntataValida == false);
		return puntata;
	}

}
