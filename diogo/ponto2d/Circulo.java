package com.example.diogo.ponto2d;

public class Circulo {

    private Ponto2D centro;
    private float raio;
    private String cor;
    private Ponto2D pA;
    private Ponto2D pB;

//    public Circulo() {
//        centro = new Ponto2D();
//        raio = (float) 0.1;
//    }

    public Circulo(){
        raio = 0;
        pA = new Ponto2D();
        pB = new Ponto2D();
    }

    public Circulo(Ponto2D a, Ponto2D b, String color){
        this.pA = a;
        this.pB = b;
        cor = color;
    }

//    public Circulo(float x, float y, float n, int color) {
//        centro = new Ponto2D(x, y);
//        raio = n;
//        cor = color;
//    }
//
//    public Circulo(Ponto2D p1, double r, int color){
//        x1 = p1.x1;
//        y1 = p1.y1;
//        raio = (float) r;
//        cor = color;
//    }

    public float getRaio(){
        raio = (float) pA.CalcDistPontos(pB);
        return raio;
    }

    public Ponto2D getPA (){
        return pA;
    }

    public String retornarCor() {
        return cor;
    }

    public double Perimetro() {
        return 2 * Math.PI * raio;
    }

    public double Area() {
        return Math.PI * Math.pow(raio, 2);
    }

}
