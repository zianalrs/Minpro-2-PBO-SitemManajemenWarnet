# Sistem Manajemen Warnet

---

## Deskripsi Program

Program ini adalah aplikasi CRUD berbasis console yang dibuat menggunakan bahasa Java dengan menerapkan konsep Object Oriented Programming (OOP). Program ini dibuat untuk mensimulasikan sistem manajemen komputer pada sebuah warnet.

Program dapat digunakan untuk melihat, menambah, mengubah, dan menghapus data komputer, melakukan booking komputer, serta melihat riwayat transaksi. Komputer pada program dibedakan menjadi dua kategori, yaitu Komputer Reguler dan Komputer VIP.

Data program disimpan menggunakan `ArrayList` selama program berjalan. Ketika program dijalankan kembali, data akan kembali menggunakan data awal (dummy data).

---

## Struktur Package

Program dibagi menjadi beberapa package berdasarkan fungsi masing-masing.

### 1. Package Model

Package `Model` berisi class yang digunakan untuk merepresentasikan data atau objek dalam program.

Class yang terdapat pada package ini yaitu:

- `Komputer`
- `KomputerReguler`
- `KomputerVIP`
- `Transaksi`

`Komputer` berfungsi sebagai superclass, sedangkan `KomputerReguler` dan `KomputerVIP` merupakan subclass dari `Komputer`.

---

### 2. Package Service

Package `Service` digunakan untuk menangani proses atau logic utama program.

Class yang terdapat pada package ini yaitu:

- `KomputerService`
- `TransaksiService`

`KomputerService` digunakan untuk mengelola data komputer yang disimpan dalam `ArrayList`, seperti menambah, mencari, mengubah, menghapus, dan mengosongkan komputer.

`TransaksiService` digunakan untuk menyimpan dan mengelola data transaksi booking komputer.

---

### 3. Package Util

Package `Util` berisi class bantuan yang digunakan dalam program.

Pada package ini terdapat class `Validasi` yang digunakan untuk membantu membaca input angka dari user agar program tidak mengalami error ketika user memasukkan tipe data yang tidak sesuai.

---

### 4. Package Main

Package `Main` berisi class `Warnet` yang merupakan entry point dari program.

Class `Warnet` digunakan untuk menampilkan menu, menerima input user, dan mengatur alur program.

---

# Fitur Program

Program memiliki beberapa fitur utama, yaitu:

- Melihat seluruh data komputer
- Melakukan booking komputer
- Melihat riwayat transaksi
- Menambah data komputer
- Mengubah data komputer
- Menghapus data komputer
- Mengosongkan status komputer
- Memilih kategori komputer Reguler atau VIP
- Validasi input
- Validasi data melalui setter
- Perhitungan total biaya booking
- Program berjalan terus sampai user memilih menu keluar

---

# Penerapan Inheritance

Inheritance diterapkan pada class komputer.

Class `Komputer` digunakan sebagai superclass, sedangkan:

- `KomputerReguler`
- `KomputerVIP`

merupakan subclass.

Hubungan inheritance ditunjukkan dengan penggunaan `extends`.

Contohnya:

```java
public class KomputerReguler extends Komputer {

}
```

dan:

```java
public class KomputerVIP extends Komputer {

}
```

Subclass tersebut dapat menggunakan atribut dan method yang dimiliki oleh superclass `Komputer`.

Pada constructor subclass juga digunakan `super(...)` untuk memanggil constructor dari superclass.

Contohnya:

```java
super(nomor, spesifikasi, hargaPerJam);
```

[ss kode inheritance]

---

# Penerapan Nilai Tambah

## 1. Struktur MVC

Program menerapkan pembagian struktur yang mengacu pada konsep MVC untuk memisahkan bagian data, proses, dan tampilan program.

Pembagian package pada program adalah sebagai berikut:

### Model

Package `Model` berisi class yang merepresentasikan data atau objek program, yaitu:

- `Komputer`
- `KomputerReguler`
- `KomputerVIP`
- `Transaksi`

Bagian ini berfungsi sebagai tempat data dan objek yang digunakan dalam program.

### Service

Package `Service` berisi class yang menangani proses pengelolaan data, yaitu:

- `KomputerService`
- `TransaksiService`

`KomputerService` menangani proses pengelolaan komputer, sedangkan `TransaksiService` menangani data transaksi.

### Util

