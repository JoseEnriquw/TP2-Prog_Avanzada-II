package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FormularioMasDatosContacto extends AppCompatActivity {

    private Contacto contacto;
    private List<String> intereses;
    private String archivo = "contacto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mas_datos_contacto);
        contacto=(Contacto)getIntent().getSerializableExtra("contacto");
        intereses=new ArrayList<>();
    }

    public void addIntereses(View view)
    {
        CheckBox cb=(CheckBox)findViewById(view.getId());
        if(cb.isChecked())
        {
             intereses.add(cb.getText().toString());
        }
        else
        {
            intereses.remove(cb.getText().toString());
        }
    }
    public void Guardar(View view)
    {
        int id=((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        contacto.setNivelEstudioAlcanzado(((RadioButton)findViewById(id)).getText().toString());
        contacto.setRecibirInf(((Switch)findViewById(R.id.switchSi)).isChecked());
        contacto.setIntereses(intereses);

        try{
            ObjectOutputStream objOutput = new ObjectOutputStream(openFileOutput(archivo, MODE_PRIVATE));
            objOutput.writeObject(contacto);
            objOutput.close();
        }catch (IOException e){
            Toast.makeText(this,"Error al guardar el archivo",Toast.LENGTH_LONG).show();
        }
    }
}