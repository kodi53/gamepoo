package ProjetGame;

import java.security.Principal;

abstract class Personnage implements Attaquable{
	
	protected String nom;
	protected int pointsDeVie;
	protected int degats; // Dégâts de base
	protected int niveau;
	protected int experience;
	public int xp;

	public Personnage(String nom, int pointsDeVie, int degats) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.degats = degats;
		this.niveau = 1;
		this.experience = 0;
	}

	public void recevoirDegats(int degats) {
		pointsDeVie -= degats;
		System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
	}

	public void garder() {
		if (defend(principal) = true){
            principal.recevoirDegats(0);
			xp+=2;
			System.out.println("Bonne garde!");
		}
		else{
			pointsDeVie -= degats;
			System.out.println("Mauvaise garde");
		}
	}

	public boolean estVivant() {
		return pointsDeVie > 0;
	}

	public String getNom() {
		return nom;
	}

	public void gagnerExperience() {
		experience += xp;
		if (experience >= 100) {
			niveau++;
			experience -=100;
			System.out.println(nom + " a atteint le niveau " + niveau + " !");
		}
	}


}
