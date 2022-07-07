package com.example.rajvivah;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.rajvivah.modal.Userresponse;
import com.example.rajvivah.webapi.Apiclient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    List<Userresponse> profileList;
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView gender_dropdown;
    TextView dobTextView;
    Button dobBtn;
    TextView birthTime;
    Button birthtime_button;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    private Button save;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView txtviewname = (TextView) view.findViewById(R.id.name);
        txtviewname.setText("Datas");

        Call<List<Userresponse>> userList = Apiclient.getUserservice().getallUser();

        userList.enqueue(new Callback<List<Userresponse>>() {
            @Override
            public void onResponse(Call<List<Userresponse>> call, Response<List<Userresponse>> response) {
                profileList = new ArrayList<>();
                profileList.addAll(response.body());
                String[] oneHeroes = new String[profileList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < profileList.size(); i++) {
                        oneHeroes[i] = (i+1) +"  " +profileList.get(i).getRegister_uid() +profileList.get(i).getName();
                        txtviewname.setText(profileList.get(i).getName());
                    }

                    Log.e("sucesspppp", response.body().toString());

                } else {

                }
            }
            @Override
            public void onFailure(Call<List<Userresponse>> call, Throwable t) {
            }
        });
           return view;
    }



   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }
    public void setText() {
        TextView view = (TextView) getView().findViewById(R.id.name);
        view.setText("Akshay");
    }*/


//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        myYear = year;
//        myday = day;
//        myMonth = month;
//        dobTextView.setText("Year: " + myYear +
//                " Month: " + myMonth +
//                " Day: " + myday );
//    }
//
//    @Override
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//        myHour = hourOfDay;
//        myMinute = minute;
//        birthTime.setText("Hour: " + myHour +
//                " Minute: " + myMinute);
//    }
public void getUser() {
    Call<List<Userresponse>> userList = Apiclient.getUserservice().getallUser();
    userList.enqueue(new Callback<List<Userresponse>>() {
        @Override
        public void onResponse(Call<List<Userresponse>> call, Response<List<Userresponse>> response) {
            profileList = new ArrayList<>();
            profileList.addAll(response.body());
            String[] oneHeroes = new String[profileList.size()];
            if (response.isSuccessful()) {
                for (int i = 0; i < profileList.size(); i++) {
                    oneHeroes[i] = (i+1) +"  " +profileList.get(i).getRegister_uid() +profileList.get(i).getName();
                    //Toast.makeText(ProfileFragment.this, "Data " +profileList.get(i).getName().toString(), Toast.LENGTH_SHORT).show();
              //profileList.get(i).getName().toString()

                }

                Log.e("sucesspppp", response.body().toString());

            } else {
               // Toast.makeText(ProfileFragment.this, "Data not added", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFailure(Call<List<Userresponse>> call, Throwable t) {
        }
    });

}

}