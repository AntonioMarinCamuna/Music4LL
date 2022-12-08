package com.example.music4ll;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

public class ActivityReproductor extends AppCompatActivity {

    //DEFINICIÓN DE TODOS LOS ELEMENTOS USADOS
    private Spinner spnGen;
    private Spinner spnGrp;
    private Spinner spnTem;
    private Spinner spnDef;

    private int seleccionGen;
    private int seleccionGrp;
    private int seleccionTem;

    private ImageButton imgPlayPause;

    private MediaPlayer mp;

    private ImageView imgPortada;

    int banderaBotonPlay;

    Switch swtMuteUnmute;

    //VECTORES DE STRINGS PARA LOS SPINNERS (EL PRIMER ELEMENTO LO INICIALIZO MAS TARDE DEBIDO AL IDIOMA)
    String generos[] = {"", "Pop", "Rock", "R&B"};
    String gruposPop[] = {"","ColdPlay", "One Republic"};
    String gruposRock[] = {"","Extremoduro", "Guns N' Roses"};
    String gruposRandB[] = {"","TLC", "Blackstreet"};
    String temasColdplay[] = {"", "Viva la Vida"};
    String temasOneRepublic[] = {"", "Counting Stars", "I Ain't Worried"};
    String temasExtremoduro[] = {"", "So Payaso", "Salir"};
    String temasGunsNRoses[] = {"", "November Rain"};
    String temasTlc[] = {"", "Creep"};
    String temasBlackStreet[] = {"", "This is how we roll", "No Diggity"};
    String vacio[] = {};

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void generarAdpt(Spinner spn, String[] lista){

        ArrayAdapter aAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
        spn.setAdapter(aAdapter);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void pararCambioCancion(){

        if (mp != null && mp.isPlaying()) {
            mp.stop();

            imgPlayPause.setImageResource(R.drawable.pause);
            banderaBotonPlay = 0;
        }

        imgPortada.setImageResource(R.drawable.nota_musical);
        imgPlayPause.setVisibility(View.INVISIBLE);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void crearSpinnerTema(){

        if(seleccionGen == 1){ //POP

            if(seleccionGrp == 1){ //ColdPlay

                if(seleccionTem == 1){ //Viva la vida

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_viva_vida);

                    mp = MediaPlayer.create(this, R.raw.viva_la_vida);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if(seleccionGrp == 2){ //One Republic

                if(seleccionTem == 1){ //Counting Stars

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_counting);

                    mp = MediaPlayer.create(this, R.raw.counting_stars);

                } else if(seleccionTem == 2){ //I Ain't Worried

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_aint_worried);

                    mp = MediaPlayer.create(this, R.raw.aint_worried);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                pararCambioCancion();

            }

        } else if(seleccionGen == 2){ //ROCK

            if(seleccionGrp == 1){ //Extremoduro

                if(seleccionTem == 1){ //So Payaso

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_so_payaso);

                    mp = MediaPlayer.create(this, R.raw.so_payaso);

                } else if(seleccionTem == 2){ //Salir

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_salir);

                    mp = MediaPlayer.create(this, R.raw.salir);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if(seleccionGrp == 2){ //Guns n' Roses

                if(seleccionTem == 1){ //November Rain

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_november_rain);

                    mp = MediaPlayer.create(this, R.raw.november_rain);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                generarAdpt(spnTem, vacio);

                pararCambioCancion();

            }

        } else if(seleccionGen == 3){ //R&B

            if(seleccionGrp == 1){ //TLC

                if(seleccionTem == 1){ //Creep

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_creep);

                    mp = MediaPlayer.create(this, R.raw.creep);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if(seleccionGrp == 2){ //BlackStreet

                if(seleccionTem == 1){ //This is how we roll

                    imgPlayPause.setVisibility(View.VISIBLE);

                    imgPortada.setImageResource(R.drawable.portada_how_we_roll);

                    mp = MediaPlayer.create(this, R.raw.how_we_roll);

                } else if(seleccionTem == 2){ //No Diggity

                    imgPlayPause.setVisibility(View.VISIBLE);


                    imgPortada.setImageResource(R.drawable.portada_no_diggity);

                    mp = MediaPlayer.create(this, R.raw.no_diggity);

                } else if(seleccionTem == 0){ //Seleccione/Choose

                    pararCambioCancion();

                }

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                generarAdpt(spnTem, vacio);

                pararCambioCancion();

            }

        } else if(seleccionGen == 0){ //Seleccione/Choose GENERO

            generarAdpt(spnTem, vacio);

            pararCambioCancion();

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void crearSpinnerGrupos(){

        if(seleccionGen == 1){ //POP

            if(seleccionGrp == 1){ //ColdPlay

                generarAdpt(spnTem, temasColdplay);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if(seleccionGrp == 2){ //One Republic

                generarAdpt(spnTem, temasOneRepublic);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                generarAdpt(spnTem, vacio);

                imgPortada.setImageResource(R.drawable.nota_musical);
                imgPlayPause.setVisibility(View.INVISIBLE);

            }

        } else if(seleccionGen == 2){ //ROCK

            if(seleccionGrp == 1){ //Extremoduro

                generarAdpt(spnTem, temasExtremoduro);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if(seleccionGrp == 2){ //Guns n' Roses

                generarAdpt(spnTem, temasGunsNRoses);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                generarAdpt(spnTem, vacio);

                imgPortada.setImageResource(R.drawable.nota_musical);
                imgPlayPause.setVisibility(View.INVISIBLE);

            }

        } else if(seleccionGen == 3){ //R&B

            if(seleccionGrp == 1){ //TLC

                generarAdpt(spnTem, temasTlc);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if(seleccionGrp == 2){ //BlackStreet

                generarAdpt(spnTem, temasBlackStreet);

                imgPortada.setImageResource(R.drawable.nota_musical);

            } else if (seleccionGrp == 0){ //Seleccione/Choose

                generarAdpt(spnTem, vacio);

                imgPortada.setImageResource(R.drawable.nota_musical);
                imgPlayPause.setVisibility(View.INVISIBLE);

            }

        } else if(seleccionGen == 0){ //Seleccione/Choose GENERO

            generarAdpt(spnTem, vacio);

            imgPortada.setImageResource(R.drawable.nota_musical);
            imgPlayPause.setVisibility(View.INVISIBLE);

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void crearSpinnerGenero(){

        if(seleccionGen == 1){

            generarAdpt(spnGrp, gruposPop);

        } else if(seleccionGen == 2) {

            generarAdpt(spnGrp, gruposRock);

        } else if(seleccionGen == 3){

            generarAdpt(spnGrp, gruposRandB);

        } else if(seleccionGen == 0){

            generarAdpt(spnGrp, vacio);
            generarAdpt(spnTem, vacio);

            imgPortada.setImageResource(R.drawable.nota_musical);

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void switchVolRes(){

        swtMuteUnmute.setChecked(false);
        mp.setVolume(1, 1);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pararCambioCancion();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void incializarStrings(){

        generos[0] = getString(R.string.stringGenero);

        gruposPop[0] = getString(R.string.stringGrupos);
        gruposRock[0] = getString(R.string.stringGrupos);
        gruposRandB[0] = getString(R.string.stringGrupos);

        temasBlackStreet[0] = getString(R.string.stringCanciones);
        temasColdplay[0] = getString(R.string.stringCanciones);
        temasExtremoduro[0] = getString(R.string.stringCanciones);
        temasTlc[0] = getString(R.string.stringCanciones);
        temasOneRepublic[0] = getString(R.string.stringCanciones);
        temasGunsNRoses[0] = getString(R.string.stringCanciones);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        getSupportActionBar().hide();

        incializarStrings();

        banderaBotonPlay = 0;

        imgPortada = findViewById(R.id.imgPortada);
        imgPlayPause = findViewById(R.id.imgPlayPause);
        swtMuteUnmute = findViewById(R.id.switchMuteUnmute);
        spnGen = findViewById(R.id.spinnerGenero);
        spnGrp = findViewById(R.id.spinnerGrupos);
        spnTem = findViewById(R.id.spinnerTemas);

        seleccionGen = 0;
        seleccionGrp = 0;
        seleccionTem = 0;

        imgPlayPause.setVisibility(View.INVISIBLE);
        imgPlayPause.setBackgroundColor(Color.TRANSPARENT);

        generarAdpt(spnGen, generos);

        spnGen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion();
                if(swtMuteUnmute.isChecked()){

                    switchVolRes();

                }

                seleccionGen = i;
                crearSpinnerGenero();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnGrp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion();
                if(swtMuteUnmute.isChecked()){

                    switchVolRes();

                }

                seleccionGrp = i;
                crearSpinnerGrupos();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnTem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion();
                if(swtMuteUnmute.isChecked()){

                    switchVolRes();

                }

                seleccionTem = i;
                crearSpinnerTema();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(banderaBotonPlay == 0){

                    imgPlayPause.setImageResource(R.drawable.play);
                    mp.start();
                    banderaBotonPlay = 1;

                }else if(banderaBotonPlay == 1){

                    imgPlayPause.setImageResource(R.drawable.pause);
                    mp.pause();
                    banderaBotonPlay = 0;

                }

            }
        });

        swtMuteUnmute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(swtMuteUnmute.isChecked()){

                    mp.setVolume(0, 0);

                }else if(!swtMuteUnmute.isChecked()){

                    mp.setVolume(1,1);

                }
            }

        });

    }
}
