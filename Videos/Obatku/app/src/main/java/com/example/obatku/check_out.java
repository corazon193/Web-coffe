package com.example.obatku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class check_out extends AppCompatActivity {

    TextView namaObat, hargaObat, totalHarga;
    EditText jumlahObat;
    ImageView gambarObat;
    Button btnCheckout;
    ProgressBar loadingCheckout;

    String nama, hargaStr;
    int jumlah = 1, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        // Inisialisasi
        namaObat = findViewById(R.id.namaObat);
        hargaObat = findViewById(R.id.hargaObat);
        jumlahObat = findViewById(R.id.jumlahObat);
        totalHarga = findViewById(R.id.totalHarga);
        gambarObat = findViewById(R.id.gambarObat);
        btnCheckout = findViewById(R.id.btnCheckout);
        loadingCheckout = findViewById(R.id.loadingCheckout);

        // Data dari intent
        nama = getIntent().getStringExtra("nama");
        hargaStr = getIntent().getStringExtra("harga");
        jumlah = getIntent().getIntExtra("jumlah", 1);
        gambar = getIntent().getIntExtra("gambar", R.drawable.paracetamol);

        if (nama == null || hargaStr == null) {
            Toast.makeText(this, "Data tidak lengkap!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Konversi harga string ke double
        double harga;
        try {
            hargaStr = hargaStr.replaceAll("[^\\d]", "");
            harga = Double.parseDouble(hargaStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Format harga tidak valid", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Tampilkan ke UI
        namaObat.setText(nama);
        hargaObat.setText("Harga: Rp" + formatter.format(harga));
        jumlahObat.setText(String.valueOf(jumlah));
        gambarObat.setImageResource(gambar);
        totalHarga.setText("Total: Rp" + formatter.format(harga * jumlah));

        // Proses Checkout
        btnCheckout.setOnClickListener(v -> {
            int jumlahInput;
            try {
                jumlahInput = Integer.parseInt(jumlahObat.getText().toString().trim());
                if (jumlahInput <= 0) throw new Exception();
            } catch (Exception e) {
                Toast.makeText(this, "Jumlah tidak valid", Toast.LENGTH_SHORT).show();
                return;
            }

            double total = harga * jumlahInput;
            totalHarga.setText("Total: Rp" + formatter.format(total));

            loadingCheckout.setVisibility(View.VISIBLE);
            btnCheckout.setEnabled(false);

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FirebaseAuth auth = FirebaseAuth.getInstance();
            String userId = auth.getCurrentUser() != null ? auth.getCurrentUser().getUid() : "guest";

            HashMap<String, Object> pesanan = new HashMap<>();
            pesanan.put("namaObat", nama);
            pesanan.put("harga", harga);
            pesanan.put("jumlah", jumlahInput);
            pesanan.put("total", total);
            pesanan.put("status", "Diproses");
            pesanan.put("tanggal", new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date()));
            pesanan.put("userId", userId);

            db.collection("pesanan")
                    .add(pesanan)
                    .addOnSuccessListener(docRef -> {
                        Toast.makeText(this, "Checkout berhasil!", Toast.LENGTH_SHORT).show();

                        // === TIMER PERUBAHAN STATUS ===
                        Handler handler = new Handler(Looper.getMainLooper());

                        // Setelah 5 detik ubah ke "Dikemas"
                        handler.postDelayed(() -> {
                            docRef.update("status", "Dikemas");

                            // Setelah 5 detik lagi ubah ke "Dikirim"
                            handler.postDelayed(() -> {
                                docRef.update("status", "Dikirim");

                                // Setelah 5 detik lagi ubah ke "Selesai"
                                handler.postDelayed(() -> {
                                    docRef.update("status", "Selesai");
                                }, 5000);

                            }, 5000);

                        }, 5000);
// ===============================


                        Intent intent = new Intent(check_out.this, PembayaranActivity.class);
                        startActivity(intent);
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Gagal menyimpan pesanan", Toast.LENGTH_SHORT).show();
                        loadingCheckout.setVisibility(View.GONE);
                        btnCheckout.setEnabled(true);
                    });
        });
    }
}
