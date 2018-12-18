package com.example.diogo.ponto2d;

public class Ponto3D extends Ponto2D{

    double z1;

    public Ponto3D(int x, int y, int z) {
        x1 = x;
        y1 = y;
        z1 = z;
    }

    public double CalcDistPontos(Ponto3D p) {
        return Math.sqrt(Math.pow(x1 - p.x1, 2) + Math.pow(y1 - p.y1, 2) + Math.pow(z1 - p.z1, 2));
    }

    public double DistCentro() {
        Ponto3D aux = new Ponto3D(0,0, 0);
        return (this.CalcDistPontos(aux));
    }

    public void Addp(int k) {
        this.x1 += k;
        this.y1 += k;
        this.z1 += k;
    }
}
