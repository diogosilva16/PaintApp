package com.example.diogo.ponto2d;

public class Segmento_de_Reta {
    private Ponto2D p1, p2;
    private String cor;

    public Segmento_de_Reta(float xi, float yi, String color) {
        p1 = new Ponto2D(0, 0);
        p2 = new Ponto2D(0, 0);
        cor = color;
    }

    public Segmento_de_Reta(){
        p1.x1 = 0;
        p1.y1 = 0;
        p2.y1 = 0;
        p2.x1 = 0;
        cor = "#000000";
    }

    public Segmento_de_Reta(Ponto2D pt1, Ponto2D pt2, String color) {
        p1 = pt1;
        p2 = pt2;
        cor = color;
    }

    public String retornarCor() {
        return cor;
    }

    public Ponto2D getP1 (){
        return p1;
    }

    public Ponto2D getP2 (){
        return p2;
    }

    public void novaCor(String c) {
        cor = c;
    }

    public void novoP1(Ponto3D p) {
        p1 = p;
    }

    public void novoP2(Ponto3D p) {
        p2 = p;
    }


}
