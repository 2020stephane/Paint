package Figures;

import java.awt.*;

public class Point {

    private int x;
    private int y;
    private Color color = Color.black;

//****************CONSTRUCTEURS***********************

    public Point() {
        this.x = 0;
        this.y = 0;

    }
    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

//*****************METHODES***************************

    public void setX(int x)  {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public Color getPointcolor() {
        return this.color;
    }
}
