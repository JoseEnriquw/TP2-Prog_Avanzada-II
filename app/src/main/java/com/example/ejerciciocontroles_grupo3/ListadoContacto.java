package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ListadoContacto extends AppCompatActivity {

    private ListView Listvw;
    private List<Contacto> listContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contacto);

        Listvw=(ListView)findViewById(R.id.ListView);
        listContacto=new ArrayList<>();
        try {
            FileInputStream leeArch = new FileInputStream (new File(getFilesDir(),Utils.nombreArchivo));
            ObjectInputStream streamArch = new ObjectInputStream (leeArch);
            // Leo todo y lleno la lista
            listContacto = (ArrayList<Contacto>) streamArch.readObject();
            // Cierro el stream
            streamArch.close();
        }catch (ClassNotFoundException | FileNotFoundException e){
            Log.e("MainActivity", "Error clase no encontrada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<Contacto> adapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1,listContacto);
        Listvw.setAdapter(adapter);


        Listvw.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              String variable =  Listvw.getItemAtPosition(i).toString();

                AbrirVentana(variable);


            }

        }
    );



    }


    public void AbrirVentana(String nombre){
        Intent masdetalles = new Intent(this, MasDetalles.class);
        masdetalles.putExtra("name",nombre);
    }
}