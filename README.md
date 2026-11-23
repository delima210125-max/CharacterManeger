
# JavaVisual TP12 - AP16
## Character Manager Sprint #5
### Layout, UI Responsif & Analisis MVC

**Nama:** Putri DelimaYanti Sumbayak  
**NIM:** 253303621223 
**Kelas:** 3 Pagi A  
**Mata Kuliah:** Java Visual  
**Tugas:** TP12 Tugas 

---

## Deskripsi Project

Character Manager Sprint #5 merupakan pengembangan aplikasi berbasis Java Swing yang berfokus pada penerapan Layout Manager, tampilan UI responsif, dan analisis konsep MVC.

Pada sprint ini, aplikasi menggunakan BorderLayout sebagai layout utama dengan empat wilayah, yaitu NORTH, CENTER, EAST, dan SOUTH. Daftar karakter ditampilkan menggunakan JScrollPane agar pengguna dapat menggulir daftar ketika ukuran jendela terbatas.

Aplikasi juga menggunakan GridLayout 2×2 untuk panel tambahan, BoxLayout untuk legenda role, serta status bar yang menampilkan jumlah karakter dan versi aplikasi.

---

## Teknologi yang Digunakan

- Java
- Java Swing
- BorderLayout
- GridLayout
- BoxLayout
- JScrollPane
- Visual Studio Code

---

## Wireframe Layout

```text
+------------------------------------------------------+
|                       NORTH                          |
|                 Character Manager                    |
|                    8 Karakter                        |
|------------------------------------------------------|
|                PANEL STATISTIK                       |
|        WARRIOR       |       MAGE                    |
|        ARCHER        |       HEALER                  |
|------------------------------------------------------|
|                              |                       |
|           CENTER             |        EAST           |
|                              |                       |
|       Daftar Karakter        |     Legenda Role      |
|                              |                       |
|       [Character 1]          |     WARRIOR           |
|       [Character 2]          |     MAGE              |
|       [Character 3]          |     ARCHER            |
|       [Character 4]          |     HEALER            |
|                              |                       |
|          JScrollPane         |                       |
|                              |                       |
|------------------------------------------------------|
|                       SOUTH                          |
|             Total Karakter          v0.5             |
+------------------------------------------------------+
```

---

## Screenshot Output

### Output1 - Tampilan Awal

![Output1](Screenshot/Output1tampilan%20awal.png)

Tampilan awal aplikasi Character Manager setelah dijalankan.

### Output2 - Tampilan Diperlebar

![Output2](Screenshot/Output2tampilan%20diperlebar.png)

Tampilan aplikasi setelah ukuran jendela diperlebar.

### Output3 - Tampilan Diperkecil

![Output3](Screenshot/Output3tampilan%20diperkecil.png)

Tampilan aplikasi setelah ukuran jendela diperkecil. Scrollbar digunakan untuk melihat daftar karakter yang tidak seluruhnya terlihat.

---

## Pengujian Resize Window

Pengujian dilakukan dengan mengubah ukuran jendela aplikasi Character Manager untuk mengamati perubahan tampilan komponen pada ukuran awal, ukuran diperlebar, dan ukuran diperkecil.

| Pengujian | Prediksi | Hasil |
|---|---|---|
| Initial Window | Seluruh komponen utama ditampilkan sesuai ukuran awal jendela. | Header, panel statistik, daftar karakter, legenda role, dan status bar tampil. |
| Widened Window | Area tampilan daftar karakter akan menjadi lebih luas ketika jendela diperlebar. | Jendela menjadi lebih lebar dan komponen menyesuaikan ruang yang tersedia. |
| Shrunk Window | Area daftar karakter menjadi lebih terbatas sehingga scrollbar membantu melihat seluruh daftar. | Scrollbar muncul dan daftar karakter dapat digulir. |

---

## Nested Panels

Aplikasi ini menggunakan nested panels atau panel bersarang untuk membagi tampilan menjadi beberapa bagian. Panel header menampung judul aplikasi dan informasi jumlah karakter, sedangkan panel statistik ditempatkan di bawah header. Panel daftar karakter menggunakan panel pembungkus sebelum dimasukkan ke dalam JScrollPane. Penggunaan panel bersarang membuat susunan komponen lebih teratur dan memudahkan pengelolaan tampilan.

---

## Mini-Challenge

### Panel yang Dipilih: GridLayout 2×2

Mini-challenge yang dipilih adalah membuat panel statistik menggunakan GridLayout dengan susunan 2 baris dan 2 kolom.

Panel tersebut menampilkan jumlah karakter berdasarkan empat jenis role, yaitu WARRIOR, MAGE, ARCHER, dan HEALER. Jumlah setiap role dihitung berdasarkan data karakter yang tersedia.

### Layout yang Tidak Dipilih: FlowLayout

FlowLayout tidak dipilih untuk panel statistik karena susunan komponennya mengikuti aliran horizontal dan dapat berpindah baris ketika ukuran ruang berubah. GridLayout lebih sesuai untuk menampilkan empat informasi statistik dalam susunan yang teratur dan memiliki ukuran sel yang sama.

---

## Google Docs - Analisis MVC

Dokumen analisis MVC dan Layout Manager TP12:

https://docs.google.com/document/d/1DTuF3N8AM7Yyz8ZDqG2VHFs2-Px1X9NkOnPRo43J9kc/edit?usp=sharing


## Versi Aplikasi

**Character Manager - v0.5**

