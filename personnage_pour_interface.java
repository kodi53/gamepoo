abstract class Personnage {
    private String nom;
    private int vie;

    public Personnage(String nom) {
        this.nom = nom;
        this.vie = 100; // Chaque personnage commence avec 100 points de vie
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void subirDegats(int degats) {
        this.vie -= degats;
    }

    public boolean estVivant() {
        return this.vie > 0;
    }

    public abstract void attaquer(Personnage adversaire);
}

class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom);
    }

    @Override
    public void attaquer(Personnage adversaire) {
        adversaire.subirDegats(15);
        System.out.println(getNom() + " attaque avec une épée, infligeant 15 points de dégâts.");
    }
}

class Mage extends Personnage {
    public Mage(String nom) {
        super(nom);
    }

    @Override
    public void attaquer(Personnage adversaire) {
        adversaire.subirDegats(20);
        System.out.println(getNom() + " lance un sort, infligeant 20 points de dégâts.");
    }
}

class Voleur extends Personnage {
    public Voleur(String nom) {
        super(nom);
    }

    @Override
    public void attaquer(Personnage adversaire) {
        adversaire.subirDegats(10);
        System.out.println(getNom() + " frappe rapidement, infligeant 10 points de dégâts.");
    }
}

class Ninja extends Personnage {
    public Ninja(String nom) {
        super(nom);
    }

    @Override
    public void attaquer(Personnage adversaire) {
        adversaire.subirDegats(18);
        System.out.println(getNom() + " attaque furtivement, infligeant 18 points de dégâts.");
    }
}
