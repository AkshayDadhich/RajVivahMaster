package com.example.rajvivah.webapi;

import com.example.rajvivah.uservice.Userservice;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private static Retrofit getRetrofit()
    {
        HttpLoggingInterceptor httpLoggingInterceptor =new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://vsrajawat-001-site2.btempurl.com/api/")
               // .baseUrl("https://localhost:7053/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static Userservice getUserservice(){
        Userservice userservice=getRetrofit().create(Userservice.class);
        return userservice;
    }
}
