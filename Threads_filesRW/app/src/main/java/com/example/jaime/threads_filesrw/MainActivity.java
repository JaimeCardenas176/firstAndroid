package com.example.jaime.threads_filesrw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button buttonEscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEscribe = findViewById(R.id.buttonEscribe);
    }


    public void escribeArchivo(View view) {


        new Thread(new Runnable() {
            public void run() {
                BufferedWriter escritor = null;
            try{
                escritor = new BufferedWriter( new OutputStreamWriter(
                        openFileOutput("archivo_prueba.txt", MODE_PRIVATE)
                ));
                for (int i=0; i<100; i++){
                    escritor.write(i+"\n");
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
                if (escritor != null)
                    try {
                        escritor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //¿Por que esto no funciona?
                    //Toast.makeText(this, "escribiendo en el archivo", Toast.LENGTH_LONG);
            }

            }
        }).start();
        Intent intentDashboard = new Intent(this, dashboard.class);
        startActivity(intentDashboard);
    }
}
