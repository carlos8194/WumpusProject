package com.example.carlos.wumpusproject.utils;

/**
 * Created by carlos on 30/10/17.
 */

/**
 * Clase usada para representar pares de numeros, por ejemplo entradas de matriz fila/columna o
 * incluso podrian ser coordenadas latitud/longitud
 */
public class Pair {
    private int x; // primera entrada (fila o latitud)
    private int y; // segunda entrada (columna o longitud)

    /**
     * Constructor de la clase
     * @param x: Primera entrada
     * @param y: Segunda entrada
     */
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return La primera entrada
     */
    public int getX() {
        return x;
    }

    /**
     * @return La segunda entrada
     */
    public int getY() {
        return y;
    }

    /**
     * Calcula la distancia entre dos pares especificos y guarda el resultado en un nuevo par que
     * posteriormente es devuelto.
     * @param pair: El par que se resta de este par (this).
     * @return El par con el resultado de la resta.
     */
    public Pair restarPares(Pair pair){
        int x = this.x - pair.x;
        int y = this.y - pair.y;
        return new Pair(x, y);
    }
}
