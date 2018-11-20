package bataille;
public class Joueur {

	private String name;
	protected Paquet paquet;
	private int score;
	
	public Joueur(String nom) {
		this.name = nom;
		this.score = 0;
		this.paquet = new Paquet();
	}

	public Joueur(String nom, Paquet paquet){
		this.name = nom;
		this.paquet = paquet;
		this.score = 0;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	public Paquet getPaquet() {
		return paquet;
	}
	public Carte jouerCarte() {
            if (paquet.estVide())
                return null;
            for (int i=0; i<paquet.getPaquet().length; i++){
                if (paquet.getCarte(i) != null){
                    Carte newC = paquet.getCarte(i).clone();
                    paquet.retirerCarte(paquet.getCarte(i));
                    return newC;
                }
            }
            return null;
        }

	public boolean aPerdu() {
		if(this.paquet.estVide()) {
			return true;
		}else
			return false;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void gagnerPoint() {
		this.score++;
	}
	
	public int getNombreCartesJoueur() {
		return this.paquet.getNombreCarte();
	}
	
	public void gagnerCarte(Carte c) {
		this.paquet.ajouterCarte(c);
	}
	
	public String toString() {
		return this.name;
	}
}
