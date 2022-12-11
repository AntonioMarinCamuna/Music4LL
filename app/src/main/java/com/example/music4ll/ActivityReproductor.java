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

    /*
    * Definición de las variables que se van a usar en este activity de forma GLOBAL
    */
    private Spinner spnGen; //Definición de los spinners para la música.
    private Spinner spnGrp;
    private Spinner spnTem;
    private Spinner spnDef;

    private int seleccionGen; //Definición de una variable global que guardará la selección de cada spinner.
    private int seleccionGrp;
    private int seleccionTem;

    private ImageButton imgPlayPause; //Definición del botón de Play/Pause.

    private MediaPlayer mp; //Definición del MediaPlayer que se hará cargo de la reproducción de la música.

    private ImageView imgPortada; //Definición de la imagen de la portada de cada canción.

    private int banderaBotonPlay; //Definición de una bandera empleada para saber el estado del botón Play/Pause.

    private Switch swtMuteUnmute; //Definición del switch encargado de silenciar la música y viceversa.

    /*
    * Definición de los vectores de strings encargados de los géneros, grupos y temas que posteriormente
    * se introduciran en los spinners.
    *
    * El primer elemento de cada uno de ellos se introducira a posteriori dependiendo del idioma.
    */
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
    String vacio[] = {};    //Vector de strings vacío empleado para dejar los spinners vacíos si
                            //alguna de las opciones previas no está seleccionada.

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encargada de generar el adaptador para un spinner específico con una lista de Strings
    * específica, pasados ambos por parámetro
    */
    public void generarAdpt(Spinner spn, String[] lista){

        ArrayAdapter aAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
        spn.setAdapter(aAdapter);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encargada de parar la canción y adaptar la pantalla a la situación, quitando la portada
    * de la canción y haciendo invisible el botón de Play/Pause
    */
    public void pararCambioCancion(){

        if (mp != null && mp.isPlaying()) { //Este if comprueba que se esté reproduciendo música.
            mp.stop();

            imgPlayPause.setImageResource(R.drawable.pause);
            banderaBotonPlay = 0;
        }

        imgPortada.setImageResource(R.drawable.nota_musical); //Cambio de la imagen de la portada por una imagen genérica.
        imgPlayPause.setVisibility(View.INVISIBLE);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encargada de crear el spinner dedicado a los temas comprobando las elecciones previas
    * a las que accede gracias a ser globales.
    */
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

            generarAdpt(spnTem, vacio); //En el caso de que la selección sea por defecto, se llenarán los spinners con la lista vacía

            pararCambioCancion();

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encargada de generar el spinner que mostrará las canciones de un grupo específico
    * seleccionado comparando las posiciones de los elementos elegidos.
    */
    public void crearSpinnerGrupos(){

        if(seleccionGen == 1){ //POP

            if(seleccionGrp == 1){ //ColdPlay

                generarAdpt(spnTem, temasColdplay); //Llamada a la función generarAdpt con el spinner y la lista de temas pertinente.

                imgPortada.setImageResource(R.drawable.nota_musical); //Este código se emplea para
                                                                      //que al cambiar de grupo, se
                                                                      //elimine la portada de la canción.

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

            generarAdpt(spnTem, vacio); //En el caso de que la selección sea por defecto, se llenarán los spinners con la lista vacía

            imgPortada.setImageResource(R.drawable.nota_musical);
            imgPlayPause.setVisibility(View.INVISIBLE);

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encarga de llenar los spinner de los grupos con la información pertinente en función
    * del género seleccionado
    */
    public void crearSpinnerGenero(){

        if(seleccionGen == 1){

            generarAdpt(spnGrp, gruposPop); //Llamada a la función encargada de generar el adaptador para el spinner de los grupos con la lista pertinente.

        } else if(seleccionGen == 2) {

            generarAdpt(spnGrp, gruposRock);

        } else if(seleccionGen == 3){

            generarAdpt(spnGrp, gruposRandB);

        } else if(seleccionGen == 0){

            generarAdpt(spnGrp, vacio); //En caso de que la selección sea por defecto, vaciará ambos spinners (grupos y temas).
            generarAdpt(spnTem, vacio);

            imgPortada.setImageResource(R.drawable.nota_musical);

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función que restaura el estado del switch encargado de mutear la canción y vuelve a poner
    * el volumen de la música en 1.
    */
    public void switchVolRes(){

        swtMuteUnmute.setChecked(false);
        mp.setVolume(1, 1);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * @override del método onDestroy para cuando giramos el dispositivo, su función es para la musica
    * ya que si no hacemos esto, continuará sonando y no podremos pararla hasta que cerremos la aplicación
    */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        pararCambioCancion(); //Llama a la función encargada de parar la música.
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Función encargada de poner la primera opción ("Seleccione un género/Choose a genre") en función
    * del idioma.
    */
    public void incializarStrings(){

        generos[0] = getString(R.string.stringGenero); //Busca la información en el string.xml del idioma del dispositivo.

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

    /*
    * @override del onCreate de la actividad "ActivityReproductor"
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        getSupportActionBar().hide();   //Código encargado de eliminar la barra superior de las aplicaciones

        incializarStrings();    //Llamada de la función encargada de añadir el string por defecto a los spinners.

        /*
        * Instanciamos todas las variables que hemos definido previamente de forma global y les asignamos
        * los recursos pertinentes a cada uno.
        */
        banderaBotonPlay = 0;   //Por defecto, ponemos la bandera del botón a 0.

        imgPortada = findViewById(R.id.imgPortada); //Asignación de los recursos de cada uno de los elementos usados.
        imgPlayPause = findViewById(R.id.imgPlayPause);
        swtMuteUnmute = findViewById(R.id.switchMuteUnmute);
        spnGen = findViewById(R.id.spinnerGenero);
        spnGrp = findViewById(R.id.spinnerGrupos);
        spnTem = findViewById(R.id.spinnerTemas);

        seleccionGen = 0; //Por defecto dejamos la selección de los spinners a 0.
        seleccionGrp = 0;
        seleccionTem = 0;

        imgPlayPause.setVisibility(View.INVISIBLE);

        imgPlayPause.setBackgroundColor(Color.TRANSPARENT); //Modificación estética que elimina el fondo del botón Play/Pause dejando solo la imagen.

        generarAdpt(spnGen, generos); //Código encargado de generar el primer spinner con todos los géneros posibles.

        /*
        * @override de los onItemSelected de los spinners que nos permiten modificar lo que el
        * programa debe hacer cuando seleccionamos alguna opción.
        */
        spnGen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion(); //Siempre que cambiemos de selección, la música parará.
                if(swtMuteUnmute.isChecked()){ //If encargado de comprobar si el switch para mutear la musica está seleccionado y deselecciona.

                    switchVolRes();

                }

                seleccionGen = i; //Guardamos de forma global la selección para luego poder hacer comparaciones con ella.
                crearSpinnerGenero(); //Llama a la función encargada de crear el spinner de los géneros en función de la selección.

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
         * @override de los onItemSelected de los spinners que nos permiten modificar lo que el
         * programa debe hacer cuando seleccionamos alguna opción.
         */
        spnGrp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion();   //Siempre que cambiemos de selección, la música parará.
                if(swtMuteUnmute.isChecked()){  //If encargado de comprobar si el switch para mutear la musica está seleccionado y deselecciona.

                    switchVolRes();

                }

                seleccionGrp = i;   //Guardamos de forma global la selección para luego poder hacer comparaciones con ella.
                crearSpinnerGrupos();   //Llama a la función encargada de crear el spinner de los grupos en función de la selección.

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
         * @override de los onItemSelected de los spinners que nos permiten modificar lo que el
         * programa debe hacer cuando seleccionamos alguna opción.
         */
        spnTem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararCambioCancion();   //Siempre que cambiemos de selección, la música parará.
                if(swtMuteUnmute.isChecked()){  //If encargado de comprobar si el switch para mutear la musica está seleccionado y deselecciona.

                    switchVolRes();

                }

                seleccionTem = i;   //Guardamos de forma global la selección para luego poder hacer comparaciones con ella.
                crearSpinnerTema(); //Llama a la función encargada de crear el spinner de los temas en función de la selección.

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
        * @override del onCliclListener del botón encargado de parar o reanudar la música comparando
        * el valor de la variable global "banderaBotónPlay"
        */
        imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(banderaBotonPlay == 0){

                    imgPlayPause.setImageResource(R.drawable.play); //Ponemos la imagen "play" en el botón Play/Pause
                    mp.start(); //Le decimos al MediaPlayer "mp" que inicie la música.
                    banderaBotonPlay = 1; //Cambiamos el valor de la variable "banderaBotónPlay" para posteriores comparaciones.

                }else if(banderaBotonPlay == 1){

                    imgPlayPause.setImageResource(R.drawable.pause); //Ponemos la imagen "pause" en el botón Play/Pause
                    mp.pause(); //Le decimos al MediaPlayer "mp" que pare la música.
                    banderaBotonPlay = 0; //Cambiamos el valor de la variable "banderaBotónPlay" para posteriores comparaciones.

                }

            }
        });

        /*
        * @override encargado de comprobar el estado del switch encargado de silenciar la canción.
        */
        swtMuteUnmute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(swtMuteUnmute.isChecked()){ //Si está seleccionada, pone el volumen de la música a 0.

                    mp.setVolume(0, 0);

                }else if(!swtMuteUnmute.isChecked()){ //Si no lo está, pone el volumen de la música a 1.

                    mp.setVolume(1,1);

                }
            }

        });

    }
}
