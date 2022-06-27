package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rajvivah.adapter.CourseAdapter;
import com.example.rajvivah.model.CourseModel;

import java.util.ArrayList;

public class Card_Recycler_View extends AppCompatActivity {

    private RecyclerView courseRV;

    // Arraylist for storing data
    private ArrayList<CourseModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler_view);
        courseRV = findViewById(R.id.idRVCourse);

        // here we have created new array list and added data to it.
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("DSA in Java", 4, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("Java Course", 3, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("C++ COurse", 4, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("DSA in C++", 4, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("Java for Android", 4, R.drawable.girl));
        courseModelArrayList.add(new CourseModel("HTML and CSS", 4, R.drawable.girl));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }
}