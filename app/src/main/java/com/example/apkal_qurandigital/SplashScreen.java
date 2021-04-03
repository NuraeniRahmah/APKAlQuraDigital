package com.example.apkal_qurandigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    ApiInterface apiInterface;
    List<AlQuran> alQuranList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilDatanya().execute();
    }
    private class AmbilDatanya extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface=ApiCilent.ambilDatanyaaaa().create(ApiInterface.class);
            Call<List<AlQuran>> call=apiInterface.alquranku();
            call.enqueue(new Callback<List<AlQuran>>() {
                @Override
                public void onResponse(Call<List<AlQuran>> call, Response<List<AlQuran>> response) {
                    alQuranList=response.body();

                    Intent kirim = new Intent(SplashScreen.this,MainActivity.class);
                    kirim.putExtra("dataku", (Serializable) alQuranList);
                    startActivity(kirim);
                    finish();
                }

                @Override
                public void onFailure(Call<List<AlQuran>> call, Throwable t) {
                    Toast.makeText(SplashScreen.this,"tidak berhasil ambil data",Toast.LENGTH_LONG).show();
                }
            });
            return null;
        }
    }
}
