# CHARACTER MANAGER – TP5 SPRINT #2

**Mata Kuliah:** Java Visual Programming  
**Program Studi:** Sistem Informasi  
**Tugas:** TP5 – AP6 Belajar Praktik  
**Sprint:** Sprint #2  
**Bahasa Pemrograman:** Java

---

## 1. Deskripsi Project

Character Manager merupakan aplikasi sederhana berbasis Java yang digunakan untuk mengelola data karakter. Pada TP5 Sprint #2, aplikasi dikembangkan dengan menerapkan konsep Object-Oriented Programming (OOP), pengelolaan koleksi menggunakan ArrayList, serta pengujian object reference dan defensive copy.

## 2. Fitur yang Diimplementasikan

### A. Core Implementation

- `addCharacter()` – Menambahkan karakter baru.
- `findByName()` – Mencari karakter berdasarkan nama.
- `removeCharacter()` – Menghapus karakter berdasarkan nama.
- `getTotalCharacters()` – Menghitung jumlah karakter.
- `getAllCharacters()` – Mengembalikan salinan daftar karakter.
- `equals()` – Membandingkan dua karakter berdasarkan nama.
- Mencegah penambahan karakter dengan nama duplikat.

### B. Mini Challenge

- `getAverageLevel()` – Menghitung rata-rata level seluruh karakter.
- `findByType()` – Mencari karakter berdasarkan tipe karakter.
- Menguji kondisi daftar kosong.

### C. Fitur Analitik Tambahan: Find Strongest

Method `findStrongest()` digunakan untuk mencari karakter dengan nilai Attack Power tertinggi.

Fitur ini membantu mengetahui karakter yang memiliki kekuatan serangan paling besar. Method juga menangani kondisi ketika daftar karakter masih kosong dengan mengembalikan `null`.

## 3. Screenshot Hasil Program

### Screenshot 1 – CRUD dan Pengujian Duplikat

Menampilkan proses penambahan karakter, pengujian nama duplikat, pencarian, penghapusan, dan daftar karakter.

[Klik untuk membuka Screenshot 1](screenshot/Screenshot_TP5_Sprint2_1.png)

### Screenshot 2 – Analitik dan Pengujian Reference

Menampilkan Average Level, Find By Type, Find Strongest, eksperimen Reference, Defensive Copy, dan pengujian daftar kosong.

[Klik untuk membuka Screenshot 2](screenshot/Screenshot_TP5_Sprint2_2.png)

## 4. Konsep OOP yang Diterapkan

- **Encapsulation:** Melindungi atribut menggunakan access modifier `private`.
- **Composition:** CharacterManager mengelola koleksi objek Character.
- **Method Overriding:** Menggunakan `equals()` untuk membandingkan nama karakter.
- **Object Reference:** Menguji dua variabel yang menunjuk ke objek yang sama.
- **Defensive Copy:** Mengembalikan salinan ArrayList agar daftar asli terlindungi.
- **ArrayList:** Mengelola kumpulan objek karakter.

## 5. Struktur Project

```text
CharacterManeger/
├── out/
├── screenshot/
│   ├── Screenshot_AP3_Sprint1.png
│   ├── Screenshot_TP5_Sprint2_1.png
│   └── Screenshot_TP5_Sprint2_2.png
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── Main.java
│               └── model/
│                   ├── Character.java
│                   ├── CharacterType.java
│                   └── CharacterManager.java
└── README.md
```

## 6. Cara Menjalankan Program

Kompilasi program:

```bash
javac -d out -sourcepath src src/com/unpri/charactermanager/Main.java
```

Jalankan program:

```bash
java -cp out com.unpri.charactermanager.Main
```

## 7. Repository

Project ini merupakan pengembangan dari tugas Character Manager TP3 dan dikerjakan pada branch `tp5-sprint-2`.

---

**Link Google Docs:** 
https://docs.google.com/document/d/1Ux9z_F6mrDsduHniWHxQtSokHULi_0DzKLYnwsLWgfw/edit?usp=sharing

**TP5 Sprint #2 – Character Manager**  
Universitas Prima Indonesia (UNPRI)  
Program Studi Sistem Informasi