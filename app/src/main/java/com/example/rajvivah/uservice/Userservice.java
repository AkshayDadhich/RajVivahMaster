package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.Selfregistrationresponse;
import com.example.rajvivah.modal.Userresponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Userservice {
    @FormUrlEncoded
    // public String registeruser_id ,name,registeruser_mob,register_uid;
    @POST("Sel")
    Call<Userresponse> saveUser(
                                @Field("registeruser_id") String registeruser_id,
                                @Field("name") String name,
                                @Field("registeruser_mob") String registeruser_mob,
                                @Field("register_uid") String register_uid
                                );
    @GET("Sel?name=fffffffffff")
    Call<List<Selfregistrationresponse>> getallUser();
}
