package com.example.jaime.threads_filesrw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                String linea = null;
                for (int i=0; i<100; i++){
                    escritor.write(i+"\n");
                }
            }catch (FileNotFoundException e) {
                System.err.println("no se encuentra el fichero o está corrupto");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("error de entradas/salidas");
                e.printStackTrace();
            } finally {
                if (escritor != null)
                    try {
                        escritor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            }
        }).start();
    }
}
