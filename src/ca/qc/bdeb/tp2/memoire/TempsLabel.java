/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.tp2.memoire;

import javax.swing.*;

/**
 * Le label qui va contenir le "timer" au bas du panel
 * @author charles
 */
public class TempsLabel extends JLabel {
    static int seconde;

    public TempsLabel() {
        this.setText("Temps restant: " + seconde);
    }

    public static int getSeconde() {
        return seconde;
    }

    public static void setSeconde(int seconde) {
        TempsLabel.seconde = seconde;
    }

    void updateTime(int seconde) {
        this.setText("Temps restant: " + seconde);
    }

}
