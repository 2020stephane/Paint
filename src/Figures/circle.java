package Figures;

import java.awt.*;

public class circle {

    private final int rayon;
    private final int x;
    private final int y;
    private final Color couleur;

//****************CONSTRUCTEURS***********************

     public circle(int x1, int y1, int r, Color color) {
        this.x = x1;
        this.y = y1;
        this.rayon = r;
        this.couleur = color;
     }
//*****************METHODES***************************

    public  int getcirclex() {

        return this.x;
    }
    public  int getcircley() {

        return this.y;
    }
    public  int getcircleR() {

        return this.rayon;
    }
    public  Color getcircleC() {

        return this.couleur;
    }

}
