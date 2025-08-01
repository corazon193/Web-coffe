package com.example.obatku;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class daftarobat extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ObatAdapter adapter;
    private List<Obat> daftarObat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_daftar_obat);

        // Atur padding agar tidak tertutup status bar / navigasi bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerObat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tambahkan data dummy
        daftarObat = new ArrayList<>();
        daftarObat.add(new Obat("Amoxicilin", "Amoxicillin trihydrate dapat menangani infeksi pada sinus (sinusitis). Biasanya infeksi terjadi karena cairan sinus ditumbuhi oleh bakteri, yang kemudian menyebabkan infeksi. Selain itu, obat ini juga efektif untuk mengobati faringitis (radang tenggorokan) dan tonsilitis (radang amandel) bakteri.,", "Rp10,000", 45, R.drawable.amoxicilin));
        daftarObat.add(new Obat("Paracetamol", "Paracetamol atau acetaminophen adalah obat yang berfungsi untuk meredakan demam dan nyeri, termasuk untuk mengobati nyeri haid hingga sakit gigi yang tersedia dalam bentuk tablet, sirup, tetes, suppositoria dan infus.", "Rp20,000", 45, R.drawable.paracetamol));
        daftarObat.add(new Obat("Cettrizine", "Cetirizine adalah obat untuk meredakan gejala akibat reaksi alergi, seperti mata berair, bersin-bersin, hidung meler, atau gatal di kulit, tenggorokan, maupun hidung. ", "Rp30,000", 30, R.drawable.cettrizine));
        daftarObat.add(new Obat("bodrek", "BODREX merupakan obat dengan kandungan Paracetamol dan Caffeine. Obat ini digunakan untuk meringankan sakit kepala, sakit gigi, dan menurunkan demam.", "Rp40,000", 45, R.drawable.bodrek));
        daftarObat.add(new Obat("oskadon", "Oskadon mengandung paracetamol obat yang memiliki efek sebagai antipiretik sekaligus analgesik,", "Rp50,000", 45, R.drawable.oskadon));
        daftarObat.add(new Obat("panadol", "Panadol adalah obat yang bermanfaat untuk menurunkan demam serta meredakan nyeri, seperti sakit kepala, sakit gigi, atau sakit pada otot", "Rp60,000", 30, R.drawable.panadol));
        daftarObat.add(new Obat("lansoprazole", "Lansoprazole merupakan obat dari golongan Penghambat Pompa Proton (PPI) yang diindikasikan untuk penatalaksanaan kondisi medis terkait hipersekresi asam lambung ", "Rp70,000", 30, R.drawable.lansoprazole));


        adapter = new ObatAdapter(this, daftarObat);
        recyclerView.setAdapter(adapter);
    }
}
