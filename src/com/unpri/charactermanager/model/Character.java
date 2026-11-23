
package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation.
 */
public class Character {

    // Atribut private
    private static int totalCharacterCreated = 0;

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Constructor 1
    public Character(String name, CharacterType type, int level) {

        validateName(name);
        validateType(type);
        validateLevel(type, level);

        this.name = name.trim();
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Constructor 2
    public Character(
            int id,
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower
    ) {
        validateName(name);
        validateType(type);
        validateLevel(type, level);

        this.id = id;
        this.name = name.trim();
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Validasi nama
    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong"
            );
        }
    }

    // Validasi role
    private static void validateType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Role wajib dipilih"
            );
        }
    }

    // Validasi level
    private static void validateLevel(
            CharacterType type,
            int level
    ) {
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus 1-99"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE maksimal level 60"
            );
        }
    }

    // Helper private
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    // Getter static
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public void setType(CharacterType type) {
        validateType(type);
        validateLevel(type, this.level);

        this.type = type;
    }

    public void setLevel(int level) {
        validateLevel(this.type, level);

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif!"
            );
        }

        this.mana = mana;
    }

    // Method isAlive
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // toString
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}';
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return this.name.equalsIgnoreCase(other.name);
    }
}
