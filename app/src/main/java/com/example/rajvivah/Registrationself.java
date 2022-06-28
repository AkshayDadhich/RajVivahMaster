package com.example.rajvivah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rajvivah.modal.Userresponse;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rajvivah.modal.Selfregistrationrequest;
import com.example.rajvivah.modal.Selfregistrationresponse;
import com.example.rajvivah.modal.Userrequest;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Registrationself extends AppCompatActivity {
    List<Selfregistrationresponse> selfregistrationresponseList;
    TextInputLayout txtregisteruser_id, txtname, txtregisteruser_mob, txtregister_uid;
    public String registeruser_id, name, registeruser_mob, register_uid;
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView gender_dropdown;
    TextView dobTextView;
    Button dobBtn;
    TextView birthTime;
    Button birthtime_button;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationself);
        txtname=findViewById(R.id.name);
        txtregisteruser_mob=findViewById(R.id.registeruser_mob);
        registeruser_id = "11111111";
        name= String.valueOf(txtname.getEditText().getText()).toString();
        registeruser_mob= String.valueOf(txtregisteruser_mob.getEditText().getText()).toString();
        register_uid = "99999";
        //Save Button
        save = (Button) findViewById(R.id.save_Button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // saveUser(createRequest());
                getUser();
            }
        });
    }


    public Userrequest createRequest() {
        Userrequest userrequest = new Userrequest();
        userrequest.setRegisteruser_id("11111111");
        userrequest.setName(String.valueOf(txtname.getEditText().getText()));
        userrequest.setRegisteruser_mob(String.valueOf(txtregisteruser_mob.getEditText().getText()).toString());
        userrequest.setRegister_uid("99999");
        return userrequest;
    }

    public void saveUser(Userrequest userrequest) {
        Call<Userresponse> userresponseCall = Apiclient.getUserservice().saveUser(
                registeruser_id.toString(),
                String.valueOf(txtname.getEditText().getText()),
                String.valueOf(txtregisteruser_mob.getEditText().getText()).toString(),
                register_uid

        );
        userresponseCall.enqueue(new Callback<Userresponse>() {
            @Override
            public void onResponse(@NonNull Call<Userresponse> call, @NonNull Response<Userresponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Registrationself.this, "Data added Sucessfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registrationself.this, "Request Failed", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<Userresponse> call, Throwable t) {
                Toast.makeText(Registrationself.this, "Request Failed" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getUser() {

        Call<List<Selfregistrationresponse>> userList = Apiclient.getUserservice().getallUser();
        userList.enqueue(new Callback<List<Selfregistrationresponse>>() {
            @Override
            public void onResponse(Call<List<Selfregistrationresponse>> call, Response<List<Selfregistrationresponse>> response) {
                selfregistrationresponseList = new ArrayList<>();
                selfregistrationresponseList.addAll(response.body());
                String[] oneHeroes = new String[selfregistrationresponseList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < selfregistrationresponseList.size(); i++) {
                        oneHeroes[i] = (i+1) +"  " + selfregistrationresponseList.get(i).getRegisteruser_id() + selfregistrationresponseList.get(i).getName() ;

                        Toast.makeText(Registrationself.this, "Data " +selfregistrationresponseList.get(i).getRegisteruser_id()+selfregistrationresponseList.get(i).getName().toString(), Toast.LENGTH_SHORT).show();

                    }

                    Log.e("sucesspppp", response.body().toString());
                    // Toast.makeText(Registeroffence.this, "Data " +response.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registrationself.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Selfregistrationresponse>> call, Throwable t) {
            }
        });
    }


}