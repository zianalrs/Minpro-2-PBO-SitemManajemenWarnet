/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LOQ
 */

public class Komputer {
    private int nomor;
    private String spesifikasi;
    private boolean dipakai;
 
    public Komputer(int nomor, String spesifikasi) {
        setNomor(nomor);
        setSpesifikasi(spesifikasi);
        this.dipakai = false;
    }
 
    public int getNomor() {
        return nomor;
    }
 
    public void setNomor(int nomor) {
        if (nomor > 0) {
            this.nomor = nomor;
        } else {
            System.out.println(">> ERROR: Nomor komputer harus lebih dari 0!");
        }
    }
 
    public String getSpesifikasi() {
        return spesifikasi;
    }
 
    public void setSpesifikasi(String spesifikasi) {
        if (spesifikasi != null && !spesifikasi.trim().isEmpty()) {
            this.spesifikasi = spesifikasi;
        } else {
            System.out.println(">> ERROR: Spesifikasi tidak boleh kosong!");
        }
    }
 
    public boolean isDipakai() {
        return dipakai;
    }
 
    public void setDipakai(boolean dipakai) {
        this.dipakai = dipakai;
    }
 
    public String getKategori() {
        return "Umum";
    }
 
    public double getHargaPerJam() {
        return 0;
    }
 
    public void tampilkanInfo() {
        String status = dipakai ? "Sedang Dipakai" : "Kosong";
        System.out.println("Nomor         : " + nomor);
        System.out.println("Kategori      : " + getKategori());
        System.out.println("Spesifikasi   : " + spesifikasi);
        System.out.println("Harga per Jam : Rp" + getHargaPerJam());
        System.out.println("Status        : " + status);
    }
}
