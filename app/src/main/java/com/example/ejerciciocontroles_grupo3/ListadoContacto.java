package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ListadoContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contacto);
        Toast.makeText(this,"este es listado contacto",Toast.LENGTH_SHORT).show();
        Contacto contacto=(Contacto)getIntent().getSerializableExtra("contacto");
        if(contacto!=null)
        Toast.makeText(this,contacto.toString(),Toast.LENGTH_LONG).show();

    }
}