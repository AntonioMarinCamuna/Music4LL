package com.example.music4ll;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    /*
    * Definición global de cierta variables que se van a usar
    */
    TextView usr;
    TextView psw;
    Button btnLogin;
    ImageView img;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Modificación del onClick del botón "btnLogin" para que actué en función de las credenciales
    * introducidas.
    */
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            /*
            * Comparación que hace una cosa u otra si la información introducida es correcta o no.
            */
            if(usr.getText().toString().equals("admin") && psw.getText().toString().equals("1234")){

                /*
                * Código encargado de instanciar un intent con el activity "ActivityReproductor"
                * y encargado de comenzar la actividad.
                */
                Intent i = new Intent(MainActivity.this, ActivityReproductor.class);
                startActivity(i);

            }else{

                /*
                * Código que actúa cuando los datos no son correctos y que muestra un fragmento de
                * ERROR.
                */
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                FragmentoError fe = new FragmentoError();
                ft.replace(android.R.id.content,fe).addToBackStack(null).commit();

                /*
                * Forzamos al programa que borre lo introducido en los campos "usr" y "pwd" para que
                * al volver del fragmento estén vacíos.
                */
                usr.setText("");
                psw.setText("");

            }
        }
    };

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Modificación del "onCreate".
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //Código encargado de eliminar la barra superior de las aplicaciones.

        /*
        * Instanciamos cada una de las variables globales definidas antes y les asignamos los
        * recursos pertinentes.
        */
        usr = findViewById(R.id.userField);
        psw = findViewById(R.id.passwordField);
        btnLogin = findViewById(R.id.button);
        img = findViewById(R.id.imgLogo);

        btnLogin.setBackgroundColor(Color.BLACK); //Modificación estética para el botón (color negro).

        img.setVisibility(View.VISIBLE); //Código que pone la imagen de la portada VISIBLE.

        btnLogin.setOnClickListener(listener); //Código que usa la variable listener obtenida en el @override
                                               //del onClickListener.

    }
}
