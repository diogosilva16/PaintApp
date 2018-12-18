package com.example.diogo.ponto2d;

public class Retangulo{

    private Ponto2D ponto;
    private double largura, comprimento;
    Ponto2D pontoA;
    Ponto2D pontoB;
    private String cor;

//    public Retangulo(Ponto2D pontoInicialT, Ponto2D pontoFinalT, float largura, float comprimento) {
//        ponto = new Ponto2D();
//        this.largura = this.comprimento = 1;
//    }
//
//    public Retangulo(float x, float y, float largura, float comprimento) {
//        ponto = new Ponto2D(x, y);
//        float l = largura;
//        float c = comprimento;
//    }

    public Retangulo(Ponto2D a, Ponto2D b, String color){
        this.pontoA = a;
        this.pontoB = b;
        cor = color;
    }

    public Ponto2D getPontoA(){
        return pontoA;
    }

    public Ponto2D getPontoB(){
        return pontoB;
    }

    public String retornarCor() {
        return cor;
    }

    public double Area() {
        return largura * comprimento;
    }

    public double Perimetro() {
        return largura * 2 + comprimento * 2;
    }

}
