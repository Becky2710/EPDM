package com.example.epdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.epdm.Clases.Publicacion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private Button btnAgregarPublicacion, btnMostrarLista, btnAcercaDe;
    public static ArrayList<Publicacion> lstPublicaciones;
   // public static ArrayList<Publicacion> lstFiltrada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPublicaciones = new ArrayList<>();
        //lstFiltrada = new ArrayList<>();
        btnAgregarPublicacion = findViewById(R.id.btnAgregar);
        btnMostrarLista  = findViewById(R.id.btnMostrarLista);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);


        btnAgregarPublicacion.setOnClickListener(this);
        btnMostrarLista.setOnClickListener(this);
        btnAcercaDe.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // Agregar publicacion
        if(id == R.id.btnAgregar){
            startActivity(new Intent(this, ElegirTipoPublicacionActivity.class));
        }

        if (id == R.id.btnMostrarLista) {
            startActivity(new Intent(this, EligirMostrarPublicacionActivity.class));
        }



    }




}