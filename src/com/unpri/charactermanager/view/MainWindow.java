
package com.unpri.charactermanager.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.4");
        this.characterList = characterList;

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.PANEL_BORDER);

        mainPanel.add(createTitleLabel());

        for (Character c : characterList) {
            mainPanel.add(createCharacterLabel(c));
        }

        add(mainPanel);
    }

    /** Membuat judul layar. */
    private JLabel createTitleLabel() {
        JLabel lbl = new JLabel(
            "Daftar Karakter (" + characterList.size() + ")",
            SwingConstants.CENTER
        );

        lbl.setFont(AppTheme.FONT_TITLE);
        lbl.setForeground(AppTheme.TEXT_MAIN);

        return lbl;
    }

    /** Membuat satu kartu karakter sesuai role. */
    private JLabel createCharacterLabel(Character c) {

        String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

        JLabel lbl = new JLabel(info);
        lbl.setFont(AppTheme.FONT_BODY);

        // Mini-Challenge: level 5 ke atas berwarna emas dan tebal
        if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
            lbl.setForeground(AppTheme.GOLD);
            lbl.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        } else {
            lbl.setForeground(AppTheme.TEXT_LIGHT);
        }

        lbl.setBackground(AppTheme.colorFor(c.getType()));
        lbl.setOpaque(true);
        lbl.setBorder(AppTheme.CARD_BORDER);

        // Properti tambahan 1: tooltip detail karakter
        lbl.setToolTipText(
            "<html>"
            + AppTheme.describe(c.getType())
            + "<br>Nama: " + c.getName()
            + "<br>Level: " + c.getLevel()
            + "<br>HP: " + c.getHitPoints()
            + "<br>ATK: " + c.getAttackPower()
            + "</html>"
        );

        // Properti tambahan 2: karakter level 1 dibuat nonaktif
        if (c.getLevel() == 1) {
            lbl.setEnabled(false);
        }

        lbl.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        return lbl;
    }
}
