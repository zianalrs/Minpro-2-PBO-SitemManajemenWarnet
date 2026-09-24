/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LOQ
 */
public class Transaksi {
    private int idTransaksi;
    private String namaPelanggan;
    private int nomorKomputer;
    private int durasiJam;
    private double totalBayar;
 
    public Transaksi(int idTransaksi, String namaPelanggan, int nomorKomputer, int durasiJam, double totalBayar) {
        setIdTransaksi(idTransaksi);
        setNamaPelanggan(namaPelanggan);
        this.nomorKomputer = nomorKomputer;
        setDurasiJam(durasiJam);
        this.totalBayar = totalBayar;
    }
 
    public int getIdTransaksi() {
        return idTransaksi;
    }
 
    public void setIdTransaksi(int idTransaksi) {
        if (idTransaksi > 0) {
            this.idTransaksi = idTransaksi;
        } else {
            System.out.println(">> ERROR: ID transaksi harus lebih dari 0!");
        }
    }
 
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
 
    public void setNamaPelanggan(String namaPelanggan) {
        if (namaPelanggan != null && !namaPelanggan.trim().isEmpty()) {
            this.namaPelanggan = namaPelanggan;
        } else {
            System.out.println(">> ERROR: Nama pelanggan tidak boleh kosong!");
        }
    }
 
    public int getNomorKomputer() {
        return nomorKomputer;
    }
 
    public int getDurasiJam() {
        return durasiJam;
    }
 
    public void setDurasiJam(int durasiJam) {
        if (durasiJam > 0) {
            this.durasiJam = durasiJam;
        } else {
            System.out.println(">> ERROR: Durasi harus lebih dari 0 jam!");
        }
    }
 
    public double getTotalBayar() {
        return totalBayar;
    }
 
    public void tampilkanInfo() {
        System.out.println("ID Transaksi   : " + idTransaksi);
        System.out.println("Pelanggan      : " + namaPelanggan);
        System.out.println("Nomor Komputer : " + nomorKomputer);
        System.out.println("Durasi         : " + durasiJam + " jam");
        System.out.println("Total Bayar    : Rp" + totalBayar);
    }
}