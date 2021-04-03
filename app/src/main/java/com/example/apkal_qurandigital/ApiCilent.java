package com.example.apkal_qurandigital;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCilent {

    private  static  final  String BASE_URL="https://api.npoint.io/99c279bb173a6e28359c/";
    private static Retrofit retrofit;
    public static Retrofit ambilDatanyaaaa(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
