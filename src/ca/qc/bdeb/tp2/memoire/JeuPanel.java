/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.tp2.memoire;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

/**
 * Cette classe contiendra la fondation du jeu, donc les images et les boutons
 * ainsi que l'algorithme pour exécuter le jeu.
 * @author charles
 */
public class JeuPanel extends JPanel {

    Timer timer;
    protected JButton[] Buttons;
    protected ImageIcon mysteryIcon = new ImageIcon("question.png");
    protected static ImageIcon[] images = {
        new ImageIcon("drumcode.jpg"),
        new ImageIcon("anjuna.jpg"),
        new ImageIcon("awakenings.jpg"),
        new ImageIcon("cirez.jpg"),
        new ImageIcon("pryda.jpg"),
        new ImageIcon("stereo.jpg"),
        new ImageIcon("tomorrowland.jpg"),
        new ImageIcon("ultra.jpg"),/////////////////
        new ImageIcon("drumcode.jpg"),
        new ImageIcon("anjuna.jpg"),
        new ImageIcon("awakenings.jpg"),
        new ImageIcon("cirez.jpg"),
        new ImageIcon("pryda.jpg"),
        new ImageIcon("stereo.jpg"),
        new ImageIcon("tomorrowland.jpg"),
        new ImageIcon("ultra.jpg")};

    private int nbClick = 0;
    private int deuxiemeClick = 0;
    private int premierClick = 0;

    /**
     * Panel qui contient tout les boutons pour le jeu
     */
    public JeuPanel() {
        setBackground(Color.lightGray);
        int totalButtons = images.length;
        Buttons = new JButton[totalButtons];

        shuffleButtons(images);

        for (int i = 0; i < Buttons.length; i++) {

            Buttons[i] = new JButton();

            Buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nbClick++;

                    //Recherche le bouton cliqué par l'utilisateur
                    for (int i = 0; i < 16; i++) {
                        if (e.getSource() == Buttons[i]) {
                            Buttons[i].setIcon(images[i]);
                            premierClick = i;
                        }
                    }
                    //Si l'utilisateur clique 2 fois
                    if (nbClick % 2 == 0) {
                        //Si l'utilisateur clique 2 fois sur la meme image
                        if (premierClick == deuxiemeClick) {
                            nbClick--;
                        }
                        //Si les 2 images ne "match" pas
                        if (images[premierClick].getImage() 
                                != images[deuxiemeClick].getImage()) {
                            
                            Buttons[premierClick].setIcon(mysteryIcon);
                            Buttons[deuxiemeClick].setIcon(mysteryIcon);
                        }
                    } else {
                        // we just record index for odd clicks
                        deuxiemeClick = premierClick;
                    }
                }
            });
            Buttons[i].setIcon(mysteryIcon);
            add(Buttons[i]);
        }

        setLayout(new GridLayout(4, 4));
    }

    /**
     * Méthode qui va mélanger les images des boutons
     * @param images les images du jeu
     */
    public void shuffleButtons(ImageIcon[] images) {
        Random rand = ThreadLocalRandom.current();  // Random number generator			

        for (int i = images.length - 1; i > 0; i--) {
            int randomPosition = rand.nextInt(i + 1);
            ImageIcon temp = images[randomPosition];
            images[randomPosition] = images[i];
            images[i] = temp;
        }
    }
}
