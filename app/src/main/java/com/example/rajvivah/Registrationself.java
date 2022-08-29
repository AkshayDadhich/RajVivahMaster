package com.example.rajvivah;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import android.util.Log;

import com.example.rajvivah.modal.RegistrationModel;

import java.util.List;

import com.example.rajvivah.modal.Userresponse;
import com.example.rajvivah.uservice.vivahAPIGetRegistration;

public class Registrationself extends AppCompatActivity {
    private EditText reg, name, mob, uid;
    List<Userresponse> myheroList;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;
    private static TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationself);
        reg = findViewById(R.id.reg);
        name = findViewById(R.id.name);
        mob = findViewById(R.id.mob);
        uid = findViewById(R.id.uid);
        responseTV = findViewById(R.id.responseTV);
        postDataBtn = findViewById(R.id.idBtnPost);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveUser();
               getUser(); //for get
                // validating if the text field is empty or not.
//               if (reg.getText().toString().isEmpty() && uid.getText().toString().isEmpty()) {
//                    Toast.makeText(Registrationself.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                // calling a method to post the data and passing our name and job.
//                postData(reg.getText().toString(),name.getText().toString(),mob.getText().toString() ,uid.getText().toString());

            }



        });
    }

    public void getUser() {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://vsrajawat-001-site2.btempurl.com/api/Sel/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vivahAPIGetRegistration apiGetRegistration = retrofit.create(vivahAPIGetRegistration.class);

        Call<List<RegistrationModel>> call = apiGetRegistration.getBiodata();

        call.enqueue(new Callback<List<RegistrationModel>>() {
            @Override
            public void onResponse(Call<List<RegistrationModel>> call, Response<List<RegistrationModel>> response) {
                List<RegistrationModel> getregisteredData = response.body();
                for(int i =0; i<= getregisteredData.size(); i++)
                {
                    responseTV.append("Data is: "+ getregisteredData.get(i).getName() +"\tAddress is: " + getregisteredData.get(i).getCandidate_address());
                }
            }

            @Override
            public void onFailure(Call<List<RegistrationModel>> call, Throwable t) {
                Log.d("TAG>>>>>>>", t.toString());
            }
        });

    }


//    private void postData(String registeruser_id ,String name,String register_uid,String registeruser_mo) {
//
//        // below line is for displaying our progress bar.
////        loadingPB.setVisibility(View.VISIBLE);
//
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        Retrofit retrofit = new Retrofit.Builder()
//        //http://vsrajawat-001-site2.btempurl.com/api/Selffirstreg
//
//                .baseUrl("http://vsrajawat-001-site2.btempurl.com/api/")
//                // as we are sending data in json format so
//                // we have to add Gson converter factory
//                .addConverterFactory(GsonConverterFactory.create())
//                // at last we are building our retrofit builder.
//                .build();
//        // below line is to create an instance for our retrofit api class.
//        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//
//        // passing data from our text fields to our modal class.
//        DataModal modal = new DataModal(registeruser_id ,name,register_uid,registeruser_mo);
//
//        // calling a method to create a post and passing our modal class.
//        Call<DataModal> call = retrofitAPI.createPost(modal);
//
//        // on below line we are executing our method.
//        call.enqueue(new Callback<DataModal>() {
//            @Override
//            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
//                // this method is called when we get response from our api.
//                Toast.makeText(Registrationself.this, "Data added to API", Toast.LENGTH_SHORT).show();
//
//                // below line is for hiding our progress bar.
////                loadingPB.setVisibility(View.GONE);
//                // on below line we are setting empty text
//                // to our both edit text.
//
//                // we are getting response from our body
//                // and passing it to our modal class.
//                DataModal responseFromAPI = response.body();
//
//                // on below line we are getting our data from modal class and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName();
//
//                // below line we are setting our
//                // string to our text view.
//                responseTV.setText(responseString);
//            }
//
//            @Override
//            public void onFailure(Call<DataModal> call, Throwable t) {
//                // setting text to our text view when
//                // we get error response from API.
//                responseTV.setText("Error found is : " + t.getMessage());
//            }
//        });
//    }



// public void getUser() {
//        Call<List<Userresponse>> userList = Apiclient.getUserservice().getallUser();
//        userList.enqueue(new Callback<List<Userresponse>>() {
//            @Override
//            public void onResponse(Call<List<Userresponse>> call, Response<List<Userresponse>> response) {
//                myheroList = new ArrayList<>();
//                myheroList.addAll(response.body());
//                String[] oneHeroes = new String[myheroList.size()];
//                if (response.isSuccessful()) {
//                    for (int i = 0; i < myheroList.size(); i++) {
//                        oneHeroes[i] = (i+1) +"  " +myheroList.get(i).getRegister_uid() +myheroList.get(i).getName();
//                        responseTV.setText(myheroList.get(i).getName());
//                        Toast.makeText(Registrationself.this, "Data " +myheroList.get(i).getName().toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    Log.e("sucesspppp", response.body().toString());
//
//                } else {
//                    Toast.makeText(Registrationself.this, "Data not added", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Userresponse>> call, Throwable t) {
//            }
//        });
//    }



}