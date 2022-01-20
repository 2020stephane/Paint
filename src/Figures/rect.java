package Figures;

import java.awt.*;

public class rect {

    private  final int x;
    private  final int y;
    private  final int width;
    private  final int height;
    private  final Color color;

//****************CONSTRUCTEURS***********************

    public rect(int x1, int y1, int x2, int y2, Color color) {
        this.x = x1;
        this.y = y1;
        this.width = x2;
        this.height = y2;
        this.color = color;
    }
//*****************METHODES***************************

    public  int getRectx() {
        return (this.x);
    }
    public  int getRecty() {
        return (this.y);
    }
    public  int getRectw() {
        return (width);
    }
    public  int getRecth() {
        return (height);
    }
    public  Color getRectcolor() {
        return (color);
    }
}
