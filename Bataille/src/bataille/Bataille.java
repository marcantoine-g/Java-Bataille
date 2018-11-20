package bataille;
public class Bataille {

    private Joueur j1;
    private Joueur j2;
    private static int nbTour = 0;
    private Paquet paquet;
    private Paquet paquetMillieu;

    public Bataille (Joueur j1, Joueur j2){
        this.j1=j1;
        this.j2=j2;
        this.paquetMillieu = new Paquet();
        this.paquet = new Paquet();
        creerNouveauPaquet();
        distribuerPaquet();

    }

    protected void creerNouveauPaquet() {
        String couleur [] = {"TREFLE", "COEUR", "CARREAUX", "PIC"};
		for (int i=1; i<=13; i++){
            for (int j=0; j<4; j++){
            	Carte c = new Carte(i,couleur[j]);
                paquet.ajouterCarte(c);
            }
        }
	}

    protected void distribuerPaquet() {
    	do {
    		j1.paquet.viderPaquet(); j2.paquet.viderPaquet();
    		paquet.melanger();
    		for(int i = 0; i < paquet.getPaquet().length; i++) {
    			Carte c = paquet.getCarte(i);
    			if (i%2==0)
    				j1.gagnerCarte(c);
    			else 
    				j2.gagnerCarte(c);     
    		}	
    	}while(j1.getNombreCartesJoueur()!=j2.getNombreCartesJoueur());
	} 

    public static int getNbTour() {
		return nbTour;
	}

    public void jouerPartie() {
		while(!j1.aPerdu() && !j2.aPerdu()) {
			jouerCoup();
		}
		if(j1.aPerdu()) {
			System.out.println(j1.toString()+" a gagné");
		}else {
			System.out.println(j2.toString()+" a gagné");
		}
	}

    private void jouerCoup() {
		Carte carteJ1;
                Carte carteJ2;
		Joueur gagnant = null;
                nbTour++;
		System.out.println("Tour numéro :"+nbTour);
                                
		if (!j1.aPerdu() && !j2.aPerdu()){
			carteJ1 = j1.jouerCarte();
			carteJ2 = j2.jouerCarte();
			paquetMillieu.ajouterCarte(carteJ1);
			paquetMillieu.ajouterCarte(carteJ2);
			System.out.println(j1.toString()+" a joué "+carteJ1.toString());
			System.out.println(j2.toString()+" a joué "+carteJ2.toString());
			if(carteJ1.compareTo(carteJ2) < 0) {
				gagnant = j2;
			}else if(carteJ1.compareTo(carteJ2) > 0) {
				gagnant = j1;
			}else {
	                System.out.println("----EGALITE----");
                        gagnant=null;            	
			}
		if (gagnant != null){
		    for(int i = 0; i<paquetMillieu.getPaquet().length; i++){
		    	if (paquetMillieu.getCarte(i)!= null) {
		    		gagnant.gagnerCarte(paquetMillieu.getCarte(i));            
		    		paquetMillieu.retirerCarte(paquetMillieu.getCarte(i));
		    	}
            }
		    gagnant.gagnerPoint();
            System.out.println(gagnant.toString()+" remporte les cartes de la partie");
            System.out.println("Il reste "+j1.getNombreCartesJoueur()+" cartes, avec un score de "+j1.getScore()+" au joueur "+j1.toString());
            System.out.println("Il reste "+j2.getNombreCartesJoueur()+" cartes, avec un score de "+j2.getScore()+" au joueur "+j2.toString());
            System.out.println("");
        }
		}
    }
}
