package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.Userrequest;
import com.example.rajvivah.modal.Userresponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Userservice {

    // public String registeruser_id ,name,registeruser_mob,register_uid;
    @POST("api/Testapi")
    Call<Userresponse> saveUser(@Body Userrequest userrequest);

    @GET("Testapi")
    Call<List<Userresponse>> getallUser();
}
