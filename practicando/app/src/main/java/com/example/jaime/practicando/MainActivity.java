package com.example.jaime.practicando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editText_Email);
        editTextPass = findViewById(R.id.editText2_Pass);
    }
    /*

    */
    public void doLogin(View view) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();



        if(email.equals("admin@admin.com") && pass.equals("1234")){
            //es el componenete encargado de lanzar un nuevo activity
            //en el primer plano de la aplicacion y el activiti actual quedaria onPause.
            Intent intentDashboard = new Intent(this, DashboardActivity.class);
            intentDashboard.putExtra("emailLogin", email);
            intentDashboard.putExtra("isLoggedIn",true );
            startActivity(intentDashboard);
        }else{
            Toast.makeText(
                    this,
                    "Email:  "+email+", Pass: "+pass,
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
}
