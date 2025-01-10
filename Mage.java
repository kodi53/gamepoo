package ProjetGame;

public class Mage extends Personnage{
	public Mage(String nom) {
        super(nom, 80, 15);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        xp+=3;
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " Lance une boule de feu!");
        cible.recevoirDegats(degats + 10);
        xp+=5;
    }

    @Override
    public boolean defend(Personnage principal) {
       principal.garder();
           
    }

}
