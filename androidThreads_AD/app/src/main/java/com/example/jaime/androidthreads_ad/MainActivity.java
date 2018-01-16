package com.example.jaime.androidthreads_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button saludador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludador = findViewById(R.id.buttonSaludo);
        saludador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(5000);

                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });
    }
}
