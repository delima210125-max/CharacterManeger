
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import java.awt.Component;
import java.awt.BorderLayout;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

/**
 * Jendela utama aplikasi Character Manager.
 * Menampilkan daftar karakter yang diterima dari luar.
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

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        // Panel utama
        mainPanel = new JPanel(new BorderLayout());

        // Judul daftar karakter di tengah
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ===",
            JLabel.CENTER
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Menampilkan karakter secara dinamis
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

        // Statistik rata-rata level
        JLabel averageLabel = new JLabel(
            "Rata-rata Level: " + String.format("%.1f", averageLevel),
            JLabel.CENTER
        );

        averageLabel.setBorder(
            BorderFactory.createEmptyBorder(12, 0, 12, 0)
        );

        // Panel statistik di bawah daftar
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(averageLabel, BorderLayout.NORTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
