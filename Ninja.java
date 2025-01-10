package ProjetGame;

public class Ninja extends personnage{
	 public Ninja(String nom) {
	        super(nom, 120, 8);
	    }

	    @Override
	    public void attaquer(Personnage cible) {
	        System.out.println(nom + " attaque " + cible.getNom() + " !");
	        cible.recevoirDegats(degats);
			xp+=3;
	    }

	    @Override
	    public void utiliserCompetence(Personnage cible) {
	        System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
	        cible.recevoirDegats(degats * 2);
			xp+=5;
	    }

		@Override
		public void defend(Personnage principal) {
			principal.garder();
		}

}
