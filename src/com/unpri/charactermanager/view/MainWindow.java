
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.BorderLayout;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

/**
 * Jendela utama aplikasi Character Manager.
 * Menampilkan daftar karakter yang diterima dari luar (bukan dibuat sendiri).
 */
public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    public MainWindow(ArrayList<Character> characterList, double averageLevel) {
        super("Character Manager v0.3");
        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        // Panel utama
        mainPanel = new JPanel(new BorderLayout());

        // Judul Daftar Karakter tepat di tengah
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ===",
            JLabel.CENTER
        );
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter tersusun ke bawah
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Menampilkan setiap karakter dari CharacterManager
        for (Character c : characterList) {

            String info = c.getName() + " | " + c.getType() +
                          " | Lv." + c.getLevel() +
                          " | HP:" + c.getHitPoints() +
                          " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);
            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            listPanel.add(characterLabel);
            listPanel.add(Box.createVerticalStrut(10));
        }

        mainPanel.add(listPanel, BorderLayout.CENTER);

        // Mini-Challenge: menampilkan rata-rata level karakter
        JLabel averageLabel = new JLabel(
            "Rata-rata Level: " + String.format("%.1f", averageLevel)
        );

        mainPanel.add(averageLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
