package com.example.apkal_qurandigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hal3 extends AppCompatActivity {
    TextView txtArab,txtTr,txtId,txtNo;
    Ayat ayat;
    ApiInterface apiInterface2;
    List<Ayat> daftarAyat;
    AyatAdapter a;
    RecyclerView daftarAyatnya;
    RecyclerView.LayoutManager layoutAyat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal3);
        daftarAyatnya=(RecyclerView)findViewById(R.id.daftar_ayat);
        layoutAyat=new LinearLayoutManager(this);
        daftarAyatnya.setLayoutManager(layoutAyat);
        Intent intent = getIntent();
        String yyy = intent.getStringExtra("suratnya");
        apiInterface2=ApiCilent.ambilDatanyaaaa().create(ApiInterface.class);
        Call<List<Ayat>> listCall=apiInterface2.getAyat(yyy);
        listCall.enqueue(new Callback<List<Ayat>>() {
            @Override
            public void onResponse(Call<List<Ayat>> call, Response<List<Ayat>> response) {
                daftarAyat=response.body();
                a=new AyatAdapter(daftarAyat,hal3.this);
                daftarAyatnya.setAdapter(a);
            }

            @Override
            public void onFailure(Call<List<Ayat>> call, Throwable t) {

            }
        });
    }
}
