package ProjetGame;


public class Voleur extends Personnage{
	public Voleur(String nom) {
        super(nom, 70, 12);// peut oa denefde mais un grand damage
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        xp+=3;
    
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
        cible.recevoirDegats(degats * 3);
        xp+=5;
    }

    @Override
    public boolean defend(Personnage principal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
