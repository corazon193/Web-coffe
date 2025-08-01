package com.example.obatku;

public class Obat {
    private String nama, deskripsi, harga;
    private int stok;
    private int gambar;

    public Obat(String nama, String deskripsi, String harga, int stok, int gambar) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.gambar = gambar;
    }

    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getHarga() { return harga; }
    public int getStok() { return stok; }
    public int getGambar() { return gambar; }
}
