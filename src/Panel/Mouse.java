package Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener , MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {  }

    @Override
    public void mousePressed(MouseEvent e) {

        Mypanel.mouse_pressed = true;
        Mypanel.x_start = e.getPoint().x;
        Mypanel.y_start = e.getPoint().y;
        Mypanel.x_end = e.getPoint().x;
        Mypanel.y_end = e.getPoint().y;
   }

    @Override
    public void mouseReleased(MouseEvent e) {
        Mypanel.mouse_released = true;
        Mypanel.x_end = e.getPoint().x;
        Mypanel.y_end = e.getPoint().y;

    }

    public void mouseDragged(MouseEvent e) {

        Mypanel.mouse_dragged = true;
        Mypanel.x_end = e.getPoint().x;
        Mypanel.y_end = e.getPoint().y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Mypanel.mousex = e.getPoint().x;
        Mypanel.mousey = e.getPoint().y;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Mypanel.on_screen = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {

        Mypanel.on_screen = false;
    }
}
