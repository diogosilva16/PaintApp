package com.example.diogo.ponto2d;

public class Ponto2D {

    public float x1;
    public float y1;
    //criar construtor por omissão para a classe Ponto3D funcionar
    public Ponto2D()
    {
        x1 = 0;
        y1 = 0;
    }

    public Ponto2D(float x, float y)
    {
        x1 = x;
        y1 = y;
    }



    //calcular distância entre 2 pontos = Raíz quadrada de ((x2-x1)^2 + (y2-y1)^2)
    public float CalcDistPontos(Ponto2D pontocenas){
        return (float) Math.sqrt(Math.pow((pontocenas.x1-x1),2)+Math.pow((pontocenas.y1-y1),2));
    }

    public void setX(float a){
        x1 = a;
    }

    public void setY(float a){
        y1 = a;
    }

    public double getX(){
        return x1;
    }

    public double getY(){
        return y1;
    }

    public Ponto2D(Ponto2D p3){
        p3.x1 = 2;
        p3.y1 = 2;
    }

    //Calcular distância ao centro
    public double DistCentro(){
        Ponto2D aux = new Ponto2D(0,0);
        return (this.CalcDistPontos(aux));
    }

    //Adicionar um valor às coordenadas
    public void Addp(int z) {
        this.x1 += z;
        this.y1 += z;
    }

    public Ponto2D pontoIntermedio(Ponto2D p) {
        float x_med = (p.x1 - x1) / 2;
        float y_med = (p.y1 - y1) / 2;

        return new Ponto2D(x_med + x1, y_med + y1);
    }

    //Verificar se os pontos são iguais
    static public boolean comparar(Ponto2D pt1, Ponto2D pt2){
        return pt1.x1 == pt2.x1 && pt1.y1 == pt2.y1;
    }
}
