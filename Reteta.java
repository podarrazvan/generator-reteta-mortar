package com.retetamortar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reteta extends AppCompatActivity {
    TextView rezultat;
    EditText Volum;
    Button calculeaza_buton;
    String mortarSelectat;
    double volum;
    String[] m_zidarie = {"M 10 Z \n Clasa M 1\n var - ciment",
            "M 25 Z \n Clasa M 2,1\n ciment - var","M 50 Z \n Clasa M 5\n ciment - var",
            "M 100 Z \n Clasa M 10\n ciment - var","M 100 Z \n Clasa M 10\n ciment"};
    String[] m_tencuiala = {"M 4 T\n Clasa CS 1\n var",
            "M 10 T \n Clasa CS 1\n var - ciment","M 25 T \n Clasa CS 2\n var - ciment",
            "M 50 T \n Clasa CS 3\n ciment - var","M 100 T \n Clasa CS 4\n ciment - var",
            "M 100 T \n Clasa CS 4\n ciment"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reteta);
        Bundle extras = getIntent().getExtras();
        mortarSelectat = extras.getString("mortarSelectat");
        rezultat = findViewById(R.id.rezultat);
        Volum = findViewById(R.id.volum);
        calculeaza_buton = findViewById(R.id.calculeaza_buton);
        calculeaza_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valoare = Volum.getText().toString();
                volum = Double.parseDouble(valoare);
                calculare(volum);
            }
        });
}
    public void calculare(double volum){
        double ciment1,ciment2, nisip, var;
        Boolean gasit = false;
        for (int i = 0; i < m_zidarie.length; i++) {
            if (mortarSelectat.equals(m_zidarie[i])) {
                switch (i) {
                    case 0:
                       ciment1 = (volum * 117)/1000;
                       ciment2 = (volum * 112)/1000;
                       nisip = (volum* 1660)/1000;
                       var = (volum * 130)/1000;

                        break;
                    case 1:
                        ciment1 = (volum * 165)/1000;
                        ciment2 = (volum * 157)/1000;
                        nisip = (volum* 1660)/1000;
                        var = (volum * 130)/1000;

                        break;
                    case 2:
                        ciment1 = (volum * 230)/1000;
                        ciment2 = (volum * 219)/1000;
                        nisip = (volum* 1660)/1000;
                        var = (volum * 115)/1000;
                        break;
                    case 3:
                        ciment1 = 0;
                        ciment2 = (volum * 275)/1000;
                        nisip = (volum* 1660)/1000;
                        var = (volum * 75)/1000;
                        break;
                    case 4:
                        ciment1 = 0;
                        ciment2 = (volum * 323)/1000;
                        nisip = (volum* 1660)/1000;
                        var = 0;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
                    rezultat.setText(
                            "Ai nevoie de " + ciment1 + " kg de ciment 32,5 sau " + ciment2
                                    + " kg de ciment 52,5/42,5\n" + var + "kg de var pasta sau hidratat\n" + nisip + "kg de nisip"
                    );
            gasit = true;
            }else{
                gasit = false;
            }
        }
        if(gasit == false){
            for (int i = 0; i < m_tencuiala.length; i++) {
                if (mortarSelectat.equals(m_tencuiala[i])) {
                    switch (i) {
                        case 0:
                            ciment1 = 0;
                            ciment2 = 0;
                            nisip = (volum* 1500)/1000;
                            var = (volum * 500)/1000;

                            break;
                        case 1:
                            ciment1 = (volum * 145)/1000;
                            ciment2 = (volum * 138)/1000;
                            nisip = (volum* 1500)/1000;
                            var = (volum * 325)/1000;

                            break;
                        case 2:
                            ciment1 = (volum * 180)/1000;
                            ciment2 = (volum * 171)/1000;
                            nisip = (volum* 1500)/1000;
                            var = (volum * 260)/1000;
                            break;
                        case 3:
                            ciment1 = (volum * 290)/1000;
                            ciment2 = (volum * 275)/1000;
                            nisip = (volum* 1450)/1000;
                            var = (volum * 110)/1000;
                            break;
                        case 4:
                            ciment1 = 0;
                            ciment2 = (volum * 370)/1000;
                            nisip = (volum* 1350)/1000;
                            var = (volum* 60)/1000;
                            break;
                        case 5:
                            ciment1 = 0;
                            ciment2 = (volum * 385)/1000;
                            nisip = (volum* 1550)/1000;
                            var = 0;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + i);
                    }
                    rezultat.setText(
                            "Ai nevoie de " + ciment1 + " kg de ciment 32,5 sau " + ciment2
                                    + " kg de ciment 52,5/42,5\n" + var + "kg de var pasta sau hidratat\n" + nisip + "kg de nisip"
                    );
                    gasit = true;
                }else{
                    gasit = false;
                }
            }
        }
    }
}
