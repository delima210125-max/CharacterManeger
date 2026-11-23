
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

/**
 * Pusat gaya tampilan Character Manager.
 * Mengubah tema aplikasi cukup dengan mengedit file ini.
 */
public final class AppTheme {

    // Palet warna utama
    public static final Color BG_MAIN =
            Color.decode("#13131f");

    public static final Color TEXT_MAIN =
            Color.decode("#dfe6e9");

    public static final Color TEXT_LIGHT =
            Color.WHITE;

    public static final Color GOLD =
            Color.decode("#fdcb6e");

    // Warna status
    public static final Color BG_STATUS =
            Color.decode("#0d0d1a");

    public static final Color TEXT_MUTED =
            Color.decode("#9d9dbf");

    // Warna validasi
    public static final Color ERROR =
            Color.decode("#ff7675");

    public static final Color SUCCESS =
            Color.decode("#55efc4");

    // Versi aplikasi
    public static final String APP_VERSION = "v0.6";

    // Batas level tinggi
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // Font
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    // Border
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);

    public static final Border PANEL_BORDER =
            BorderFactory.createEmptyBorder(16, 16, 16, 16);

    private AppTheme() {
        // Mencegah pembuatan objek AppTheme
    }

    // Warna berdasarkan role
    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return Color.GRAY;
        }

        switch (type) {
            case WARRIOR:
                return Color.decode("#d63031");

            case MAGE:
                return Color.decode("#0984e3");

            case ARCHER:
                return Color.decode("#00b894");

            case HEALER:
                return Color.decode("#6c5ce7");

            default:
                return Color.GRAY;
        }
    }

    // Deskripsi tooltip berdasarkan role
    public static String describe(CharacterType type) {
        if (type == null) {
            return "Role belum dipilih";
        }

        switch (type) {
            case WARRIOR:
                return "Warrior: jarak dekat, HP tinggi";

            case MAGE:
                return "Mage: serangan sihir, HP rendah";

            case ARCHER:
                return "Archer: jarak jauh, seimbang";

            case HEALER:
                return "Healer: mendukung dan memulihkan karakter";

            default:
                return "Role belum terdaftar";
        }
    }
}