Package `Util` berisi class bantuan yaitu `Validasi`.

Class ini digunakan untuk membantu proses validasi dan pembacaan input user.

### Main

Package `Main` berisi class `Warnet`.

Class ini digunakan untuk menampilkan menu, menerima input user, dan mengatur alur program.

[ss struktur package MVC]

Pembagian tersebut membuat program lebih terstruktur karena data, proses pengelolaan, dan bagian utama program dipisahkan berdasarkan package masing-masing.

---

## 2. Polymorphism

Polymorphism diterapkan melalui method overriding dan penggunaan tipe superclass untuk menangani beberapa subclass.

### Method Overriding

Class `KomputerReguler` dan `KomputerVIP` melakukan overriding terhadap method yang terdapat pada class `Komputer`.

Contohnya pada `KomputerReguler`:

```java
@Override
public String getKategori() {
    return "Reguler";
}
```

Sedangkan pada `KomputerVIP`:

```java
@Override
public String getKategori() {
    return "VIP";
}
```

Walaupun menggunakan nama method yang sama, hasil yang diberikan berbeda sesuai dengan jenis object.

[ss kode overriding]

---

### Polymorphism pada ArrayList

Polymorphism juga diterapkan ketika object `KomputerReguler` dan `KomputerVIP` disimpan dalam satu `ArrayList` yang menggunakan tipe superclass `Komputer`.

Contohnya:

```java
private ArrayList<Komputer> daftarKomputer = new ArrayList<>();
```

ArrayList tersebut dapat menyimpan object dari class yang berbeda, yaitu:

```java
daftarKomputer.add(new KomputerReguler(...));
daftarKomputer.add(new KomputerVIP(...));
```

Dengan demikian, satu tipe `Komputer` dapat digunakan untuk menangani beberapa jenis object komputer.

[ss kode polymorphism]

---

### Overriding pada `tampilkanInfo()`

Polymorphism juga diterapkan pada method `tampilkanInfo()`.

Ketika program menjalankan:

```java
for (Komputer komputer : daftarKomputer) {
    komputer.tampilkanInfo();
}
```

method yang dijalankan akan menyesuaikan dengan jenis object.

Jika object merupakan `KomputerReguler`, maka informasi komputer reguler yang ditampilkan.

Jika object merupakan `KomputerVIP`, maka informasi tambahan mengenai fasilitas VIP dapat ditampilkan karena method tersebut memiliki implementasi yang berbeda pada subclass.

[ss kode tampilkanInfo]

---

# Penjelasan Alur Program

Program dimulai dengan menjalankan class `Warnet`. Setelah program dijalankan, sistem akan menampilkan menu utama yang berisi beberapa pilihan untuk mengelola komputer, melakukan booking, melihat transaksi, dan keluar dari program.

[ss menu utama]

User dapat memilih menu dengan memasukkan nomor sesuai pilihan yang tersedia. Program menggunakan perulangan `while` sehingga menu utama akan terus ditampilkan sampai user memilih menu keluar.

Setiap pilihan menu akan diproses menggunakan `switch-case` dan menjalankan fungsi sesuai dengan pilihan user.

---

## 1. Lihat Komputer

Menu **Lihat Komputer** digunakan untuk menampilkan seluruh data komputer yang tersedia pada warnet.

Ketika menu ini dipilih, program mengambil data komputer dari `KomputerService` kemudian menampilkan informasi setiap komputer.

Informasi yang ditampilkan meliputi:

- Nomor komputer
- Spesifikasi
- Harga per jam
- Kategori komputer
- Status komputer

[ss menu lihat komputer]

Pada menu ini, komputer Reguler dan komputer VIP ditampilkan menggunakan method `tampilkanInfo()` yang terdapat pada class `Komputer`.

Karena `KomputerReguler` dan `KomputerVIP` memiliki implementasi method yang berbeda, informasi yang ditampilkan dapat menyesuaikan dengan jenis komputer.

---

## 2. Booking Komputer

Menu **Booking Komputer** digunakan untuk melakukan penyewaan komputer oleh pelanggan.

Pertama, user memasukkan nomor komputer yang ingin digunakan.

[ss pilih komputer booking]

Program kemudian melakukan pengecekan terhadap komputer tersebut. Jika nomor komputer tidak ditemukan atau komputer sedang digunakan, program akan menampilkan pesan dan proses booking tidak dapat dilanjutkan.

