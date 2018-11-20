package bataille;
public class Paquet {
	
	private  Carte [] cartes ;
	
	public Paquet() {
		this.cartes = new Carte [54];
	}
		
	public String AffichagePaquet() {
		String result = "";
		for(int i=0; i<cartes.length; i++) {
			if (cartes[i]!=null)
				result += cartes[i].toString()+" ";
		}
		return result;
	}	
	
	public void viderPaquet() {
		for (int i=0; i<cartes.length; i++) {
			cartes[i]=null;
		}
	}
	
	public Carte[] getPaquet() {
		return cartes;
	}
	
	public void ajouterCarte(Carte c) {
		for (int i=0; i<cartes.length; i++){
			if (cartes[i]==null) {
				cartes[i]=c;
				break;
			}	
		}
		this.melanger();
	}
	
	public boolean estVide() {
		for (int i=0; i<cartes.length; i++){
			if (cartes[i]!=null)
				return false;
		}
		return true;
	}
	
	public void retirerCarte(Carte c) {
		for (int i=0; i<cartes.length; i++){
			if (cartes[i]!=null) {
				if (cartes[i].getValeur() == c.getValeur() && cartes[i].getCouleur().equals(c.getCouleur()))
					cartes[i]=null;
			}
		}
		this.melanger();
	}
	
	public Carte getCarte(int index) {
		return cartes[index];
	}
	
	public void melanger() {
		for (int i = 0; i < cartes.length; i++) {
        	int r = (int) (Math.random() * cartes.length);
       		Carte tmp = cartes[i];
        	cartes[i] = cartes[r];
        	cartes[r] = tmp;
		}
	}

	public int getNombreCarte() {
		int cpt=0;
		for (int i=0; i<cartes.length; i++){
			if (cartes[i]!=null)
				cpt++;
		}
		return cpt;
	}

}
