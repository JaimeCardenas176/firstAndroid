package com.example.jaime.threads_filesrw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class dashboard extends AppCompatActivity {
    Button buttonLee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        buttonLee = findViewById(R.id.buttonLee);
    }

    public void leeArchivo(View view) {

        new Thread(new Runnable() {
            public void run() {
                BufferedReader lector = null;
                try{
                    lector = new BufferedReader( new InputStreamReader(
                            openFileInput("archivo_prueba.txt")));
                    String linea = null;
                    while((linea = lector.readLine())!= null){
                        Log.d("archivo: ",linea);
                    }
                }catch (FileNotFoundException e) {
                    System.err.println("no se encuentra el fichero o está corrupto");
                    e.printStackTrace();
                }catch (SecurityException e){
                    System.err.println("error de seguridad");
                    e.printStackTrace();
                }catch (IOException e) {
                    System.err.println("error de entradas/salidas");
                    e.printStackTrace();
                } finally {
                    if (lector != null)
                        try {
                            lector.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                }

            }
        }).start();
        //esto finaliza esta actividad y creo que devuelve a la actividad anterior no comprobado
        finish();
    }
}
