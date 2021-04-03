package com.example.apkal_qurandigital;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlQuranAdapter extends RecyclerView.Adapter<AlQuranAdapter.QuranHolder> {
  List<AlQuran> quranList;
    Activity activity;

    public AlQuranAdapter(List<AlQuran> quranList, Activity activity) {
        this.quranList = quranList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public QuranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_alquran2,parent,false);
        return new QuranHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuranHolder holder, final int position) {
        holder.txtSurat.setText(quranList.get(position).getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlQuran kirimkuran=quranList.get(position);
                Intent pindah=new Intent(activity,hal2.class);
                pindah.putExtra("kiriman",kirimkuran);
                v.getContext().startActivity(pindah);

            }
        });


    }

    @Override
    public int getItemCount() {
        return quranList.size();
    }

    static class QuranHolder extends RecyclerView.ViewHolder {
        TextView txtSurat;

        public QuranHolder(View itemView) {
            super(itemView);
            txtSurat=(TextView)itemView.findViewById(R.id.txt_suratadap);


        }

    }
}
