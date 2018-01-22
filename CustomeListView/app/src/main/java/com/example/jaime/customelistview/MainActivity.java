package com.example.jaime.customelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Alumno> alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewAlumnos);

        //init la lista de alumnos
        alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Miguelito", 20 , 4.9f, "https://pics.me.me/d-o-n-twr-tal-api-rch-manolito-vuelve-a-21860235.png"));
        alumnos.add(new Alumno("Maria", 19, 67f, "https://pics.me.me/d-o-n-twr-tal-api-rch-manolito-vuelve-a-21860235.png"));

        AlumnosAdapter adaptadorAlumnos = new AlumnosAdapter(
                this,
                R.layout.list_alumnos_item,
                alumnos
        );

        listView.setAdapter(adaptadorAlumnos);
    }
}
