
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;
    private final Runnable onAdded;

    private final JTextField nameField = new JTextField(14);

    private final JComboBox<CharacterType> roleBox =
            new JComboBox<>(CharacterType.values());

    private final JSpinner levelSpinner =
            new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));

    private final JLabel messageLabel = new JLabel(" ");

    private final Border nameBorder;
    private final Border levelBorder;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onAdded
    ) {
        this.manager = manager;
        this.onAdded = onAdded;

        nameBorder = nameField.getBorder();
        levelBorder = levelSpinner.getBorder();

        setLayout(new BorderLayout(0, 12));
        setBackground(AppTheme.BG_MAIN);
        setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 8));
        setPreferredSize(new Dimension(250, 0));

        JLabel title = new JLabel("Tambah Karakter");
        title.setFont(AppTheme.FONT_BODY.deriveFont(java.awt.Font.BOLD));
        title.setForeground(AppTheme.TEXT_MAIN);

        JPanel fields = new JPanel(new GridLayout(0, 1, 0, 6));
        fields.setBackground(AppTheme.BG_MAIN);

        fields.add(makeLabel("Nama Karakter"));
        fields.add(nameField);

        fields.add(makeLabel("Role"));
        fields.add(roleBox);

        fields.add(makeLabel("Level"));
        fields.add(levelSpinner);

        JButton saveButton = new JButton("Simpan Karakter");
        saveButton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        saveButton.addActionListener(e -> onSave());

        // Menyimpan karakter ketika tombol Enter ditekan
        nameField.addActionListener(e -> onSave());

        JPanel bottom = new JPanel(new BorderLayout(0, 8));
        bottom.setBackground(AppTheme.BG_MAIN);
        bottom.add(messageLabel, BorderLayout.NORTH);
        bottom.add(saveButton, BorderLayout.SOUTH);

        add(title, BorderLayout.NORTH);
        add(fields, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    private JLabel makeLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(AppTheme.FONT_BODY);
        label.setForeground(AppTheme.TEXT_MAIN);
        return label;
    }

    private void onSave() {
        clearMessage();

        String name = nameField.getText().trim();

        // Memeriksa nama karakter
        String error = validateName(name);

        if (error != null) {
            showError(error, nameField);
            return;
        }

        // Memeriksa input level
        try {
            levelSpinner.commitEdit();
        } catch (ParseException e) {
            showError("Level tidak valid", levelSpinner);
            return;
        }

        CharacterType role =
                (CharacterType) roleBox.getSelectedItem();

        int level = (Integer) levelSpinner.getValue();

        // Menambahkan karakter ke manager
        try {
            boolean added = manager.addCharacter(
                    new Character(name, role, level)
            );

            if (!added) {
                showError("Jumlah karakter maksimal 20", nameField);
                return;
            }

        } catch (IllegalArgumentException e) {
            String message = e.getMessage();

            if (message != null &&
                    (message.contains("Level") || message.contains("MAGE"))) {
                showError(message, levelSpinner);
            } else {
                showError(message, nameField);
            }

            return;
        }

        // Mengosongkan form setelah berhasil
        nameField.setText("");
        roleBox.setSelectedIndex(0);
        levelSpinner.setValue(1);

        showSuccess("Tersimpan: " + name);

        nameField.requestFocusInWindow();

        onAdded.run();
    }

    // Validasi hanya mengembalikan pesan error
    private String validateName(String name) {

        // 1. Kelengkapan
        if (name.isEmpty()) {
            return "Nama wajib diisi";
        }

        // 2. Panjang nama
        if (name.length() < 3 || name.length() > 20) {
            return "Nama harus 3-20 karakter";
        }

        // 3. Format nama
        if (!name.matches("[A-Za-z ]+")) {
            return "Nama hanya huruf dan spasi";
        }

        // Aturan tambahan: tidak boleh ada spasi berulang
        if (name.contains("  ")) {
            return "Nama tidak boleh memiliki spasi berulang";
        }

        // 4. Keunikan nama
        if (manager.isNameTaken(name)) {
            return "Nama sudah dipakai";
        }

        return null;
    }

    private void showError(
            String message,
            javax.swing.JComponent field
    ) {
        messageLabel.setText(message);
        messageLabel.setForeground(AppTheme.ERROR);

        if (field == nameField) {
            nameField.setBorder(
                    BorderFactory.createLineBorder(AppTheme.ERROR, 2)
            );
        } else if (field == levelSpinner) {
            levelSpinner.setBorder(
                    BorderFactory.createLineBorder(AppTheme.ERROR, 2)
            );
        }

        field.requestFocusInWindow();
    }

    private void showSuccess(String message) {
        messageLabel.setText(message);
        messageLabel.setForeground(AppTheme.SUCCESS);
    }

    private void clearMessage() {
        messageLabel.setText(" ");
        messageLabel.setForeground(AppTheme.TEXT_MUTED);

        nameField.setBorder(nameBorder);
        levelSpinner.setBorder(levelBorder);
    }
}
