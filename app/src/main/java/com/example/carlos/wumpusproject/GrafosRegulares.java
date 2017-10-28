package com.example.carlos.wumpusproject;

import com.example.carlos.wumpusproject.utils.Config;
import com.example.carlos.wumpusproject.utils.Grafo;
import com.example.carlos.wumpusproject.Emplazar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class GrafosRegulares extends AppCompatActivity implements View.OnClickListener {

    ImageButton tetraedro;
    ImageButton octaedro;
    ImageButton cubo;
    ImageButton icosaedro;
    ImageButton dodecaedro;

    Emplazar emplazar = new Emplazar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regular);

        tetraedro = (ImageButton) findViewById(R.id.Tetraedro);
        octaedro = (ImageButton) findViewById(R.id.Octaedro);
        cubo = (ImageButton) findViewById(R.id.Cubo);
        icosaedro = (ImageButton) findViewById(R.id.Icosaedro);
        dodecaedro = (ImageButton) findViewById(R.id.Dodecaedro);
        tetraedro.setOnClickListener(this);
        octaedro.setOnClickListener(this);
        cubo.setOnClickListener(this);
        icosaedro.setOnClickListener(this);
        dodecaedro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Grafo laberinto = null;
        List<Integer> tipos = null;
        switch(v.getId()){
            case R.id.Tetraedro:
                Toast.makeText(this, "Su laberinto tiene 4 cuevas", Toast.LENGTH_LONG).show();
                laberinto = new Grafo(4);
                tipos = llenarCueva(4);
                laberinto.addArista(1,14);
                laberinto.addArista(19,2);
                laberinto.addArista(2,16);
                laberinto.addArista(16,2);
                laberinto.addArista(2,14);
                laberinto.addArista(14,2);
                laberinto.addArista(14,19);
                laberinto.addArista(19,14);
                laberinto.addArista(14,16);
                laberinto.addArista(16,14);
                laberinto.addArista(16,19);
                laberinto.addArista(19,16);

                break;

            case R.id.Octaedro:
                Toast.makeText(this, "Su laberinto tiene 6 cuevas", Toast.LENGTH_LONG).show();
                laberinto = new Grafo(6);
                tipos = llenarCueva(6);
                laberinto.addArista(0,1);
                laberinto.addArista(0,2);
                laberinto.addArista(0,3);
                laberinto.addArista(0,4);
                laberinto.addArista(1,0);
                laberinto.addArista(1,2);
                laberinto.addArista(1,4);
                laberinto.addArista(1,5);
                laberinto.addArista(2,0);
                laberinto.addArista(2,1);
                laberinto.addArista(2,3);
                laberinto.addArista(2,5);
                laberinto.addArista(3,0);
                laberinto.addArista(3,2);
                laberinto.addArista(3,4);
                laberinto.addArista(3,5);
                laberinto.addArista(4,0);
                laberinto.addArista(4,1);
                laberinto.addArista(4,3);
                laberinto.addArista(4,5);
                laberinto.addArista(5,1);
                laberinto.addArista(5,2);
                laberinto.addArista(5,3);
                laberinto.addArista(5,4);
                break;

            case R.id.Cubo:
                Toast.makeText(this, "Su laberinto tiene 8 cuevas", Toast.LENGTH_LONG).show();
                laberinto = new Grafo(8);
                tipos = llenarCueva(8);
                laberinto.addArista(0,1);
                laberinto.addArista(0,3);
                laberinto.addArista(0,4);
                laberinto.addArista(1,0);
                laberinto.addArista(1,2);
                laberinto.addArista(1,5);
                laberinto.addArista(2,1);
                laberinto.addArista(2,3);
                laberinto.addArista(2,6);
                laberinto.addArista(3,0);
                laberinto.addArista(3,2);
                laberinto.addArista(3,7);
                laberinto.addArista(4,0);
                laberinto.addArista(4,5);
                laberinto.addArista(4,7);
                laberinto.addArista(5,1);
                laberinto.addArista(5,4);
                laberinto.addArista(5,6);
                laberinto.addArista(6,2);
                laberinto.addArista(6,5);
                laberinto.addArista(6,7);
                laberinto.addArista(7,3);
                laberinto.addArista(7,4);
                laberinto.addArista(7,6);
                break;

            case R.id.Icosaedro:
                Toast.makeText(this, "Su laberinto tiene 12 cuevas", Toast.LENGTH_LONG).show();
                laberinto = new Grafo(12);
                tipos = llenarCueva(12);
                laberinto.addArista(0,1);
                laberinto.addArista(0,5);
                laberinto.addArista(0,6);
                laberinto.addArista(0,7);
                laberinto.addArista(0,11);
                laberinto.addArista(1,0);
                laberinto.addArista(1,2);
                laberinto.addArista(1,6);
                laberinto.addArista(1,7);
                laberinto.addArista(1,8);
                laberinto.addArista(2,1);
                laberinto.addArista(2,3);
                laberinto.addArista(2,7);
                laberinto.addArista(2,8);
                laberinto.addArista(2,9);
                laberinto.addArista(3,2);
                laberinto.addArista(3,4);
                laberinto.addArista(3,8);
                laberinto.addArista(3,9);
                laberinto.addArista(3,10);
                laberinto.addArista(4,3);
                laberinto.addArista(4,5);
                laberinto.addArista(4,9);
                laberinto.addArista(4,10);
                laberinto.addArista(4,11);
                laberinto.addArista(5,0);
                laberinto.addArista(5,4);
                laberinto.addArista(5,6);
                laberinto.addArista(5,10);
                laberinto.addArista(5,11);
                laberinto.addArista(6,0);
                laberinto.addArista(6,1);
                laberinto.addArista(6,5);
                laberinto.addArista(6,8);
                laberinto.addArista(6,10);
                laberinto.addArista(7,0);
                laberinto.addArista(7,1);
                laberinto.addArista(7,2);
                laberinto.addArista(7,9);
                laberinto.addArista(7,11);
                laberinto.addArista(8,1);
                laberinto.addArista(8,2);
                laberinto.addArista(8,3);
                laberinto.addArista(8,6);
                laberinto.addArista(8,10);
                laberinto.addArista(9,2);
                laberinto.addArista(9,3);
                laberinto.addArista(9,4);
                laberinto.addArista(9,7);
                laberinto.addArista(9,11);
                laberinto.addArista(10,3);
                laberinto.addArista(10,4);
                laberinto.addArista(10,5);
                laberinto.addArista(10,6);
                laberinto.addArista(10,8);
                laberinto.addArista(11,0);
                laberinto.addArista(11,4);
                laberinto.addArista(11,5);
                laberinto.addArista(11,7);
                laberinto.addArista(11,9);
                break;

            case R.id.Dodecaedro:
                Toast.makeText(this, "Su laberinto tiene 20 cuevas", Toast.LENGTH_LONG).show();
                laberinto = new Grafo(20);
                tipos = llenarCueva(20);
                laberinto.addArista(0,1);
                laberinto.addArista(0,2);
                laberinto.addArista(0,3);
                laberinto.addArista(1,0);
                laberinto.addArista(1,4);
                laberinto.addArista(1,6);
                laberinto.addArista(2,0);
                laberinto.addArista(2,5);
                laberinto.addArista(2,9);
                laberinto.addArista(3,0);
                laberinto.addArista(3,7);
                laberinto.addArista(3,8);
                laberinto.addArista(4,1);
                laberinto.addArista(4,5);
                laberinto.addArista(4,11);
                laberinto.addArista(5,2);
                laberinto.addArista(5,4);
                laberinto.addArista(5,12);
                laberinto.addArista(6,1);
                laberinto.addArista(6,7);
                laberinto.addArista(6,10);
                laberinto.addArista(7,3);
                laberinto.addArista(7,6);
                laberinto.addArista(7,15);
                laberinto.addArista(8,3);
                laberinto.addArista(8,9);
                laberinto.addArista(8,14);
                laberinto.addArista(9,2);
                laberinto.addArista(9,8);
                laberinto.addArista(9,13);
                laberinto.addArista(10,6);
                laberinto.addArista(10,11);
                laberinto.addArista(10,16);
                laberinto.addArista(11,4);
                laberinto.addArista(11,10);
                laberinto.addArista(11,17);
                laberinto.addArista(12,5);
                laberinto.addArista(12,13);
                laberinto.addArista(12,17);
                laberinto.addArista(13,9);
                laberinto.addArista(13,18);
                laberinto.addArista(14,8);
                laberinto.addArista(14,15);
                laberinto.addArista(14,18);
                laberinto.addArista(15,0);
                laberinto.addArista(15,7);
                laberinto.addArista(15,14);
                laberinto.addArista(15,16);
                laberinto.addArista(16,10);
                laberinto.addArista(16,15);
                laberinto.addArista(16,19);
                laberinto.addArista(17,11);
                laberinto.addArista(17,12);
                laberinto.addArista(17,19);
                laberinto.addArista(18,13);
                laberinto.addArista(18,14);
                laberinto.addArista(18,19);
                laberinto.addArista(19,16);
                laberinto.addArista(19,17);
                laberinto.addArista(19,18);
                break;
        }

        Config.laberinto = laberinto;
       // Config.tiposDeCuevas = tipos;

        emplazar.crearMapMarks();
    }

    /**
     * 0 -> Cueva libre
     * 1 -> Wumpus
     * 2 -> Pozo
     * 3 -> Murcielago
     * 4 -> Personaje
     */
    public List<Integer> llenarCueva(int tamGrafo) {
        List<Integer> tiposC = new ArrayList<>(tamGrafo*tamGrafo);
        boolean wumpus = false;
        boolean personaje = false;
        for (int x = 0; x < tamGrafo*2; x++) {
            int tipo = (int) (Math.random() * 4);

            if (tipo == 1 && wumpus == true) {
                x--;
            } else {
                tiposC.add(tipo);
                if (tipo == 1) {
                    wumpus = true;
                }
            }

           // if (tipo == 4 && personaje == true) {
             //   x--;
           // } else {
           //     tiposC.add(tipo);
            //    if (tipo == 4) {
                    personaje = true;
            //    }
           // }
        }
        return tiposC;
    }

}