package com.example.carlos.wumpusproject.utils;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;
import java.util.Vector;

/**
 * Created by carlos on 11/10/17.
 */

public class Config {
    public static boolean modoIndividual;
    public static boolean labEsRegular;
    public static Grafo laberinto;
    public static List<Integer> tiposDeCuevas;
    public static GoogleMap map;
    public static List<Vector> coordenadasCuevas;
    public static Double latUsuario,lonUsuario;

    // Filas y columnas para grafos irregulares
    public static int numFilas = 6;
    public static int numColumnas = 6;
}
