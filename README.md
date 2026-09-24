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

# Penerapan Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut dalam class `Komputer`, seperti `nomor`, `spesifikasi`, `hargaPerJam`, dan `sedangDipakai`.

```java
private int nomor;
private String spesifikasi;
private double hargaPerJam;
private boolean sedangDipakai;
```

Atribut tersebut tidak dapat diakses secara langsung dari luar class. Untuk mengakses atau mengubah nilainya, program menggunakan method getter dan setter.

Contohnya:

```java
public int getNomor() {
    return nomor;
}

public void setNomor(int nomor) {
    this.nomor = nomor;
}
```

Dengan demikian, data pada object `Komputer` dapat dikontrol melalui method yang telah disediakan.

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

---

# Penerapan Nilai Tambah

## 1. MVC

Program memiliki struktur yang mengacu pada konsep MVC melalui pembagian package berdasarkan fungsi masing-masing. Package `Model` berisi data dan objek program seperti `Komputer`, `KomputerReguler`, `KomputerVIP`, dan `Transaksi`. Package `Service` menangani proses pengelolaan data melalui `KomputerService` dan `TransaksiService`. Package `Util` berisi `Validasi` untuk membantu proses validasi input, sedangkan package `Main` berisi `Warnet` yang menangani tampilan menu, input user, dan alur utama program.

<img width="276" height="308" alt="image" src="https://github.com/user-attachments/assets/e00d7d15-e257-42a5-9bcd-8ac105f92a19" />

Struktur ini membuat program lebih terorganisir karena bagian data, proses, validasi, dan alur utama program dipisahkan ke dalam package masing-masing.

---

## 2. Polymorphism

Polymorphism diterapkan melalui method overriding pada class `KomputerReguler` dan `KomputerVIP`. Kedua class tersebut memiliki method `getKategori()` dan `tampilkanInfo()` dengan implementasi yang berbeda sesuai jenis komputer.

Contohnya:

```java
@Override
public String getKategori() {
    return "Reguler";
}
```

Pada class `KomputerVIP`, method tersebut mengembalikan kategori `"VIP"`.

Polymorphism juga diterapkan melalui penggunaan `ArrayList<Komputer>` yang dapat menyimpan object `KomputerReguler` dan `KomputerVIP` dalam satu daftar.

```java
private ArrayList<Komputer> daftarKomputer = new ArrayList<>();
```

Dengan demikian, satu tipe `Komputer` dapat digunakan untuk menangani beberapa jenis object komputer.

<img width="888" height="236" alt="image" src="https://github.com/user-attachments/assets/2eea20d4-6fa6-49a0-9663-43c915c7aff7" />

---

# Penjelasan Alur Program

Program dimulai dengan menjalankan class `Warnet`. Setelah program dijalankan, sistem akan menampilkan menu utama yang berisi beberapa pilihan untuk mengelola komputer, melakukan booking, melihat transaksi, dan keluar dari program.

<img width="246" height="200" alt="image" src="https://github.com/user-attachments/assets/6cd1bc47-4ee2-4295-af5c-b63cdc1c98b1" />

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

<img width="475" height="272" alt="image" src="https://github.com/user-attachments/assets/730a2a44-66be-421f-84e2-f9a8958aad77" />

Pada menu ini, komputer Reguler dan komputer VIP ditampilkan menggunakan method `tampilkanInfo()` yang terdapat pada class `Komputer`.

Karena `KomputerReguler` dan `KomputerVIP` memiliki implementasi method yang berbeda, informasi yang ditampilkan dapat menyesuaikan dengan jenis komputer.

---

## 2. Booking Komputer

Menu **Booking Komputer** digunakan untuk melakukan penyewaan komputer oleh pelanggan.

