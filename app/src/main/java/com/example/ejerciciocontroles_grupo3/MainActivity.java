package com.example.ejerciciocontroles_grupo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Intent _intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.agregar_contacto:
                _intent=new Intent(this,AgregarContacto.class);

            break;

            case R.id.listado_contacto:
                _intent=new Intent(this,ListadoContacto.class);
            break;

        }
        startActivity(_intent);
        return super.onOptionsItemSelected(item);
    }
}