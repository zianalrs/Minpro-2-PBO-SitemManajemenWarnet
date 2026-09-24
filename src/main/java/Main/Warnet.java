/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;
import java.util.Scanner;
import Model.Komputer;
import Model.KomputerReguler;
import Model.KomputerVIP;
import Model.Transaksi;
import Service.KomputerService;
import Service.TransaksiService;
import Util.Validasi;
/**
 *
 * @author LOQ
 */
public class Warnet {
    public static void main(String[] args) {
        KomputerService service = new KomputerService();
        TransaksiService transaksiService = new TransaksiService();
        Validasi validasi = new Validasi();
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;
 
        while (lanjut) {
            System.out.println("\n==========================");
            System.out.println(" SELAMAT DATANG DI WARNET ");
            System.out.println("==========================");
            System.out.println("1. Lihat Komputer");
            System.out.println("2. Booking Komputer");
            System.out.println("3. Riwayat Transaksi");
            System.out.println("4. Kelola Komputer");
            System.out.println("5. Keluar");
            System.out.println("==========================");
            int pilihan = validasi.bacaInt(input, "Pilih menu >> ");
 
            switch (pilihan) {
                case 1:
                    service.tampilkanSemua();
                    break;
 
                case 2:
                    if (!service.adaData()) {
                        System.out.println("Belum ada data komputer, tidak bisa dibooking");
                        break;
                    }
                    int nomorBooking = validasi.bacaInt(input, "Masukkan nomor komputer yang ingin dibooking: ");
                    String hasilBooking = service.booking(nomorBooking);
 
                    if (hasilBooking.equals("berhasil")) {
                        Komputer k = service.cariByNomor(nomorBooking);
                        System.out.print("Nama Pelanggan : ");
                        String namaPelanggan = input.nextLine();
                        int durasiJam = validasi.bacaInt(input, "Durasi (jam)   : ");
                        double totalBayar = durasiJam * k.getHargaPerJam();
 
                        int idTransaksi = transaksiService.jumlahTransaksi() + 1;
                        transaksiService.tambah(new Transaksi(idTransaksi, namaPelanggan, k.getNomor(), durasiJam, totalBayar));
 
                        System.out.println("Booking berhasil.");
                        System.out.println("ID Transaksi : " + idTransaksi);
                        System.out.println("Total Bayar  : Rp" + totalBayar);
                    } else if (hasilBooking.equals("sudah_dipakai")) {
                        System.out.println("Komputer sedang dipakai orang lain");
                    } else {
                        System.out.println("Komputer dengan nomor tersebut tidak ditemukan");
                    }
                    break;
 
                case 3:
                    transaksiService.tampilkanSemua();
                    break;
 
                case 4:
                    kelolaKomputer(service, validasi, input);
                    break;
 
                case 5:
                    lanjut = false;
                    System.out.println("Terima kasih berkunjung di Warnet kami");
                    break;
 
                default:
                    System.out.println("Pilihan tidak tersedia, coba lagi");
            }
        }
    }
 
    private static void kelolaKomputer(KomputerService service, Validasi validasi, Scanner input) {
        boolean kembali = false;
 
        while (!kembali) {
            System.out.println("\n==========================");
            System.out.println("      KELOLA KOMPUTER     ");
            System.out.println("==========================");
            System.out.println("1. Tambah Komputer");
            System.out.println("2. Ubah Data Komputer");
            System.out.println("3. Hapus Komputer");
            System.out.println("4. Kosongkan Komputer");
            System.out.println("5. Kembali");
            System.out.println("==========================");
            int pilihan = validasi.bacaInt(input, "Pilih menu >> ");
 
            switch (pilihan) {
                case 1:
                    int nomor = validasi.bacaInt(input, "Nomor Komputer : ");
 
                    if (service.cariByNomor(nomor) != null) {
                        System.out.println("Nomor komputer sudah dipakai, gunakan nomor lain");
                        break;
                    }
 
                    System.out.print("Spesifikasi: ");
                    String spesifikasi = input.nextLine();
 
                    System.out.println("Kategori Komputer:");
                    System.out.println("1. Reguler (Rp7000/jam)");
                    System.out.println("2. VIP (Rp14000/jam)");
                    int kategori = validasi.bacaInt(input, "Pilih kategori : ");
 
                    if (kategori == 2) {
                        service.tambah(new KomputerVIP(nomor, spesifikasi));
                    } else {
                        service.tambah(new KomputerReguler(nomor, spesifikasi));
                    }
                    break;
 
                case 2:
                    if (!service.adaData()) {
                        System.out.println("Belum ada data komputer, tidak bisa diubah");
                        break;
                    }
                    int nomorUbah = validasi.bacaInt(input, "Masukkan nomor komputer yang ingin diubah: ");
                    System.out.print("Spesifikasi baru: ");
                    String spesifikasiBaru = input.nextLine();
 
                    boolean berhasilUbah = service.ubah(nomorUbah, spesifikasiBaru);
                    if (berhasilUbah) {
                        System.out.println("Data berhasil diubah");
                    } else {
                        System.out.println("Komputer dengan nomor tersebut tidak ditemukan");
                    }
                    break;
 
                case 3:
                    if (!service.adaData()) {
                        System.out.println("Belum ada data komputer, tidak bisa dihapus");
                        break;
                    }
                    int nomorHapus = validasi.bacaInt(input, "Masukkan nomor komputer yang ingin dihapus: ");
 
                    boolean berhasilHapus = service.hapus(nomorHapus);
                    if (berhasilHapus) {
                        System.out.println("Data berhasil dihapus");
                    } else {
                        System.out.println("Komputer dengan nomor tersebut tidak ditemukan");
                    }
                    break;
 
                case 4:
                    if (!service.adaData()) {
                        System.out.println("Belum ada data komputer, tidak bisa dikosongkan");
                        break;
                    }
                    int nomorKosong = validasi.bacaInt(input, "Masukkan nomor komputer yang ingin dikosongkan: ");
 
                    String hasilKosong = service.kosongkan(nomorKosong);
                    if (hasilKosong.equals("berhasil")) {
                        System.out.println("Komputer berhasil dikosongkan");
                    } else if (hasilKosong.equals("belum_dipakai")) {
                        System.out.println("Komputer ini memang sedang kosong");
                    } else {
                        System.out.println("Komputer dengan nomor tersebut tidak ditemukan");
                    }
                    break;
 
                case 5:
                    kembali = true;
                    break;
 
                default:
                    System.out.println("Pilihan tidak tersedia, coba lagi");
            }
        }
    }
}
 
