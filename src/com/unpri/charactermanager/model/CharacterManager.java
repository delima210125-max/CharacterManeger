
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

    // TP14: batas maksimal karakter
    private static final int MAX_CHARACTERS = 20;

    // ===== CONSTRUCTOR =====
    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    // ===== TAMBAH KARAKTER =====
    public boolean addCharacter(Character character) {

        if (character == null) {
            throw new IllegalArgumentException(
                "Karakter tidak boleh kosong"
            );
        }

        if (isNameTaken(character.getName())) {
            System.out.println(
                "Gagal: karakter dengan nama '" +
                character.getName() + "' sudah ada!"
            );
            return false;
        }

        // TP14: validasi maksimal 20 karakter
        if (characterList.size() >= MAX_CHARACTERS) {
            System.out.println(
                "Gagal: jumlah karakter maksimal 20!"
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

        if (name == null) {
            return null;
        }

        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }

    // ===== CEK NAMA KARAKTER =====
    /**
     * Mengembalikan true jika sudah ada karakter
     * bernama sama tanpa membedakan huruf besar/kecil.
     */
    public boolean isNameTaken(String name) {

        if (name == null) {
            return false;
        }

        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
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

    /**
     * Mencari karakter dengan attack power tertinggi.
     *
     * @return karakter dengan attack power tertinggi,
     *         atau null jika daftar karakter kosong.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character c : characterList) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }

        return strongest;
    }
}
