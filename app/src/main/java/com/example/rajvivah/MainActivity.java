package com.example.rajvivah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        Intent intent = new Intent(this, Registrationself.class);
        startActivity(intent);
*/

        //Fragment Part start here
        bottomNavigationView = findViewById(R.id.bnView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id ==  R.id.nav_profile){
                    loadFragment(new ProfileFragment(), false);

                }else if(id == R.id.nav_matches){
                    loadFragment(new MatchesFragment(), false);
                }else if(id == R.id.nav_chat){
                    loadFragment(new ChatFragment(), false);
                }else if(id == R.id.nav_notifications){
                    loadFragment(new NotificationsFragment(), false);
                }else
                    loadFragment(new MatchesFragment(), true);


                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_matches);

    }


    public void loadFragment(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag)
            fragmentTransaction.add(R.id.container, fragment);
        else
            fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}