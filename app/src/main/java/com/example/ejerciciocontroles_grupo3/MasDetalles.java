package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MasDetalles extends AppCompatActivity {

    private String Nombre;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_detalles);

        Nombre= getIntent().getStringExtra("name");

        tv1 = (TextView)findViewById(R.id.TxtNombre);
        tv1.setText(Nombre);
    }
}