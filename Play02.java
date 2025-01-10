package ProjetGame;

import java.util.Scanner;
import java.util.Random;
import javax.script.Compilable;

public class Play02 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Personnage guerrier = new Guerrier("Faris");
        Personnage mage = new Mage("Merlin");
        Personnage voleur = new Voleur("Dalton");
        Personnage ninja = new Ninja("Abo Obaida");
        int choix;
        // Choix du personnage par le joueur

        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");
        System.out.println("4. Nnjna");

         choix = scanner.nextInt();
        Personnage joueur;

        switch (choix) {
            case 1:
                joueur = guerrier;
                System.out.println("Forcre et honneur, jamais je ne plie");
                break;
            case 2:
                joueur = mage;
                System.out.println("Savoir est pouvoir, et la magie en est le clé");
                break;
            case 3:
                joueur = voleur;
                System.out.println("L'ombre est mon alliée,le silence ma force");
                break;
            case 4:
                joueur = ninja;
                System.out.println("Rapide comme le vent, silencieux comme la nuit");
            default:
                System.out.println("Choix invalide. Le guerrier est sélectionné par défaut.");
                joueur = guerrier;
                System.out.println("Forcre et honneur, jamais je ne plie");
        }
        Random random = new Random();
        Personnage adversaire;
        int choixadv = random.nextInt(4);
        switch (choixadv) {
            case 1:
                joueur = guerrier;
                System.out.println("Forcre et honneur, jamais je ne plie");
                break;
            case 2:
                joueur = mage;
                System.out.println("Savoir est pouvoir, et la magie en est le clé");
                break;
            case 3:
                joueur = voleur;
                System.out.println("L'ombre est mon alliée,le silence ma force");
                break;
            case 4:
                joueur = ninja;
                System.out.println("Rapide comme le vent, silencieux comme la nuit");
            default:
                System.out.println("Choix invalide. Le guerrier est sélectionné par défaut.");
                joueur = guerrier;
                System.out.println("Forcre et honneur, jamais je ne plie");
        }

        // Boucle de combat
        while (joueur.estVivant() && adversaire.estVivant()) {
            Random adv = new Random();
            int actionadv = random.nextInt(2);
            int action;
            switch (action){
                case 1:
                    joueur.attaquer(adversaire);
                    break;
                case 2:
                    joueur.utiliserCompetence(adversaire);
                    break;
                default:
                    System.out.println("Perder le tour!!");
            }
            
            adversaire.defend(adversaire);

            if(adversaire.estVivant()==false){
                System.out.println("vous avez gagné");
            }
            else{
                switch (actionadv){
                    case 1:
                        adversaire.attaquer(joueur);
                        break;
                    case 2:
                        adversaire.utiliserCompetence(joueur);
                        break;
                    default:
                        System.out.println("Perder le tour!!");
                }

            }

            joueur.defend(joueur);

            if(joueur.estVivant()==false){
                System.out.println("vous avez perdu");
                
            }
            
        }

        scanner.close();
        System.out.println("Le combat est terminé !");
    }

}
