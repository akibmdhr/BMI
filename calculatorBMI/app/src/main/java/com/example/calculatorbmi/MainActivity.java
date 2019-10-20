package com.example.calculatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText wt,ht;
    Button calc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        wt = findViewById(R.id.weight);
        ht = findViewById(R.id.height);
        calc = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        calc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String weightstring = wt.getText().toString();
        String heightstring = ht.getText().toString();

        if(TextUtils.isEmpty(heightstring)){
            ht.setError("Please enter your height");
            ht.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(weightstring)){
            wt.setError("Please enter your weight");
            wt.requestFocus();
            return;
        }

        if (heightstring  != null && !"".equals(heightstring )
                && weightstring != null && !"".equals(weightstring)) {
            float heightValue = Float.parseFloat(heightstring ) / 100*100;
            float weightValue = Float.parseFloat(weightstring);

            float bmi = weightValue / (heightValue * heightValue);


            displayBMI(bmi);


        }
    }

    public void displayBMI (float bmi){
        String type;
        if (bmi < 18.5) {
            type = " underweight";
        } else if (bmi >=18.5 && bmi <= 24.9) {
           type = "Normalweight";

        } else {
            type ="Overweight";
        }
        result.setText(String.valueOf("BMI value ="+ bmi + "\n\n" + type));
    }
}


