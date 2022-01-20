package Panel;

import Menu.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MyFrame extends JFrame {


    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/moon.png")));
        setIconImage(logo.getImage());

        this.setTitle(" - Paint");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dim.height;
        int width = dim.width;
        this.setLocation(width /4, height /4);
        this.setSize(width/2,height/2);
        Mypanel mypanel = new Mypanel();

        this.setJMenuBar(new Menubar().menubar(this));
        JToolBar toolbar = new Toolbar().toolbar(this);
        StatusBar statusbar = new StatusBar();
        this.add(mypanel, BorderLayout.CENTER);
        this.add(toolbar, BorderLayout.PAGE_START);
        this.add(statusbar, BorderLayout.PAGE_END);
        this.setVisible(true);
    }

}
