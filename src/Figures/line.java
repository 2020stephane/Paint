package Figures;

import java.awt.*;

public class line  {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;

//****************CONSTRUCTEURS***********************

     public line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }
//*****************METHODES***************************

    public int getLinex1() {
        return (this.x1 );
    }
    public int getLiney1() {
        return (this.y1 );
    }
    public int getLinex2() {
        return (this.x2 );
    }
    public int getLiney2() {
        return (this.y2 );
    }
    public Color getLinecolor() {
        return (this.color );
    }

}
