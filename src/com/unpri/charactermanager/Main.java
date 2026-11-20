
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // Membuat 3 object Character
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);

        // Menampilkan ketiga karakter
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Menguji level up
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");
        hero.setLevel(hero.getLevel() + 1);
        System.out.println("After level up: " + hero);

        // Menguji getter
        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // MINI-CHALLENGE AP3
        System.out.println();
        System.out.println("=== MINI-CHALLENGE AP3 ===");

        // Menguji mana
        hero.setMana(100);
        System.out.println(">> Mana Arjuna: " + hero.getMana());

        // Menguji isAlive()
        System.out.println(">> Apakah Arjuna masih hidup? " + hero.isAlive());

        // Menguji validasi mana negatif
        try {
            hero.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(">> Validasi mana: " + e.getMessage());
        }

        // Membuat karakter baru
        Character newHero = new Character(
            "Thor",
            CharacterType.WARRIOR,
            6
        );

        newHero.setMana(150);

        System.out.println();
        System.out.println(">> Karakter baru: " + newHero);
        System.out.println(">> Apakah Thor masih hidup? " + newHero.isAlive());
    }
}
