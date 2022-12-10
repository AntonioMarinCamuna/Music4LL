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

    TextView usr;
    TextView psw;
    Button btnLogin;
    ImageView img;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(usr.getText().toString().equals("admin") && psw.getText().toString().equals("1234")){

                Intent i = new Intent(MainActivity.this, ActivityReproductor.class);
                startActivity(i);

            }else{

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                FragmentoError fe = new FragmentoError();
                ft.replace(android.R.id.content,fe).addToBackStack(null).commit();

                usr.setText("");
                psw.setText("");

            }
        }
    };

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = findViewById(R.id.userField);
        psw = findViewById(R.id.passwordField);
        btnLogin = findViewById(R.id.button);
        btnLogin.setBackgroundColor(Color.BLACK);

        getSupportActionBar().hide();

        img = findViewById(R.id.imgLogo);
        img.setVisibility(View.VISIBLE);

        btnLogin.setOnClickListener(listener);

    }
}
