package com.retetamortar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mortar(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context, Mortar.class);
        startActivity(intent);
    }
    public void beton(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context, BetonClasaExpunere.class);
        startActivity(intent);
    }
}
