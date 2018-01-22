package com.example.jaime.customelistview;

/**
 * Created by jaime on 22/01/18.
 */

public class Alumno {
    private String nombre;
    private int edad;
    private float media;
    private String foto;

    public Alumno(String nombre, int edad, float media, String foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.media = media;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
