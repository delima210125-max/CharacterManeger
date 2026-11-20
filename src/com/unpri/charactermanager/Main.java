
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager TP5 Sprint #2 ===\n");

        CharacterManager manager = new CharacterManager();

        // ===== MENAMBAHKAN KARAKTER =====
        System.out.println("--- Tambah Karakter ---");

        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // ===== MENGUJI KARAKTER DUPLIKAT =====
        System.out.println("\n--- Pengujian Duplikat ---");

        manager.addCharacter(new Character("Arjuna", CharacterType.HEALER, 1));

        // ===== MENGHITUNG TOTAL =====
        System.out.println("\nTotal karakter saat ini: "
                + manager.getTotalCharacters());

        // ===== PENCARIAN =====
        System.out.println("\n--- Pencarian ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println(
            hasil != null ? "Ditemukan: " + hasil : "Tidak ditemukan"
        );

        Character tidakAda = manager.findByName("Zeus");

        System.out.println(
            tidakAda != null
                ? "Ditemukan: " + tidakAda
                : "Zeus tidak ditemukan (sesuai harapan)"
        );

        // ===== PENGHAPUSAN =====
        System.out.println("\n--- Penghapusan ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah hapus: "
                + manager.getTotalCharacters());

        // ===== DAFTAR KARAKTER TERSISA =====
        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // ===== MINI CHALLENGE: RATA-RATA LEVEL =====
        System.out.println("\n--- Mini Challenge: Average Level ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // ===== MINI CHALLENGE: CARI BERDASARKAN TIPE =====
        System.out.println("\n--- Mini Challenge: Find By Type ---");

        System.out.println("Karakter bertipe WARRIOR:");

        for (Character c : manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(c);
        }

        // ===== FITUR ANALITIK RANCANGAN SENDIRI =====
        System.out.println("\n--- Fitur Analitik: Find Strongest ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat: " + strongest.getName());
            System.out.println("Attack Power: " + strongest.getAttackPower());
        } else {
            System.out.println("Belum ada karakter.");
        }

        // ===== EKSPERIMEN REFERENCE =====
        System.out.println("\n--- Eksperimen Reference ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;

        System.out.println("Level Arjuna sebelum: "
                + asli.getLevel());

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna sesudah (lewat 'asli'): "
                + asli.getLevel());

        System.out.println("asli == duplikatReferensi? "
                + (asli == duplikatReferensi));

        // ===== MENGUJI DEFENSIVE COPY =====
        System.out.println("\n--- Pengujian Defensive Copy ---");

        java.util.ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
            new Character("Hantu", CharacterType.MAGE, 1)
        );

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list: "
                + salinanList.size());

        // ===== MENGUJI KONDISI LIST KOSONG =====
        System.out.println("\n--- Pengujian List Kosong ---");

        CharacterManager emptyManager = new CharacterManager();

        System.out.println("Rata-rata level list kosong: "
                + emptyManager.getAverageLevel());

        System.out.println("Find strongest list kosong: "
                + emptyManager.findStrongest());
    }
}
