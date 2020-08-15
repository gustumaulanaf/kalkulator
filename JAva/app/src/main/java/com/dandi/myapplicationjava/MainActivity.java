package com.dandi.myapplicationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    EditText valueA, valueB;
    Button submit;
    TextView result;
    List<String> listoperasional = Arrays.asList("Pengurangan", "Penjumlahan", "Perkalian", "Pembagian");
    String operasional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spOperasional);
        valueA = findViewById(R.id.etA);
        valueB = findViewById(R.id.etB);
        submit = findViewById(R.id.btHitung);
        submit.setOnClickListener(this);
        result = findViewById(R.id.tvHasil);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listoperasional);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                operasional = listoperasional.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            if (!!valueA.getText().toString().isEmpty() && !valueB.getText().toString().isEmpty()) {
                Float floatA = Float.valueOf(valueA.getText().toString());
                Float floatB = Float.valueOf(valueB.getText().toString());
                if (operasional.equals("Penjumlahan")) {
                    result.setText(String.valueOf(floatA + floatB));
                } else if (operasional.equals("Pengurangan")) {
                    result.setText(String.valueOf(floatA - floatB));

                } else if (operasional.equals("Pembagian")) {
                    result.setText(String.valueOf(floatA / floatB));

                } else if (operasional.equals("Perkalian")) {
                    result.setText(String.valueOf(floatA * floatB));
                }
            }
        }
    }

    void presentasi() {
        int angka = 10;
        String huruf = String.valueOf(angka);
        double db = (double) angka;
        float flt = (float) angka;
        System.out.println(flt);

        for (int i=0;i<listoperasional.size();i++){

        }
    }

    String testing(){
        return "Hello";
    }
    void test(String a, String b){

    }
}