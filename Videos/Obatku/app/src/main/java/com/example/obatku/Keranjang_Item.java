package com.example.obatku;


public class Keranjang_Item {
    private String nama;
    private String harga;
    private int jumlah;
    private int gambar;

    public Keranjang_Item() {}

    public Keranjang_Item(String nama, String harga, int jumlah, int gambar) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.gambar = gambar;
    }

    // Getters dan Setters
    public String getNama() { return nama; }
    public String getHarga() { return harga; }
    public int getJumlah() { return jumlah; }
    public int getGambar() { return gambar; }
}
