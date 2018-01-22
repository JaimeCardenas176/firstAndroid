package com.example.jaime.androidmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<String> alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hemos conectado la variable que hemos delcarado aarriba con el elemento
        //listview de la IU cuyo id es listViewAlumnos
        listView = findViewById(R.id.ListViewAlumnos);

        //inicializamos la lista de alumnos
        alumnos =  new ArrayList<>();
        alumnos.add("Miguel A. Gómez");
        alumnos.add("Miguel A. Galiani");
        alumnos.add("Javier Rogerio");
        alumnos.add("El Juanfran");
        alumnos.add("El asiento de la expulsion");
        alumnos.add("César expulsa alumnos");
        alumnos.add("Sosa");
        alumnos.add("Jimmy");
        alumnos.add("Fibra No");
        alumnos.add("Herminia");
        alumnos.add("Cristina");
        alumnos.add("Fernando Cruz");
        alumnos.add("Jorge");
        alumnos.add("Pepe Youtuber");
        alumnos.add("Jesús");
        alumnos.add("Tejero Palmero");
        alumnos.add("Manuel");
        alumnos.add("Javi Rubik");
        alumnos.add("Marta");
        alumnos.add("Alejandro Verano");
        alumnos.add("David");

        ArrayAdapter adaptadorAlumnos =  new ArrayAdapter<String>(
          this,android.R.layout.simple_list_item_1,
                alumnos
        );

        //conectamos el adapter con el listView
        listView.setAdapter(adaptadorAlumnos);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String alumnoClicked = alumnos.get(i);
        Toast.makeText(this, "Alumnos" + alumnoClicked, Toast.LENGTH_SHORT).show();
        view.animate().rotation(360).setDuration(2000).start();
    }
}
