package it.unibs.fp.cartaAlta;

public class Gioatore {

	private static final int PUNTATA_MINIMA = 1;
	private static final int PATRIMONIO_MINIMO = 0;

	private String nome;
	private int patrimonio;

	public boolean puoGiocare() {
		return patrimonio >= PATRIMONIO_MINIMO;
	}

	public boolean punta(int puntata) {
		if (puntata >= PUNTATA_MINIMA && puntata <= patrimonio) {
			patrimonio -= puntata;
			return true;
		}
		return false;
	}

	public void accredita(int accredito) {
		patrimonio += accredito;
	}
	
	@Override
	public String toString() {
		StringBuffer daStampare = new StringBuffer("\n"); 
		daStampare.append(nome);
		if(puoGiocare())
			daStampare.append(" ha " + patrimonio);
		else
			daStampare.append(" ha finito i soldi");
		return daStampare.toString();
	}
	
	public String getNome() {
		return nome;
	}

	public int getPatrimonio() {
		return patrimonio;
	}
	
	

}
