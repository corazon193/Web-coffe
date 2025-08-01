package com.example.obatku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObatAdapter extends RecyclerView.Adapter<ObatAdapter.ViewHolder> {

    private Context context;
    private List<Obat> obatList;

    // ✅ Constructor yang benar, menerima Context dan List
    public ObatAdapter(Context context, List<Obat> list) {
        this.context = context;
        this.obatList = list;
    }

    // ✅ ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgObat;
        TextView txtNama, txtDeskripsi, txtHarga, txtStok;

        public ViewHolder(View itemView) {
            super(itemView);
            imgObat = itemView.findViewById(R.id.imgObat);
            txtNama = itemView.findViewById(R.id.txtNamaObat);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);
            txtHarga = itemView.findViewById(R.id.txtHarga);
            txtStok = itemView.findViewById(R.id.txtStok);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_obat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Obat obat = obatList.get(position);

        holder.imgObat.setImageResource(obat.getGambar());
        holder.txtNama.setText(obat.getNama());
        holder.txtDeskripsi.setText(obat.getDeskripsi());
        holder.txtHarga.setText(obat.getHarga());
        holder.txtStok.setText("Stock: " + obat.getStok());

        // ✅ Handle klik item -> buka DetailObat
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailObat.class);
            intent.putExtra("nama", obat.getNama());
            intent.putExtra("deskripsi", obat.getDeskripsi());
            intent.putExtra("harga", obat.getHarga());
            intent.putExtra("stok", obat.getStok());
            intent.putExtra("gambar", obat.getGambar());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return obatList.size();
    }
}
