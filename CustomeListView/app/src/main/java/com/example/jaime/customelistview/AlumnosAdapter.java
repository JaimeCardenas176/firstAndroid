package com.example.jaime.customelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by jaime on 22/01/18.
 */

class AlumnosAdapter extends ArrayAdapter<Alumno>{
   Context ctx;
   int template;
   List<Alumno> listaElementos;

    public AlumnosAdapter(@NonNull Context context, int resource, @NonNull List<Alumno> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.template = resource;
        this.listaElementos = objects;
    }
}
