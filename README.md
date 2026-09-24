# **Sistem Manajemen Warnet**

---

## Deskripsi Program

Program ini adalah aplikasi CRUD berbasis console yang dibuat menggunakan Java dengan konsep OOP (Object Oriented Programming), meliputi encapsulation, inheritance, dan polymorphism. Program ini mensimulasikan sistem manajemen komputer pada sebuah warnet, di mana pengelola bisa melihat, menambah, mengubah, menghapus, serta mengatur status pemakaian (booking) tiap unit komputer. Komputer dibedakan jadi dua kategori — Reguler dan VIP — dan setiap booking yang berhasil otomatis tercatat sebagai transaksi lengkap dengan total biayanya. Data disimpan sementara menggunakan ArrayList selama program berjalan, sehingga akan kembali ke kondisi awal (dummy data) setiap kali program dijalankan ulang.

---

## Struktur Package

Program ini dibagi ke dalam 4 package berdasarkan tanggung jawabnya masing-masing:

- **Model** — berisi class entitas: `Komputer` (superclass), `KomputerReguler` dan `KomputerVIP` (subclass), serta `Transaksi`. Class-class ini murni menyimpan data dan aturan validasinya sendiri lewat setter.
- **Service** — berisi `KomputerService` dan `TransaksiService`, yang menyimpan data dalam ArrayList dan menangani seluruh logic CRUD serta pencarian data.
- **Util** — berisi `Validasi`, class bantu untuk membaca input angka dari user dengan aman (mencegah program crash kalau salah tipe data).
- **Main** — berisi `Warnet`, entry point program yang menampilkan menu, membaca input, dan menjalankan percabangan serta perulangan untuk mengontrol alur program.

**Catatan mengenai arsitektur:** struktur ini terinspirasi dari pola MVC (Model-View-Controller), tapi bukan MVC murni. Pada MVC asli, bagian tampilan (View) dan bagian pengendali alur/input (Controller) dipisah jadi dua class berbeda. Pada program ini, kedua peran tersebut masih digabung dalam satu class `Warnet` di package `Main` — class ini yang menampilkan menu sekaligus menangani input dan percabangan. Sebagai gantinya, program menambahkan package `Service` yang tidak ada di MVC klasik, berfungsi sebagai lapisan pemisah antara `Model` (data) dan `Main` (tampilan + kontrol), supaya `Main` tidak perlu memanipulasi ArrayList secara langsung. Jadi pola yang dipakai lebih tepat disebut **Model-Service Layer**, bukan MVC murni.

---

## Penerapan Inheritance & Polymorphism

`Komputer` merupakan superclass yang menyimpan atribut dan method umum (nomor, spesifikasi, harga per jam, status pemakaian). `KomputerReguler` dan `KomputerVIP` adalah subclass yang mewarisi semua itu lewat `extends` dan `super(...)`, lalu meng-override method `getKategori()` untuk menentukan kategorinya masing-masing (contoh *method overriding* dengan `@Override`). Khusus `KomputerVIP`, ada tambahan fasilitas yang disimpan sebagai konstanta `final` (sama untuk semua unit VIP) dan method `tampilkanInfo()` yang di-override untuk menampilkan info tambahan itu.

Objek `KomputerReguler` dan `KomputerVIP` disimpan bersama dalam satu `ArrayList<Komputer>` di `KomputerService` — ini adalah contoh *heterogeneous list*, di mana satu ArrayList bertipe superclass bisa menampung objek dari beberapa subclass yang berbeda sekaligus (polymorphism).

---

## Fitur Program

- Melihat seluruh data komputer beserta kategorinya
- Membooking komputer yang kosong, lengkap dengan input nama pelanggan dan durasi sewa, serta perhitungan otomatis total bayar
- Melihat riwayat seluruh transaksi booking yang pernah terjadi
- Mengelola data komputer: tambah (dengan pilihan kategori Reguler/VIP), ubah, hapus, dan kosongkan kembali
- Validasi tipe data input (angka) agar program tidak crash
- Validasi nilai data (harga, nomor, nama, durasi) langsung di dalam setter class model
- Program berjalan terus-menerus sampai user memilih keluar

---

## Penjelasan Alur Program

Program dimulai dari method `main` di class `Warnet`. Di dalamnya dibuat objek `KomputerService`, `TransaksiService`, dan `Validasi`, yang dipakai berulang kali selama program berjalan.

Menu utama ditampilkan lewat perulangan `while` selama variabel `lanjut` masih `true`, dan setiap pilihan diproses lewat percabangan `switch-case`. Menu "Kelola Komputer" membuka submenu tersendiri lewat method terpisah (`kelolaKomputer`), yang juga punya perulangannya sendiri sampai user memilih kembali ke menu utama.

[SS Output Tampilan Menu Utama]

---

### **1. Lihat Komputer**

Menampilkan seluruh data komputer di ArrayList menggunakan perulangan `for`, memanggil `tampilkanInfo()` di tiap objeknya — untuk komputer VIP, info fasilitas tambahan otomatis ikut tampil karena method ini di-override.

[SS Output Lihat Komputer]

---

### **2. Booking Komputer**

User memasukkan nomor komputer yang ingin dibooking. Kalau komputernya kosong, program meminta nama pelanggan dan durasi sewa, lalu menghitung total bayar (durasi × harga per jam) dan mencatatnya sebagai objek `Transaksi` baru lewat `TransaksiService`. Kalau komputer sudah dipakai atau nomornya tidak ditemukan, booking dibatalkan dengan pesan yang sesuai.

[SS Output Booking Komputer]

---

### **3. Riwayat Transaksi**

Menampilkan seluruh transaksi booking yang tersimpan di `TransaksiService`, lengkap dengan ID transaksi, nama pelanggan, nomor komputer, durasi, dan total bayar. Kalau belum ada transaksi sama sekali, program menampilkan pesan bahwa riwayat masih kosong.

[SS Output Riwayat Transaksi]

---

### **4. Kelola Komputer**

Membuka submenu dengan 4 pilihan:

- **Tambah Komputer** — user mengisi nomor, spesifikasi, dan harga, lalu memilih kategori (Reguler/VIP). Nomor yang sudah dipakai tidak bisa dipakai lagi.
- **Ubah Data Komputer** — mengubah spesifikasi dan harga komputer yang sudah ada berdasarkan nomor.
- **Hapus Komputer** — menghapus data komputer berdasarkan nomor.
- **Kosongkan Komputer** — mengubah status komputer yang sedang dipakai kembali menjadi kosong.

Semua aksi di submenu ini akan menolak diproses kalau ArrayList komputer masih kosong.

[SS Output Kelola Komputer]

---

### **5. Keluar**

Menghentikan perulangan `while` di menu utama, sehingga program berhenti berjalan.

[SS Output Keluar Program]
