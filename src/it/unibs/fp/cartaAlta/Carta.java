package it.unibs.fp.cartaAlta;

public class Carta {
	private static final String TITOLO_CARTA = "%s di %s";

	private String seme;
	private String nome;
	private int val;

	public Carta(String seme, String nome, int val) {
		this.seme = seme;
		this.nome = nome;
		this.val = val;
	}

	/**
	 *  Il metodo mette a confronto la carta corrente con un'altra carta:
	 *  restituisce 1 se la carta corrente ha valore maggiore, -1 se è minore e 0 se è uguale.
	 * @param c
	 * @return
	 */
	public int confronta(Carta c) {
		if (val > c.getVal())
			return 1;
		else if (val < c.getVal())
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(String.format(TITOLO_CARTA, nome, seme));
		return s.toString();
	}

	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	public String getNome() {
		return nome;
	}
//uu
	//fede coglione
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

}
