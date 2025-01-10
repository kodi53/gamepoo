package ProjetGame;

public interface Attaquable {
	void attaquer(Personnage cible);
	void utiliserCompetence(Personnage cible);
	boolean defend(personnage principal);

}
