package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rajvivah.modal.RegistrationModel;
import com.example.rajvivah.uservice.vivahAPIGetRegistration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityEditProfile extends AppCompatActivity {
    EditText et_userName1,et_father_name,et_mobile, et_mother_name, et_cast, et_gotra,
            et_address, et_village, et_city, et_pincode, et_state;
    TextView tv_usernameEdit, tv_EditPersonalInfo, tv_CastInfo, tv_EditAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        et_userName1 = findViewById(R.id.et_userName1);
        et_father_name = findViewById(R.id.et_father_name);
        et_mobile = findViewById(R.id.et_mobile);
        et_mother_name = findViewById(R.id.et_mother_name);
        et_cast = findViewById(R.id.et_cast);
        et_gotra = findViewById(R.id.et_gotra);
        et_address = findViewById(R.id.et_address);
        et_village = findViewById(R.id.et_village);
        et_city = findViewById(R.id.et_city);
        et_pincode = findViewById(R.id.et_pincode);
        et_state = findViewById(R.id.et_state);

        tv_usernameEdit = findViewById(R.id.tv_usernameEdit);
        tv_EditPersonalInfo = findViewById(R.id.tv_EditPersonalInfo);
        tv_CastInfo = findViewById(R.id.tv_CastInfo);
        tv_EditAddress = findViewById(R.id.tv_EditAddress);

        et_userName1.setFocusable(false);
        et_father_name.setFocusable(false);
        et_mobile.setFocusable(false);
        et_mother_name.setFocusable(false);
        et_cast.setFocusable(false);
        et_gotra.setFocusable(false);
        et_address.setFocusable(false);
        et_village.setFocusable(false);
        et_city.setFocusable(false);
        et_pincode.setFocusable(false);
        et_state.setFocusable(false);


        getUser();

        tv_usernameEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_userName1.setFocusable(true);
            }
        });

        tv_EditPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_father_name.setFocusable(true);
                et_mobile.setFocusable(true);
                et_mother_name.setFocusable(true);
            }
        });

        tv_CastInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_cast.setFocusable(true);
                et_gotra.setFocusable(true);
            }
        });

        tv_EditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_address.setFocusable(true);
                et_village.setFocusable(true);
                et_city.setFocusable(true);
                et_pincode.setFocusable(true);
                et_state.setFocusable(true);
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
                for(int i =0; i< getregisteredData.size(); i++)
                {
//                    responseTV.append("Data is: "+ getregisteredData.get(i).getName() +"\tAddress is: " + getregisteredData.get(i).getCandidate_address());
                    et_userName1.setText(getregisteredData.get(i).getName());
                    et_father_name.setText(getregisteredData.get(i).getFathername());
                    et_mobile.setText(getregisteredData.get(i).getRegisteruser_mob());
                    et_mother_name.setText(getregisteredData.get(i).getMothername());
                    et_cast.setText(getregisteredData.get(i).getCandidate_cast());
                    et_gotra.setText(getregisteredData.get(i).getCandidate_gotra());
                    et_address.setText(getregisteredData.get(i).getCandidate_address());
                    et_village.setText(getregisteredData.get(i).getCandidate_polstation());
                    et_city.setText(getregisteredData.get(i).getCandidate_dist());
                    et_pincode.setText(getregisteredData.get(i).getCandidate_pin());
                    et_state.setText(getregisteredData.get(i).getCandidate_state());



                }
            }

            @Override
            public void onFailure(Call<List<RegistrationModel>> call, Throwable t) {
                Log.d("TAG>>>>>>>", t.toString());
            }
        });

    }

}