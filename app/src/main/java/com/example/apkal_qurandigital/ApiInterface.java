package com.example.apkal_qurandigital;

import com.example.apkal_qurandigital.AlQuran;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("data")
    Call<List<AlQuran>> alquranku();

    @GET("surat/{a}")
    Call<List<Ayat>> getAyat(@Path("a") String nomor);
}
