package com.example.epdm;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.epdm.MainActivity.lstPublicaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.epdm.Clases.Libro;
import com.example.epdm.Clases.Revista;
public class AgregarPublicacionActivity extends AppCompatActivity {

    EditText edtCodigoPublic, edtTituloPublic, edtAnioPublic, edtNumRevista;
    Button btnIrProcesar;
    Bundle bundle;
    int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_publicacion);

        edtCodigoPublic = findViewById(R.id.edtCodigo);
        edtTituloPublic = findViewById(R.id.edtTitulo);
        edtAnioPublic = findViewById(R.id.edtAnioPublicacion);
        edtNumRevista = findViewById(R.id.edtNumeroRevista);
        btnIrProcesar = findViewById(R.id.btnProcesar);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            edtNumRevista.setVisibility(View.GONE);
        }

        btnIrProcesar.setOnClickListener(view -> {
            if (edtNumRevista.getText().toString().isEmpty()) {
                lstPublicaciones.add(
                        new Libro(
                                Integer.valueOf(edtCodigoPublic.getText().toString()),
                                edtTituloPublic.getText().toString(),
                                Integer.valueOf(edtAnioPublic.getText().toString()),
                                false
                        )
                );
            }else{
                lstPublicaciones.add(
                        new Revista(
                                Integer.valueOf(edtCodigoPublic.getText().toString()),
                                edtTituloPublic.getText().toString(),
                                Integer.valueOf(edtAnioPublic.getText().toString()),
                                Integer.valueOf(edtNumRevista.getText().toString())
                        )
                );
            }


            new AlertDialog.Builder(this).setMessage("Insertado con exito").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).show();
        });
    }
}