package com.example.ejerciciocontroles_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoContacto extends AppCompatActivity {

    private ListView Listvw;
    private TextView tv1;

    private String Listado [] = {"enrique", "regina", "laura", "ivan", "pablo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contacto);
        Toast.makeText(this,"este es listado contacto",Toast.LENGTH_SHORT).show();
        Contacto contacto=(Contacto)getIntent().getSerializableExtra("contacto");
        if(contacto!=null)
        Toast.makeText(this,contacto.toString(),Toast.LENGTH_LONG).show();

        Listvw=(ListView)findViewById(R.id.ListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, Listado);
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