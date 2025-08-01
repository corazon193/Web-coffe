package com.example.obatku;

import com.google.firebase.firestore.IgnoreExtraProperties;
import java.io.Serializable;

@IgnoreExtraProperties
public class Pesanan implements Serializable {

    private String namaObat;
    private double harga;
    private int jumlah;
    private double total;
    private String status;
    private String tanggal;
    private String userId;

    // Constructor kosong untuk Firestore
    public Pesanan() {}

    // Constructor lengkap (jika ingin membuat objek manual)
    public Pesanan(String namaObat, double harga, int jumlah, double total,
                   String status, String tanggal, String userId) {
        this.namaObat = namaObat;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total = total;
        this.status = status;
        this.tanggal = tanggal;
        this.userId = userId;
    }

    // Getters
    public String getNamaObat() {
        return namaObat;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getUserId() {
        return userId;
    }

    // Setters
    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
