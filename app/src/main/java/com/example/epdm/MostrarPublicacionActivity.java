package com.example.epdm;

import static com.example.epdm.MainActivity.lstPublicaciones;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.epdm.Clases.Publicacion;
import com.example.epdm.Clases.Libro;
import com.example.epdm.Clases.Revista;
import java.util.ArrayList;
public class MostrarPublicacionActivity extends AppCompatActivity {

    private ListView lsvPublicaciones;
    ArrayAdapter<Publicacion> lstFiltradaAdapter;
    ArrayList<Publicacion> lstFiltrada;

    Bundle bundle;

    int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_publicacion);


        lsvPublicaciones = findViewById(R.id.lsvPublicaciones);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoMostrarEleccion");
        lstFiltrada = filtrarListaPorSeleccion(idEleccion);

        lstFiltradaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstFiltrada);
        lsvPublicaciones.setAdapter(lstFiltradaAdapter);


        lsvPublicaciones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
               new AlertDialog.Builder(MostrarPublicacionActivity.this)
                .setTitle("Eliminar Publicación")
                .setMessage("¿Seguro de que deseas eliminar esta publicación?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lstPublicaciones.remove(position);
                        lstFiltrada.remove(position);
                        lstFiltradaAdapter.notifyDataSetChanged();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
                return false;

            }
        });
    }

    private ArrayList<Publicacion> filtrarListaPorSeleccion(int eleccion) {
        ArrayList<Publicacion> listaFiltrada = new ArrayList<>();

        for (Publicacion publicacion : lstPublicaciones) {
            switch (eleccion) {
                case 1:
                    if (publicacion instanceof Libro) {
                        listaFiltrada.add(publicacion);
                    }
                    break;
                case 2:
                    if (publicacion instanceof Revista) {
                        listaFiltrada.add(publicacion);
                    }
                    break;
                default:
                    listaFiltrada.add(publicacion);
                    break;
            }
        }
        return listaFiltrada;
    }



}