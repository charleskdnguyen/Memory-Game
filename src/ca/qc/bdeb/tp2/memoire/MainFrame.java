/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.tp2.memoire;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Le mainframe contiendra tout les composants du jeu
 * @author charles
 */
public class MainFrame extends JFrame {

    private TempsLabel label;
    private JeuPanel panel;
    private jeuThread time;

    /**
     * Le Mainframe qui va contenir tout le contenu du jeu, le panel, le label
     * pour le timer et le timer elle-meme
     */
    public MainFrame() {
        super("Jeu de mémoire");
        setLayout(new BorderLayout());

        //panel des images
        panel = new JeuPanel();
        add(panel, BorderLayout.CENTER);

        //JLabel pour l'affichage du temps
        label = new TempsLabel();

        //Le temps restant
        time = new jeuThread(label, panel);
        time.start();
        
        //le panel pour le temps
        JPanel panelTime = new JPanel();
        panelTime.setBackground(Color.lightGray);
        panelTime.add(label);
        panelTime.setPreferredSize(new Dimension(100, 25));
        add(panelTime, BorderLayout.SOUTH);

        this.setSize(440, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
