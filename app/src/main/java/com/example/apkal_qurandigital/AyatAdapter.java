package com.example.apkal_qurandigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatHolder>{
    List<Ayat>ayatList;
    Activity activity;

    public AyatAdapter(List<Ayat>ayatList,Activity activity){
        this.ayatList=ayatList;
        this.activity=activity;
    }
    @NonNull
    @Override
    public AyatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_ayat,parent,false);
        return new AyatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatHolder holder, final int position) {
        holder.txtArab.setText(ayatList.get(position).getAr());
        holder.txtId.setText(ayatList.get(position).getId());
        holder.txtTr.setText(ayatList.get(position).getTr());
        holder.txtNo.setText(ayatList.get(position).getNomor());


    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }

    static class AyatHolder extends RecyclerView.ViewHolder{
        TextView txtArab,txtId,txtNo,txtTr;

        public AyatHolder(@NonNull View itemView) {
            super(itemView);
            txtArab=(TextView)itemView.findViewById(R.id.txt_Arab2);
            txtId=(TextView)itemView.findViewById(R.id.txt_Id2);
            txtNo=(TextView)itemView.findViewById(R.id.txt_No2);
            txtTr=(TextView)itemView.findViewById(R.id.txt_Tr2);
        }
    }
}
