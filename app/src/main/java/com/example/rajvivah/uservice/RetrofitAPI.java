package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.DataModal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("Selffirstreg")

    //on below line we are creating a method to post our data.
    Call<DataModal> createPost(@Body DataModal dataModal);
}