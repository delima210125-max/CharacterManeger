
package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola koleksi Character: tambah, cari, hapus,
 * dan statistik dasar.
 *
 * Menerapkan Composition:
 * CharacterManager memiliki ArrayList<Character>.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

    // ===== CONSTRUCTOR =====
    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    // ===== TAMBAH KARAKTER =====
    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {
            System.out.println(
                "Gagal: karakter dengan nama '" +
                character.getName() + "' sudah ada!"
            );
            return false;
        }

        characterList.add(character);

        System.out.println(
            "Karakter '" + character.getName() +
            "' berhasil ditambahkan."
        );

        return true;
    }

    // ===== CARI KARAKTER =====
    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    // ===== HAPUS KARAKTER =====
    public boolean removeCharacter(String name) {
        Character target = findByName(name);

        if (target == null) {
            System.out.println(
                "Gagal hapus: karakter '" +
                name + "' tidak ditemukan."
            );
            return false;
        }

        characterList.remove(target);

        System.out.println(
            "Karakter '" + name +
            "' berhasil dihapus."
        );

        return true;
    }

    // ===== HITUNG TOTAL KARAKTER =====
    public int getTotalCharacters() {
        return characterList.size();
    }

    // ===== MENGAMBIL SEMUA KARAKTER =====
    // Mengembalikan salinan daftar agar daftar asli terlindungi.
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // ===== MINI CHALLENGE: RATA-RATA LEVEL =====
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // ===== MINI CHALLENGE: CARI BERDASARKAN TIPE =====
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }
}
