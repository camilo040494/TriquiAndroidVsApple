package com.triqui.icesi.triquiandroidvsapple;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.Random;


public class Juego extends ActionBarActivity {

    public final static int UN_JUGADOR = 0;
    public final static int DOS_JUGADORES = 1;

    public final static int IMAGEN_UNO = -1;
    public final static int IMAGEN_DOS = 1;

    private int[][] matriz;
    private int imagen;
    private int turno;
    private int modalidad;

    private String ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Intent intent=getIntent();
        int mod=intent.getIntExtra("Modalidad",0);
        modalidad = mod;
        matriz = new int[3][3];
        turno = 0;
        Random random = new Random();
        imagen = random.nextInt(2)==0?-1:1;
        ganador="";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void marcarCasilla(int x, int y){
        if (matriz[x][y]!=0) {
            //error
            return;
        }else{
            matriz[x][y]=imagenJugadorActual();
            ImageButton iB = null;
            switch (x){
                case 0:
                    switch (y){
                        case 0:
                            iB = (ImageButton) findViewById(R.id.c00);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 1:
                            iB = (ImageButton) findViewById(R.id.c01);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 2:
                            iB = (ImageButton) findViewById(R.id.c02);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                    }
                    break;
                case 1:
                    switch (y){
                        case 0:
                            iB = (ImageButton) findViewById(R.id.c10);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 1:
                            iB = (ImageButton) findViewById(R.id.c11);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 2:
                            iB = (ImageButton) findViewById(R.id.c12);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                    }
                    break;
                case 2:
                    switch (y){
                        case 0:
                            iB = (ImageButton) findViewById(R.id.c20);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 1:
                            iB = (ImageButton) findViewById(R.id.c21);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                        case 2:
                            iB = (ImageButton) findViewById(R.id.c22);
                            if (imagenJugadorActual()==-1)
                                iB.setImageResource(R.drawable.apple19);
                            else
                                iB.setImageResource(R.drawable.system1);
                            break;
                    }
                    break;
            }


            if (modalidad==UN_JUGADOR) {
                boolean comp = comprobar(1);
                if (comp){
                    Intent intent=new Intent(this, FinalizacionJuego.class);
                    intent.putExtra("Modalidad", modalidad);
                    intent.putExtra("Ganador", ganador);
                    startActivity(intent);
                }else{
                    jugarMaquina();
                }

            }else{
                boolean comp = comprobar(turno);
                if (comp){

                }else{
                    turno = 1-turno;
                }
            }
        }
    }

    private int imagenJugadorActual() {
        if (modalidad==UN_JUGADOR) {
            return imagen;
        }else{
            if (turno==0) {
                return imagen;
            }else{
                return imagen==IMAGEN_UNO?IMAGEN_DOS:IMAGEN_UNO;
            }
        }
    }

    public boolean comprobar(int jugador) {
        if (matriz[0][0]==matriz[0][1] && matriz[0][1]==matriz[0][2]) {
            if (matriz[0][0]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[1][0]==matriz[1][1] && matriz[1][1]==matriz[1][2]){
            if (matriz[1][0]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[2][0]==matriz[2][1] && matriz[2][1]==matriz[2][2]){
            if (matriz[2][0]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[0][0]==matriz[1][0] && matriz[1][0]==matriz[2][0]){
            if (matriz[0][0]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[0][1]==matriz[1][1] && matriz[1][1]==matriz[2][1]){
            if (matriz[0][1]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[0][2]==matriz[1][2] && matriz[1][2]==matriz[2][2]){
            if (matriz[0][2]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[0][0]==matriz[1][1] && matriz[1][1]==matriz[2][2]){
            if (matriz[0][0]!=0) {
                gano(turno);
                return true;
            }
        }if(matriz[2][0]==matriz[1][1] && matriz[1][1]==matriz[0][2]){
            if (matriz[2][0]!=0) {
                gano(turno);
                return true;
            }
        }
        return false;
    }

    private void gano(int jugador) {
        if (modalidad==UN_JUGADOR) {
            if (jugador==0) {
                ganador= "Usted perdio";
            }else{
                ganador= "Usted gano";
            }
        }else{
            String android = "Gano Android";
            String apple = "Gano Apple";
            if (turno==0) {
                if (imagen==IMAGEN_UNO) {
                    ganador= android;
                }else{
                    ganador= apple;
                }
            }else{
                if (imagen==IMAGEN_UNO) {
                    ganador= apple;
                }else{
                    ganador= android;
                }
            }
        }
    }

    private void jugarMaquina() {
        Random random = new Random();
        boolean termino = false;
        while(!termino){
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matriz[x][y]==0) {
                termino = true;
                matriz[x][y] = imagen==IMAGEN_UNO?IMAGEN_DOS:IMAGEN_UNO;
                //Imagenes de botones
                ImageButton iB = null;
                switch (x){
                    case 0:
                        switch (y){
                            case 0:
                                iB = (ImageButton) findViewById(R.id.c00);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 1:
                                iB = (ImageButton) findViewById(R.id.c01);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 2:
                                iB = (ImageButton) findViewById(R.id.c02);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                        }
                        break;
                    case 1:
                        switch (y){
                            case 0:
                                iB = (ImageButton) findViewById(R.id.c10);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 1:
                                iB = (ImageButton) findViewById(R.id.c11);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 2:
                                iB = (ImageButton) findViewById(R.id.c12);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                        }
                        break;
                    case 2:
                        switch (y){
                            case 0:
                                iB = (ImageButton) findViewById(R.id.c20);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 1:
                                iB = (ImageButton) findViewById(R.id.c21);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                            case 2:
                                iB = (ImageButton) findViewById(R.id.c22);
                                if (imagenJugadorActual()==-1)
                                    iB.setImageResource(R.drawable.apple19);
                                else
                                    iB.setImageResource(R.drawable.system1);
                                break;
                        }
                        break;
                }
            }
        }
        comprobar(0);
    }

}

