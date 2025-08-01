package com.example.obatku;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class riwayat_pesanan extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PesananAdapter adapter;
    private List<Pesanan> pesananList;
    private ProgressBar loadingRiwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        setContentView(R.layout.activity_riwayat_pesanan);

        // Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi
        recyclerView = findViewById(R.id.recyclerRiwayat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pesananList = new ArrayList<>();
        adapter = new PesananAdapter(pesananList);
        recyclerView.setAdapter(adapter);
        loadingRiwayat = findViewById(R.id.loadingRiwayat);

        // Ambil user ID
        String userId = FirebaseAuth.getInstance().getCurrentUser() != null
                ? FirebaseAuth.getInstance().getCurrentUser().getUid()
                : null;

        if (userId == null) {
            Toast.makeText(this, "Pengguna belum login", Toast.LENGTH_SHORT).show();
            return;
        }

        loadingRiwayat.setVisibility(View.VISIBLE);

        // Ambil data pesanan dari Firestore
        FirebaseFirestore.getInstance()
                .collection("pesanan")
                .whereEqualTo("userId", userId)
                .get()
                .addOnSuccessListener(result -> {
                    pesananList.clear();
                    for (QueryDocumentSnapshot doc : result) {
                        Pesanan pesanan = doc.toObject(Pesanan.class);
                        pesananList.add(pesanan);
                    }
                    adapter.notifyDataSetChanged();
                    loadingRiwayat.setVisibility(View.GONE);
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Gagal memuat pesanan", Toast.LENGTH_SHORT).show();
                    loadingRiwayat.setVisibility(View.GONE);
                });
    }
}
