package com.example.obatku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {

    private List<Pesanan> pesananList;

    public PesananAdapter(List<Pesanan> pesananList) {
        this.pesananList = pesananList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtStatus, txtNamaObat, txtTotal, txtTanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            txtNamaObat = itemView.findViewById(R.id.txtNamaObat);
            txtTotal = itemView.findViewById(R.id.txtTotal);
            txtTanggal = itemView.findViewById(R.id.txtTanggal);
        }
    }

    @NonNull
    @Override
    public PesananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gunakan layout item_pesanan.xml (bukan layout activity!)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pesanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananAdapter.ViewHolder holder, int position) {
        Pesanan pesanan = pesananList.get(position);

        // Format total ke bentuk rupiah
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Set data ke UI
        holder.txtStatus.setText(pesanan.getStatus());
        holder.txtNamaObat.setText(pesanan.getNamaObat());
        holder.txtTotal.setText("Total: Rp" + formatter.format(pesanan.getTotal()));
        holder.txtTanggal.setText(pesanan.getTanggal());


    }

    @Override
    public int getItemCount() {
        return pesananList.size();
    }
}