- Pertama, user memasukkan nomor komputer yang ingin digunakan.
- Program kemudian melakukan pengecekan terhadap komputer tersebut. Jika nomor komputer tidak ditemukan atau komputer sedang digunakan, program akan menampilkan pesan dan proses booking tidak dapat dilanjutkan.
- Jika komputer tersedia, user diminta memasukkan nama pelanggan dan durasi penggunaan komputer.
- Setelah seluruh data dimasukkan, program menghitung total biaya berdasarkan durasi penggunaan dan harga komputer per jam.

Rumus yang digunakan adalah:

```text
Total Bayar = Durasi × Harga per Jam
```

<img width="432" height="119" alt="image" src="https://github.com/user-attachments/assets/ca3320ff-c475-4e45-af3c-e570e974ad15" />


Setelah proses berhasil, status komputer akan berubah menjadi sedang digunakan dan data transaksi akan disimpan ke dalam `TransaksiService`.

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

<img width="244" height="139" alt="image" src="https://github.com/user-attachments/assets/24e87cdf-a129-4923-8a16-0db7847413af" />

---

## 4. Kelola Komputer

Menu **Kelola Komputer** digunakan untuk mengelola data komputer yang terdapat pada warnet.

Pada menu ini terdapat beberapa pilihan, yaitu menambah, mengubah, menghapus, dan mengosongkan komputer.

<img width="252" height="204" alt="image" src="https://github.com/user-attachments/assets/26e980db-1664-4d76-8f8c-89662d82d25d" />

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

<img width="367" height="140" alt="image" src="https://github.com/user-attachments/assets/3062d644-a43f-42b6-bbca-2a4a77a95131" />

Setelah data dimasukkan, program akan melakukan validasi terhadap data tersebut, selain itu program juga melakukan pengecekan terhadap nomor komputer. Jika nomor komputer sudah digunakan, komputer baru tidak dapat ditambahkan dengan nomor yang sama.

Jika seluruh data valid, komputer akan ditambahkan ke dalam `ArrayList` dan dapat dilihat melalui menu Lihat Komputer.

---

### 4.2 Ubah Data Komputer

Menu **Ubah Data Komputer** digunakan untuk mengubah data komputer yang sudah tersimpan.

<img width="425" height="56" alt="image" src="https://github.com/user-attachments/assets/adb0a231-4968-457e-8975-c445f8744c4a" />

- User memasukkan nomor komputer yang ingin diubah.

- Jika komputer ditemukan, user dapat mengubah data seperti spesifikasi dan harga per jam.

- Setelah data baru dimasukkan, program melakukan validasi kemudian memperbarui data komputer tersebut.

---

### 4.3 Hapus Komputer

Menu **Hapus Komputer** digunakan untuk menghapus komputer dari daftar komputer.

<img width="419" height="34" alt="image" src="https://github.com/user-attachments/assets/10b41c12-6353-41c0-bdbf-584a34846bd0" />

- User memasukkan nomor komputer yang ingin dihapus.
- Program akan mencari komputer berdasarkan nomor yang dimasukkan. Jika komputer ditemukan, data komputer akan dihapus dari daftar.

---

### 4.4 Kosongkan Komputer

Menu **Kosongkan Komputer** digunakan untuk mengubah status komputer yang sebelumnya sedang digunakan menjadi tersedia kembali.

<img width="449" height="40" alt="image" src="https://github.com/user-attachments/assets/b97e9cf7-5a38-4aa9-bbc5-3b81526f5b1c" />

- User memasukkan nomor komputer yang ingin dikosongkan.
- Jika komputer ditemukan, status `sedangDipakai` akan diubah menjadi `false`.
- Dengan demikian, komputer tersebut dapat digunakan kembali untuk booking berikutnya.

---

## 5. Keluar Program

Menu **Keluar** digunakan untuk menghentikan program.

Ketika user memilih menu keluar, perulangan pada menu utama akan berhenti dan program selesai dijalankan.

<img width="360" height="43" alt="image" src="https://github.com/user-attachments/assets/1b32ffa0-020d-43ad-8327-28c2d3e15ce7" />

