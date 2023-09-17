package com.example.epdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ElegirTipoPublicacionActivity extends AppCompatActivity {

    private RadioButton rbLibro, rbRevista;
    private RadioGroup rgbEleccion;

    private Button btnContinuar;

    private Bundle bundle;

    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_publicacion);

        btnContinuar = findViewById(R.id.btnContinuar);
        rgbEleccion = findViewById(R.id.rgEleccion);
        rbLibro = rgbEleccion.findViewById(R.id.rgLibro);
        rbRevista = rgbEleccion.findViewById(R.id.rbRevista);

        rbLibro.setOnClickListener(view -> idEleccion = 1); // En caso de que el usuario elija libro
        rbRevista.setOnClickListener(view -> idEleccion = 2); // En caso de que el usuario elija revista

        btnContinuar.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, AgregarPublicacionActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}