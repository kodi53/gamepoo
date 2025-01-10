
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameInterface extends JFrame {
    private JComboBox<String> characterSelection;
    private JTextArea battleLog;
    private JButton startButton, nextTurnButton;
    private JLabel resultLabel;
    private Personnage joueur, adversaire;
    private Random random = new Random();
    private int score = 4; // Départ du joueur (entre 0 et 8).

    public GameInterface() {
        setTitle("Jeu de Combat");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de sélection de personnage
        JPanel topPanel = new JPanel();
        characterSelection = new JComboBox<>(new String[]{"Guerrier", "Mage", "Voleur", "Ninja"});
        startButton = new JButton("Commencer le combat");
        topPanel.add(new JLabel("Choisissez votre personnage:"));
        topPanel.add(characterSelection);
        topPanel.add(startButton);
        add(topPanel, BorderLayout.NORTH);

        // Zone de journal de combat
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        add(new JScrollPane(battleLog), BorderLayout.CENTER);

        // Panel pour actions et résultats
        JPanel bottomPanel = new JPanel();
        nextTurnButton = new JButton("Tour suivant");
        nextTurnButton.setEnabled(false);
        resultLabel = new JLabel(" ");
        bottomPanel.add(nextTurnButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Actions des boutons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choisirPersonnage();
                initialiserAdversaire();
                battleLog.append("Combat commencé entre " + joueur.getNom() + " et " + adversaire.getNom() + "!\n");
                startButton.setEnabled(false);
                nextTurnButton.setEnabled(true);
            }
        });

        nextTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combatTour();
            }
        });
    }

    private void choisirPersonnage() {
        String choix = (String) characterSelection.getSelectedItem();
        switch (choix) {
            case "Guerrier":
                joueur = new Guerrier("Guerrier");
                break;
            case "Mage":
                joueur = new Mage("Mage");
                break;
            case "Voleur":
                joueur = new Voleur("Voleur");
                break;
            case "Ninja":
                joueur = new Ninja("Ninja");
                break;
        }
    }

    private void initialiserAdversaire() {
        int choix = random.nextInt(4);
        switch (choix) {
            case 0:
                adversaire = new Guerrier("Adversaire Guerrier");
                break;
            case 1:
                adversaire = new Mage("Adversaire Mage");
                break;
            case 2:
                adversaire = new Voleur("Adversaire Voleur");
                break;
            case 3:
                adversaire = new Ninja("Adversaire Ninja");
                break;
        }
    }

    private void combatTour() {
        if (joueur.estVivant() && adversaire.estVivant()) {
            joueur.attaquer(adversaire);
            battleLog.append(joueur.getNom() + " attaque " + adversaire.getNom() + ".\n");

            if (adversaire.estVivant()) {
                adversaire.attaquer(joueur);
                battleLog.append(adversaire.getNom() + " attaque " + joueur.getNom() + ".\n");
            }

            if (!adversaire.estVivant()) {
                battleLog.append("Vous avez gagné ce combat!\n");
                score++;
                initialiserAdversaire();
                battleLog.append("Nouvel adversaire : " + adversaire.getNom() + ".\n");
            }

            if (!joueur.estVivant()) {
                battleLog.append("Vous avez perdu ce combat...\n");
                score--;
            }

            if (score == 8) {
                resultLabel.setText("Félicitations, vous êtes un pro!");
                nextTurnButton.setEnabled(false);
            } else if (score == 0) {
                resultLabel.setText("Noooob! Vous avez perdu!");
                nextTurnButton.setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameInterface().setVisible(true));
    }
}
