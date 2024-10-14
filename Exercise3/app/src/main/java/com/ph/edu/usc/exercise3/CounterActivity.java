package com.ph.edu.usc.exercise3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CounterActivity extends AppCompatActivity {

    TextView txtNum;
    Button btnMain, btnMinus, btnPlus;
    int counter;

    private void initCounter(){
        counter = 0;
        txtNum.setText(String.valueOf(counter));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);

        txtNum = (TextView)findViewById(R.id.txtnum);
        btnMain = (Button)findViewById(R.id.btnmain);
        btnMinus = (Button)findViewById(R.id.btnminus);
        btnPlus = (Button)findViewById(R.id.btnplus);

        btnMinus.setBackgroundColor(Color.WHITE);
        btnPlus.setBackgroundColor(Color.WHITE);
        initCounter();

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counterMain = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(counterMain);
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numMinus = txtNum.getText().toString();
                if(counter > 0){
                    counter--;
                    txtNum.setText(String.valueOf(counter));
                }
                else{
                    txtNum.setText("0");
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                txtNum.setText(String.valueOf(counter));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}