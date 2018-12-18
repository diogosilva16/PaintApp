package com.example.diogo.micro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.diogo.ponto2d.Circulo;
import com.example.diogo.ponto2d.Poligono;
import com.example.diogo.ponto2d.Ponto2D;
import com.example.diogo.ponto2d.Retangulo;
import com.example.diogo.ponto2d.Segmento_de_Reta;

import java.util.Vector;

public class MyView extends View {

    public int click = 0;
    Paint paint = null;
    public int cond = 0;

    public String cor;

    public Ponto2D pInicial;
    public Ponto2D pFinal;

    Vector linhas = new Vector();
    Vector retangulos = new Vector();
    Vector circulos = new Vector();
    Vector poligonos = new Vector();

    public void black() {
        cor = "#000000";
    }

    public void blue() {
        cor = "#0000ff";
    }

    public void green() {
        cor = "#32CD32";
    }

    public void red() {
        cor = "#FF0000";
    }

    public void orange() {
        cor = "#FFA500";
    }

    public void purple() {
        cor = "#EE82EE";
    }

    public void line() {
        cond = 0;
        click = 0;
        invalidate();
    }

    public void square() {
        cond = 1;
        click = 0;

        invalidate();
    }

    public void circle() {
        cond = 2;
        click = 0;

        invalidate();
    }

    public void poli() {
        cond = 3;
        invalidate();
    }

    public void reset() {

        if (cond == 0) {
            linhas.clear();
        } else if (cond == 1) {
            retangulos.clear();
        } else if (cond == 2) {
            circulos.clear();
        } else if (cond == 3) {
            poligonos.clear();
        }

    }

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        pInicial = new Ponto2D();
        pFinal = new Ponto2D();
        cor = "#CD5C5C";
    }


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        pInicial = new Ponto2D();
        pFinal = new Ponto2D();
        cor = "#CD5C5C";

    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
        pInicial = new Ponto2D();
        pFinal = new Ponto2D();
        cor = "#CD5C5C";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 100;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(10);
        canvas.drawPaint(paint);
        if (cond == 0) {
            invalidate();
            for (int i = 0; i < linhas.size(); i++) {
                Segmento_de_Reta novoSeg = (Segmento_de_Reta) linhas.elementAt(i);
                float pt1 = (float) novoSeg.getP1().getX();
                float pt2 = (float) novoSeg.getP1().getY();
                float pt3 = (float) novoSeg.getP2().getX();
                float pt4 = (float) novoSeg.getP2().getY();
                paint.setColor(Color.parseColor(novoSeg.retornarCor()));
                canvas.drawLine(pt1, pt2, pt3, pt4, paint);
                invalidate();
            }
        }
        if (cond == 1) {
            invalidate();
            for (int i = 0; i < retangulos.size(); i++) {
                Retangulo novoRect = (Retangulo) retangulos.elementAt(i);
                float ponto1 = (float) novoRect.getPontoA().getX();
                float ponto2 = (float) novoRect.getPontoA().getY();
                float ponto3 = (float) novoRect.getPontoB().getX();
                float ponto4 = (float) novoRect.getPontoB().getY();
                paint.setColor(Color.parseColor(novoRect.retornarCor()));
                canvas.drawRect(ponto1, ponto2, ponto3, ponto4, paint);
                invalidate();
            }
        }
        if (cond == 2) {
            invalidate();
            for (int i = 0; i < circulos.size(); i++) {
                Circulo novoCirc = (Circulo) circulos.elementAt(i);
                float pontoXa = (float) novoCirc.getPA().getX();
                float pontoYa = (float) novoCirc.getPA().getY();
                float nRaio = novoCirc.getRaio();
                paint.setColor(Color.parseColor(novoCirc.retornarCor()));
                canvas.drawCircle(pontoXa, pontoYa, nRaio, paint);
                invalidate();
            }
        }
        if (cond == 3) {
            invalidate();
            if (poligonos.size() >= 2) {
                for (int i = 2; i <= poligonos.size(); i++) {
                    Poligono novoPoli = (Poligono) poligonos.elementAt(i - 1);
                    Poligono novoPoli2 = (Poligono) poligonos.elementAt(i - 2);
                    paint.setColor(Color.parseColor(novoPoli.retornarCor()));
                    paint.setColor(Color.parseColor(novoPoli2.retornarCor()));

                    canvas.drawLine((float) novoPoli.x, (float) novoPoli.y, (float) novoPoli2.x, (float) novoPoli2.y, paint);
                }
                Poligono PoliInicial = (Poligono) poligonos.elementAt(0);
                Poligono PoliFinal = (Poligono) poligonos.elementAt(poligonos.size() - 1);
                paint.setColor(Color.parseColor(PoliInicial.retornarCor()));
                paint.setColor(Color.parseColor(PoliFinal.retornarCor()));

                canvas.drawLine((float) PoliFinal.x, (float) PoliFinal.y, (float) PoliInicial.x, (float) PoliInicial.y, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            double x = (double) event.getX();
            double y = (double) event.getY();

            //GUARDAR PONTO INICIAL E FINAL

            if (click == 0) {
                pInicial.setX((float) x);
                pInicial.setY((float) y);
                click++;
            } else if (click == 1) {
                pFinal.setX((float) x);
                pFinal.setY((float) y);

                float p1 = (float) pInicial.getX();
                float p2 = (float) pInicial.getY();
                Ponto2D pontoInicialT = new Ponto2D((int) p1, (int) p2);

                float p3 = (float) pFinal.getX();
                float p4 = (float) pFinal.getY();
                Ponto2D pontoFinalT = new Ponto2D((int) p3, (int) p4);


                if (cond == 0) {
                    Segmento_de_Reta retas = new Segmento_de_Reta(pontoInicialT, pontoFinalT, String.valueOf(cor));
                    linhas.addElement(retas);
                }

                if (cond == 1) {
                    Retangulo rect = new Retangulo(pontoInicialT, pontoFinalT, String.valueOf(cor));
                    retangulos.addElement(rect);
                }

                if (cond == 2) {
                    Circulo circles = new Circulo(pontoInicialT, pontoFinalT, String.valueOf(cor));
                    circulos.addElement(circles);
                }
                click = 0;
            }

            if (cond == 3) {
                Poligono polis = new Poligono(x, y, String.valueOf(cor));
                poligonos.addElement(polis);
            }

        }
        return super.onTouchEvent(event);
    }

}
