package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MasDetalles extends AppCompatActivity {

    private Contacto contacto;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_detalles);

        contacto=(Contacto)getIntent().getSerializableExtra("contacto");
        tv1 = (TextView)findViewById(R.id.TxtNombre);
        tv1.setText(contacto.getNombre());
        tv1 = (TextView)findViewById(R.id.TxtApellido);
        tv1.setText(contacto.getApellido());
        tv1 = (TextView)findViewById(R.id.TxtDireccion);
        tv1.setText(contacto.getDireccion());
        tv1 = (TextView)findViewById(R.id.TxtEmail);
        tv1.setText(contacto.getEmail().toString());
        tv1 = (TextView)findViewById(R.id.TxtTelefono);
        tv1.setText(contacto.getTelefono().toString());
        tv1 = (TextView)findViewById(R.id.TxtFechaNacimiento);
        tv1.setText(contacto.getFechaNacimiento());
        tv1 = (TextView)findViewById(R.id.TxtIntereses);
        tv1.setText(getStringIntereses(contacto));
        tv1 = (TextView)findViewById(R.id.TxtNivelEstudios);
        tv1.setText(contacto.getNivelEstudioAlcanzado());

    }
    public String getStringIntereses(Contacto contacto){
        String stringIntereses = "";
        if (contacto.getIntereses().isEmpty())
            return stringIntereses;

        for (String interes : contacto.getIntereses()){
            stringIntereses += interes + " - ";
        }
        return stringIntereses.substring(0,stringIntereses.length()-3);
    }
}