[ss validasi komputer booking]

Jika komputer tersedia, user diminta memasukkan nama pelanggan dan durasi penggunaan komputer.

[ss input data booking]

Setelah seluruh data dimasukkan, program menghitung total biaya berdasarkan durasi penggunaan dan harga komputer per jam.

Rumus yang digunakan adalah:

```text
Total Bayar = Durasi × Harga per Jam
```

Setelah proses berhasil, status komputer akan berubah menjadi sedang digunakan dan data transaksi akan disimpan ke dalam `TransaksiService`.

[ss booking berhasil]

---

## 3. Riwayat Transaksi

Menu **Riwayat Transaksi** digunakan untuk melihat transaksi booking yang telah dilakukan.

Program mengambil data transaksi dari `TransaksiService` kemudian menampilkan seluruh transaksi yang tersimpan.

Informasi transaksi yang ditampilkan meliputi:

- ID transaksi
- Nama pelanggan
- Nomor komputer
- Durasi penggunaan
- Total pembayaran

[ss riwayat transaksi]

Jika belum terdapat transaksi, program akan menampilkan informasi bahwa belum ada transaksi yang tersimpan.

[ss riwayat transaksi kosong]

---

## 4. Kelola Komputer

Menu **Kelola Komputer** digunakan untuk mengelola data komputer yang terdapat pada warnet.

Pada menu ini terdapat beberapa pilihan, yaitu menambah, mengubah, menghapus, dan mengosongkan komputer.

[ss menu kelola komputer]

---

### 4.1 Tambah Komputer

Menu **Tambah Komputer** digunakan untuk menambahkan komputer baru ke dalam daftar komputer.

User diminta memasukkan beberapa data seperti:

- Nomor komputer
- Spesifikasi
- Harga per jam
- Jenis komputer

Jenis komputer yang tersedia adalah:

- Reguler
- VIP

[ss tambah komputer]

Setelah data dimasukkan, program akan melakukan validasi terhadap data tersebut.

Program juga melakukan pengecekan terhadap nomor komputer. Jika nomor komputer sudah digunakan, komputer baru tidak dapat ditambahkan dengan nomor yang sama.

[ss validasi nomor komputer]

Jika seluruh data valid, komputer akan ditambahkan ke dalam `ArrayList` dan dapat dilihat melalui menu Lihat Komputer.

[ss tambah komputer berhasil]

---

### 4.2 Ubah Data Komputer

Menu **Ubah Data Komputer** digunakan untuk mengubah data komputer yang sudah tersimpan.

User memasukkan nomor komputer yang ingin diubah.

[ss pilih komputer untuk diubah]

Jika komputer ditemukan, user dapat mengubah data seperti spesifikasi dan harga per jam.

[ss input ubah komputer]

Setelah data baru dimasukkan, program melakukan validasi kemudian memperbarui data komputer tersebut.

[ss ubah komputer berhasil]

Jika nomor komputer tidak ditemukan, program akan menampilkan pesan bahwa data komputer tidak tersedia.

[ss komputer tidak ditemukan]

---

### 4.3 Hapus Komputer

Menu **Hapus Komputer** digunakan untuk menghapus komputer dari daftar komputer.

User memasukkan nomor komputer yang ingin dihapus.

[ss input hapus komputer]

Program akan mencari komputer berdasarkan nomor yang dimasukkan. Jika komputer ditemukan, data komputer akan dihapus dari daftar.

[ss hapus komputer berhasil]

Jika nomor komputer tidak ditemukan, program akan memberikan pesan bahwa komputer tidak tersedia.

[ss hapus komputer gagal]

---

### 4.4 Kosongkan Komputer

Menu **Kosongkan Komputer** digunakan untuk mengubah status komputer yang sebelumnya sedang digunakan menjadi tersedia kembali.

User memasukkan nomor komputer yang ingin dikosongkan.

[ss input kosongkan komputer]

Jika komputer ditemukan, status `sedangDipakai` akan diubah menjadi `false`.

Dengan demikian, komputer tersebut dapat digunakan kembali untuk booking berikutnya.

[ss komputer berhasil dikosongkan]

---

## 5. Keluar Program

Menu **Keluar** digunakan untuk menghentikan program.

Ketika user memilih menu keluar, perulangan pada menu utama akan berhenti dan program selesai dijalankan.

[ss keluar program]
