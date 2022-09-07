package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
        String nombre=((EditText)findViewById(R.id.et_Nombre)).getText().toString();
        String apellido=((EditText)findViewById(R.id.et_Apellido)).getText().toString();
        String telefono=((EditText)findViewById(R.id.et_Telefono)).getText().toString();
        String email=((EditText)findViewById(R.id.et_Email)).getText().toString();
        String direccion=((EditText)findViewById(R.id.et_Direccion)).getText().toString();
        String fecha=((EditText)findViewById(R.id.et_FechaNacimiento)).getText().toString();
        Contacto contacto=new Contacto(nombre,apellido,telefono,email,direccion,fecha);

        Intent intent=new Intent(this,FormularioMasDatosContacto.class);
        intent.putExtra("contacto", contacto);
        startActivity(intent);
    }

}