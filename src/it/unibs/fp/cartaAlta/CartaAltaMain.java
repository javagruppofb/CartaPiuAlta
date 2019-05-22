package it.unibs.fp.cartaAlta;

import it.unibs.fp.mylib.InputDati;

public class CartaAltaMain {

	private static final String LISTA_CARTE = "1- carte FRANCESI \n2- carte ITALIANE";
	private static final String RICHIESTA_SOLDI = "Con quanti soldi vuoi partire ?";
	private static final String RICHIESTA_NOME = "Scrivi il tuo nome: ";

	public static void main(String[] args) {
		String nome = InputDati.leggiStringa(RICHIESTA_NOME);
		int patrimonio = InputDati.leggiInteroConMinimo(RICHIESTA_SOLDI, 0);
		int tipo = InputDati.leggiIntero(LISTA_CARTE, 1, 2);
		Gioatore player = new Gioatore(nome, patrimonio);
		Mazzo deck;
		if (tipo == 1) {
			deck = new Mazzo(TipoCarta.SEME_FR, TipoCarta.NOMI_FR, TipoCarta.VAL_FR);
		} else {
			deck = new Mazzo(TipoCarta.SEME_IT, TipoCarta.NOMI_IT, TipoCarta.VAL_IT);
		}
		Partita game = new Partita(deck, player);
		game.play();
	}

}
