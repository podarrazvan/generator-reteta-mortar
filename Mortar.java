package com.retetamortar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Mortar extends AppCompatActivity {

    RecyclerView tipuriDeMortar;
    CheckBox m_zidarie, m_tencuiala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortar);
        tipuriDeMortar = findViewById(R.id.tip_mortar);
        m_tencuiala = findViewById(R.id.m_zidarie);
        m_zidarie = findViewById(R.id.m_tencuiala);

        m_zidarie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mzvarpasta();
            }

        });
        m_tencuiala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mzvarhidratat();
            }
        });


    }
    public void mzvarpasta(){
        String[] m_Mortar = {"M 10 Z \n Clasa M 1\n var - ciment",
                "M 25 Z \n Clasa M 2,1\n ciment - var","M 50 Z \n Clasa M 5\n ciment - var",
                "M 100 Z \n Clasa M 10\n ciment - var","M 100 Z \n Clasa M 10\n ciment"};
        MarcaMortar marcaMortar = new MarcaMortar(m_Mortar);
        tipuriDeMortar.setAdapter(marcaMortar);
        tipuriDeMortar.setLayoutManager(new LinearLayoutManager(this));


    }
    public void mzvarhidratat(){
        String[] m_Mortar = {"M 4 T\n Clasa CS 1\n var",
                "M 10 T \n Clasa CS 1\n var - ciment","M 25 T \n Clasa CS 2\n var - ciment",
                "M 50 T \n Clasa CS 3\n ciment - var","M 100 T \n Clasa CS 4\n ciment - var",
                "M 100 T \n Clasa CS 4\n ciment"};
        MarcaMortar marcaMortar = new MarcaMortar(m_Mortar);
        tipuriDeMortar.setAdapter(marcaMortar);
        tipuriDeMortar.setLayoutManager(new LinearLayoutManager(this));
    }
}
