package com.example.jaime.customelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //En el objeto "view" tenemos una referencia al root element del template
        //View v = convertView.inflate(ctx, template, parent); ESTO ASI NO ES
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);
        //rescata elementos
        ImageView ivFoto = v.findViewById(R.id.imageViewFotoAlumno);
        TextView tvNombre = v.findViewById(R.id.textViewNombreAlumno);
        TextView tvEdad = v.findViewById(R.id.textView2AlumnoEdad);
        TextView tvNota = v.findViewById(R.id.textView3AlumnoNota);
        //rescatar los datos del alumno que estoy dibujando en este momento
        Alumno actual = listaElementos.get(position);
        String nombre = actual.getNombre();
        int eda = actual.getEdad();
        float media = actual.getMedia();
        String url = actual.getFoto();

        tvNombre.setText(nombre);
        tvEdad.setText(String.valueOf(eda));
        tvNota.setText(String.valueOf(media));
        Picasso.with(ctx).load(url).into(ivFoto);
        return v;
    }
}
