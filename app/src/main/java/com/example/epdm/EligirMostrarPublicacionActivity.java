package com.example.epdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EligirMostrarPublicacionActivity extends AppCompatActivity {

    private RadioButton rbLibro, rbRevista, rbAmbos;
    private RadioGroup rgbEleccion;

    private Button btnMostrar;

    private Bundle bundle;

    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligir_mostrar_publicacion);

        btnMostrar = findViewById(R.id.btnMostrar);
        rgbEleccion = findViewById(R.id.rgEleccion);
        rbLibro = rgbEleccion.findViewById(R.id.rgLibro);
        rbRevista = rgbEleccion.findViewById(R.id.rgRevista);
        rbAmbos = rgbEleccion.findViewById(R.id.rgAmbos);

        rbLibro.setOnClickListener(view -> idEleccion = 1); // En caso de que el usuario elija libro
        rbRevista.setOnClickListener(view -> idEleccion = 2); // En caso de que el usuario elija revista
        rbAmbos.setOnClickListener(view -> idEleccion = 3);

        btnMostrar.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putInt("tipoMostrarEleccion", idEleccion);
            Intent intent = new Intent(this, MostrarPublicacionActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}