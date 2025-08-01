package com.example.obatku;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailObat extends AppCompatActivity {

    ImageView backButton, imageObat;
    TextView namaObat, jenisObat, hargaObat, descObat;
    EditText editJumlah;
    Button btnAddToCart;

    String nama, harga, deskripsi;
    int stok, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);

        // Inisialisasi view
        backButton = findViewById(R.id.backButton);
        imageObat = findViewById(R.id.imageObat);
        namaObat = findViewById(R.id.namaObat);
        jenisObat = findViewById(R.id.jenisObat);
        hargaObat = findViewById(R.id.hargaObat);
        descObat = findViewById(R.id.descObat);
        editJumlah = findViewById(R.id.editJumlah);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Ambil data dari Intent
        nama = getIntent().getStringExtra("nama");
        harga = getIntent().getStringExtra("harga");
        deskripsi = getIntent().getStringExtra("deskripsi");
        stok = getIntent().getIntExtra("stok", 0);
        gambar = getIntent().getIntExtra("gambar", R.drawable.paracetamol);

        // Set tampilan
        namaObat.setText(nama != null ? nama : "Nama tidak tersedia");
        hargaObat.setText(harga != null ? harga : "0");
        descObat.setText(deskripsi != null ? deskripsi : "Deskripsi kosong");
        jenisObat.setText("Stok: " + stok);
        imageObat.setImageResource(gambar);

        backButton.setOnClickListener(v -> finish());

        btnAddToCart.setOnClickListener(v -> {
            String jumlahStr = editJumlah.getText().toString().trim();

            if (TextUtils.isEmpty(jumlahStr)) {
                Toast.makeText(this, "Masukkan jumlah terlebih dahulu", Toast.LENGTH_SHORT).show();
                return;
            }

            int jumlah = Integer.parseInt(jumlahStr);

            if (jumlah <= 0) {
                Toast.makeText(this, "Jumlah harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }

            if (jumlah > stok) {
                Toast.makeText(this, "Stok tidak mencukupi", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kirim ke checkout
            Intent intent = new Intent(DetailObat.this, check_out.class);
            intent.putExtra("nama", nama);
            intent.putExtra("harga", harga);
            intent.putExtra("jumlah", jumlah);
            intent.putExtra("gambar", gambar);
            startActivity(intent);
        });
    }
}
