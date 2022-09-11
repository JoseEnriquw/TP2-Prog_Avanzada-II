package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
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
    public void Guardar(View view){
        int id=((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        contacto.setNivelEstudioAlcanzado(((RadioButton)findViewById(id)).getText().toString());
        contacto.setRecibirInf(((Switch)findViewById(R.id.switchSi)).isChecked());
        contacto.setIntereses(intereses);

        List<Contacto> listContacto=new ArrayList<>();
        try {
            FileInputStream leeArch = new FileInputStream (new File(getFilesDir(),Utils.nombreArchivo));
            ObjectInputStream streamArch = new ObjectInputStream (leeArch);

            listContacto = (ArrayList<Contacto>) streamArch.readObject();
            listContacto.add(contacto);
            streamArch.close();

            FileOutputStream escribirArch = new FileOutputStream(new File(getFilesDir(),Utils.nombreArchivo));
            ObjectOutputStream streamArchOut = new ObjectOutputStream(escribirArch);
            streamArchOut.writeObject(listContacto);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }catch (Exception e){
            try{
                FileOutputStream escribirArch = new FileOutputStream(new File(getFilesDir(),Utils.nombreArchivo));
                ObjectOutputStream streamArch = new ObjectOutputStream(escribirArch);
                listContacto.add(contacto);
                streamArch.writeObject(listContacto);
                streamArch.close();
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }catch (IOException ex){
                Toast.makeText(this,"Error al guardar el archivo",Toast.LENGTH_LONG).show();
            }
        }

    }



   /* // Método que lee del archivo y lo pone en la lista
   */

}