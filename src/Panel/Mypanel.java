package Panel;

import Figures.*;
import Menu.*;
import Figures.Point;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mypanel extends JPanel {

    static int x_start = 0;
    static int y_start = 0;
    static int x_end = 0;
    static int y_end = 0;
    static int mousex = 0;
    static int mousey = 0;
    static boolean mouse_pressed = false;
    static boolean mouse_released = false;
    static boolean mouse_dragged = false;
    static boolean on_screen = false;
    public static Color couleur = Color.BLACK;
    public static shape currentshape = shape.PENCIL;


    ArrayList<Point> MyPoints = new ArrayList<>();
    ArrayList<line> MyLines = new ArrayList<>();
    ArrayList<rect> MyRectangles = new ArrayList<>();
    ArrayList<circle> MyCircles = new ArrayList<>();

    public Mypanel() {
        Mouse action = new Mouse();
        this.addMouseListener(action);
        this.addMouseMotionListener(action);
    }

    @Override
    public void paintComponent(Graphics g) {

        if (on_screen){
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        draw(g);
        repaint();
    }

    public void draw(Graphics g) {

        g.setColor(couleur);

        if (mouse_pressed) {
            if (currentshape == shape.PENCIL) {
                Point currentpoint = new Point(x_start, y_start, couleur);
                MyPoints.add(currentpoint);
            }
            mouse_pressed = false;
        }

        if (mouse_released) {
            if (currentshape == shape.PENCIL) {
                Point currentpoint = new Point(x_end, y_end, couleur);
                MyPoints.add(currentpoint);
            }
            if (currentshape == shape.LINE) {
                line curentline = new line(x_start, y_start, x_end, y_end, couleur);
                MyLines.add(curentline);
            }
            if (currentshape == shape.RECTANGLE) {
                rect currentrectangle = new rect(x_start, y_start, x_end - x_start,
                        y_end - y_start, couleur);
                MyRectangles.add((currentrectangle));
            }
            if (currentshape == shape.CIRCLE) {
                circle currentcircle = new circle(x_start, y_start, x_end - x_start, couleur);
                MyCircles.add((currentcircle));
            }
            x_start = x_end;
            y_start = y_end;
            mouse_released = false;
        }

        if (mouse_dragged) {
            if (currentshape == shape.PENCIL) {
                Point currentpoint = new Point(x_end, y_end, couleur);
                MyPoints.add(currentpoint);
                g.setColor(couleur);
                g.drawLine( x_end, y_end, x_end, y_end);
            }
            if (currentshape == shape.LINE) {
                g.setColor(couleur);
                g.drawLine(x_start, y_start, x_end, y_end);
            }
            if (currentshape == shape.RECTANGLE) {
                g.setColor(couleur);
                if (x_start < x_end & y_start < y_end) {
                    g.drawRect(x_start, y_start, x_end - x_start,y_end - y_start);
                }

            }
            if (currentshape == shape.CIRCLE) {
                g.setColor(couleur);
                g.drawOval(x_start, y_start, x_end - x_start,x_end - x_start);
            }
            mouse_released = false;
        }
        if ( MyCircles.size() !=0 ) {
            for (int i=0; i<MyCircles.size(); i++) {

                g.setColor(MyCircles.get(i).getcircleC());
                g.drawOval(MyCircles.get(i).getcirclex(), MyCircles.get(i).getcircley(),
                        MyCircles.get(i).getcircleR(), MyCircles.get(i).getcircleR());
            }
        }
        if ( MyLines.size() !=0 ) {
            for (int i = 0; i < MyLines.size(); i++) {

                g.setColor(MyLines.get(i).getLinecolor());
                g.drawLine(MyLines.get(i).getLinex1(),MyLines.get(i).getLiney1(),
                        MyLines.get(i).getLinex2(), MyLines.get(i).getLiney2());
            }
        }
        if ( MyPoints.size() !=0 ) {
            for (Point myPoint : MyPoints) {

                g.setColor(myPoint.getPointcolor());
                g.drawLine(myPoint.getX(), myPoint.getY(),
                        myPoint.getX(), myPoint.getY());
            }
        }
        if ( MyRectangles.size() !=0 ) {
            for (int i = 0; i<MyRectangles.size(); i++) {

                g.setColor(MyRectangles.get(i).getRectcolor());
                g.drawRect(MyRectangles.get(i).getRectx(), MyRectangles.get(i).getRecty(),
                        MyRectangles.get(i).getRectw(), MyRectangles.get(i).getRecth());
            }
        }
        printCoords();
        printDrawerSize();

    }
    public static void setCouleur(Color col) {

        couleur = col;
    }
    public static void setShape(shape sp) {

        currentshape = sp;
    }

    public void printCoords() {
        String posX = String.valueOf(mousex);
        String posY = String.valueOf(mousey);
        JLabel lsb = StatusBar.getLblCoords();
        lsb.setText(posX + ",  " + posY + " px");
    }
    public void printDrawerSize() {
        String width = String.valueOf(this.getWidth());
        String height = String.valueOf(this.getHeight());
        JLabel lds =  StatusBar.getLblDrawerSize();
        lds.setText(width + ",  " + height + " px");
    }

}