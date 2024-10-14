package com.ph.edu.usc.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener
{

    Button btnCounter;
    Spinner spinProg;
    Spinner spinCustom;

    String[] courses = {"C Programming", "Java", "Android", "Pyhton", "JavaScript", "Angular", "Spring", "React"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinProg = (Spinner) findViewById(R.id.spinprogramming);
        spinCustom = (Spinner)findViewById(R.id.spincustom);
        btnCounter = (Button)findViewById(R.id.btncounter);
        spinProg.setOnItemSelectedListener(this);
        spinCustom.setOnItemSelectedListener(this);


        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counterIntent = new Intent(MainActivity.this, CounterActivity.class);
                startActivity(counterIntent);
            }
        });

        //creating our array instance of our list of courses
        ArrayAdapter arrayCourses = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);

        //setting a simple layout resources for each of the spinner
        arrayCourses.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //setting adapter arrayCourses to our spinner to bind the data
        spinProg.setAdapter(arrayCourses);

        //this can be removed
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), courses[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}