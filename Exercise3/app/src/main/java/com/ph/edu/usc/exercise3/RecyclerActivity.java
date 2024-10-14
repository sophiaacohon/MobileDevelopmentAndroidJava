package com.ph.edu.usc.exercise3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    ExamAdapter adapter;
    RecyclerView rvList;
    ClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);

        List<ExamModel> list = new ArrayList<>();
        list = getData();

        rvList = findViewById(R.id.rvlist);

        adapter = new ExamAdapter(list, getApplicationContext(), listener);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));


    }

    private List<ExamModel> getData(){
        List<ExamModel> list = new ArrayList<>();
        list.add(new ExamModel("Pre Midterm", "October 11 2024", "Good Bye"));
        list.add(new ExamModel("Midterm", "November 01 2024", "Eyyy"));
        return list;

    }
}