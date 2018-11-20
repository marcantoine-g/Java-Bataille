package bataille;
public class Carte {
	private int valeur;
	private String couleur;
	
	public Carte(int nombre, String couleur) {
		this.valeur = nombre;
		this.couleur = couleur;
	}
	
	public int compareTo(Carte c){
                if (this.getValeur() == 1 && c.getValeur() !=1)
                    return 1;
                if (this.getValeur() != 1 && c.getValeur() == 1)
                    return -1;
		if(this.getValeur() < c.getValeur())
			return -1;
		else if(this.getValeur() > c.getValeur()) {
			return 1;
		}else 
			return 0;
	}

	@Override
	public String toString() {
		return this.valeur+" "+this.couleur;
	}
	public String getCouleur() {
		return this.couleur;
	}
	public int getValeur() {
		return this.valeur;
	}
        
        public Carte clone(){
            return new Carte(this.valeur, this.couleur);
        }
	
}
