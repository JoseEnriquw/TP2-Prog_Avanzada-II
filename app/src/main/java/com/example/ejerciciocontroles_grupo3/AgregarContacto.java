package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class AgregarContacto extends AppCompatActivity {

    private Spinner _spinnerTelefono;
    private Spinner _spinnerEmail;
    private static final String[] _spinnerDatos = {"Casa","Trabajo","Movil"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        Toast.makeText(this,"este es agregar contacto",Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,_spinnerDatos);
        _spinnerTelefono=(Spinner)findViewById(R.id.sp_telefono);
        _spinnerTelefono.setAdapter(adapter);

        _spinnerEmail=(Spinner)findViewById(R.id.sp_email);
        _spinnerEmail.setAdapter(adapter);
    }

    public void Continuar(View view)
    {
        Contacto contacto=new Contacto();

        Intent intent=new Intent(this,ListadoContacto.class);
        intent.putExtra("contacto", contacto);
        startActivity(intent);
    }

}