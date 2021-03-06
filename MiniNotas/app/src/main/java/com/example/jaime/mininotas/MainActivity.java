package com.example.jaime.mininotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button buttonGuardar;
    EditText editTextCampo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGuardar =  findViewById(R.id.buttonGuardar);
        editTextCampo = findViewById(R.id.editTextCampo);

        BufferedReader lector = null;
        try{
            lector = new BufferedReader( new InputStreamReader(
                    openFileInput("text.txt")));
            //String linea = null;
            String textoParcial;
            StringBuilder textoCompleto = new StringBuilder();
            while((textoParcial = lector.readLine())!= null){
                //editTextCampo.setText(linea+"\n", TextView.BufferType.EDITABLE);
                textoCompleto.append(textoParcial);
                editTextCampo.setText(textoCompleto.toString());
            }
            Toast.makeText(this,"leyendo del archivo", Toast.LENGTH_LONG);
    } catch (FileNotFoundException | SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardar(View view) {
        BufferedWriter escritor = null;
        String texto = editTextCampo.getText().toString();
        try{
            escritor = new BufferedWriter( new OutputStreamWriter(
                    openFileOutput("texto.txt", MODE_PRIVATE)));

            escritor.write(texto);
            Toast.makeText(this,"escribiendo en el archivo", Toast.LENGTH_LONG);
        } catch (FileNotFoundException  | SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
