package com.example.apkal_qurandigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity<ApiInterface> extends AppCompatActivity {
    RecyclerView rvQuran;
    RecyclerView.LayoutManager layoutnya;
    List<AlQuran>dataQuran;
    ApiInterface apiInterface;
    AlQuranAdapter adapternya;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvQuran=(RecyclerView)findViewById(R.id.daftar_quran);
        layoutnya=new LinearLayoutManager(this);
        rvQuran.setLayoutManager(layoutnya);
        Intent intent=getIntent();
        dataQuran= (List<AlQuran>) intent.getSerializableExtra("dataku");
        adapternya=new AlQuranAdapter(dataQuran,MainActivity.this);
        rvQuran.setAdapter(adapternya);



    }
}

