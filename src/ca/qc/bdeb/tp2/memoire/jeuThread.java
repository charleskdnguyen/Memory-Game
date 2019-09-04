/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.tp2.memoire;

import javax.swing.*;

/**
 * La classe contient les éléments qui permettront d'utiliser un compte à
 * rebours
 * @author charles
 */
public class jeuThread extends Thread implements Runnable {
    private JeuPanel panel;
    private TempsLabel time;

    /**
     * Le "timer" du jeu qui descend à partir de 90 secondes
     * @param time le label pour le temp
     * @param panel le panel qui contiendra le label
     */
    public jeuThread(TempsLabel time, JeuPanel panel) {
        this.time = time;
        this.panel = panel;
    }

    //l'algorithme qui va exécuter le temps
    @Override
    public void run() {
        time.setSeconde(90);
        while (time.getSeconde() > 0) {
            try {
                time.updateTime(time.getSeconde());
                time.seconde--;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("erreur countdown");
            }
        }
    }
}
