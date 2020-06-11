package com.retetamortar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ThreadPoolExecutor;

public class BetonClasaExpunere extends AppCompatActivity {
    String[] ciment;
    EditText temp;
    Button calculeaza, sensibil, insensibil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beton_clasa_expunere);

    }
    public void xf1(View v){

        ciment = new String[]{"CEM I", "SR I", "CD 40", "IA 52,5", "CEM II", "CEM III"};
        temperatura_turnare(ciment);
    }
    public void xf2(View v){

         ciment = new String[]{"CEM I", "SR I", "CD 40", "IA 52,5"};


    }
    public void xf3(View v){
        ciment = new String[]{"CEM I", "SR I", "CD 40", "IA 52,5","CEM III"};
    }
    public void xf4(View v){
        ciment = new String[]{"CEM I", "SR I", "CD 40", "IA 52,5"};
    }
    public void temperatura_turnare(final String[] cimnet){
        setContentView(R.layout.activity_temperatura_turnare);
        temp = findViewById(R.id.int_temp);
        calculeaza = findViewById(R.id.buton_calculeaza);
        calculeaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int temperatura = Integer.parseInt(temp.getText().toString());
                    gasire_ciment(temperatura, ciment);
                }catch (Exception e){
                    Context context = v.getContext();
                    Toast.makeText(context,  "Cred ca nu ai introdus un numar...", Toast.LENGTH_LONG).show();
                }



    }
});
    };
    public void gasire_ciment(int temperatura, final String[] ciment){
        if (temperatura <= 5){
            for(int i = 0; i < ciment.length; i ++){
                if(ciment[i].equals("CEM I")){
                    String tip_ciment = "42,5 N/R";
                }else{
                    String tip_ciment = "32,5 N/R";
                }
            }
        }
        else if(temperatura > 5 && temperatura <=25) {
            temp.setVisibility(View.INVISIBLE);
            calculeaza.setVisibility(View.INVISIBLE);
            sensibil = findViewById(R.id.sensibil);
            insensibil = findViewById(R.id.insensibil);
            sensibil.setVisibility(View.VISIBLE);
            insensibil.setVisibility(View.VISIBLE);
            sensibil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tip_ciment = "32,5 N/R";


                }
            });
            insensibil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0; i < ciment.length; i ++){
                        if(ciment[i].equals("CEM II")){
                            String tip_ciment = "32,5 N/R";

                        }else{
                            String tip_ciment = "42,5 N/R";
                        }
                    }
                }

            });
        }else if(temperatura > 25){
            for(int i = 0; i < ciment.length; i ++){
                if(ciment[i].equals("CEM II") || ciment[i].equals("CEM III")){
                    String tip_ciment = "32,5 N/R";
                }else if(ciment[i].equals("CEM I")){
                    String tip_ciment = "42,5 N/R";
                }
            }

        }
    }
}