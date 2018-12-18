package com.example.diogo.ponto2d;

public class Poligono {

    public double x;
    public double y;
    private String cor;

    public Poligono(double a, double b, String color) {
        this.x = a;
        this.y = b;
        this.cor = color;
    }

    public String retornarCor() {
        return cor;
    }
}