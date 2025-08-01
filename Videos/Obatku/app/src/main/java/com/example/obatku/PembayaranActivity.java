// com.example.obatku.PembayaranActivity.java
package com.example.obatku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PembayaranActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnKonfirmasi;
    FirebaseFirestore db;
    String metodePembayaran = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        radioGroup = findViewById(R.id.radioGroupPembayaran);
        btnKonfirmasi = findViewById(R.id.btnKonfirmasiPembayaran);
        db = FirebaseFirestore.getInstance();

        btnKonfirmasi.setOnClickListener(view -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Pilih metode pembayaran", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadio = findViewById(selectedId);
            metodePembayaran = selectedRadio.getText().toString();

            // Simpan data ke Firestore
            simpanPembayaran();
        });
    }

    private void simpanPembayaran() {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Map<String, Object> data = new HashMap<>();
        data.put("userId", userId);
        data.put("metode", metodePembayaran);
        data.put("timestamp", System.currentTimeMillis());

        db.collection("pembayaran")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Pembayaran berhasil dikonfirmasi", Toast.LENGTH_SHORT).show();
                    // Pindah ke halaman riwayat pesanan
                    startActivity(new Intent(this, riwayat_pesanan.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Gagal menyimpan pembayaran", Toast.LENGTH_SHORT).show());
    }
}
