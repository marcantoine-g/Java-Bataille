package bataille;

public class BattailleMain {
	
	public static void main(String[] args) {

		Carte c1 = new Carte(1,"PIC");
		Carte c2 = new Carte(12, "TREFLE");

//		System.out.println(c2.compareTo(c1));
//		System.out.println(c1.toString());
//		System.out.println(c2.getCouleur());
//		System.out.println(c1.getValeur());
		
		Paquet p1 = new Paquet();
//		System.out.println(p1.estVide());
		p1.ajouterCarte(c1); p1.ajouterCarte(c2);
//		System.out.println(p1.estVide());
//		System.out.println(p1.AffichagePaquet());
//		p1.retirerCarte(c2);
//		System.out.println(p1.AffichagePaquet());
//		System.out.println(p1.getNombreCarte());
		
		Joueur j1 = new Joueur("joueur 1");
		Joueur j2 = new Joueur("joueur 2");
//		System.out.println(j1.toString());
//		j2.setName("Joueur2");
//		System.out.println(j2.toString());
//		System.out.println(j1.aPerdu());
//		System.out.println(j2.aPerdu());
//		System.out.println(j2.getScore());
//		j2.gagnerPoint();
//		System.out.println(j2.getScore());
//		System.out.println(j2.getNombreCartesJoueur());
//		j2.gagnerCarte(c1);
//		System.out.println(j2.getNombreCartesJoueur());
//		System.out.println(j2.jouerCarte().toString());
		
		Bataille b = new Bataille(j1,j2);
//		System.out.println(b.getNbTour());
		b.jouerPartie();
		
		
	
	
	
	
	
	}
}