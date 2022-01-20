package Menu;

import javax.swing.*;
import java.util.Objects;

public class StatusBar extends JToolBar {

    private static JLabel lbCoords;
    private static JLabel lbSize;

    public StatusBar() {
        setFloatable(false);
        setRollover(true);

        add(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/coordsPosition.png")))));
        add(drawerCoords());
        add(createSeparator());

        add(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/panelSize.png")))));
        add(drawerSize());
    }

    public static JLabel getLblCoords() {
        return lbCoords;
    }

    public static JLabel getLblDrawerSize() {
        return lbSize;
    }


    private JLabel drawerCoords() {
        lbCoords = new JLabel();
        lbCoords.setText("  0 x 0  ");
        return lbCoords;
    }

    private JLabel drawerSize() {
        lbSize = new JLabel();
        lbSize.setText("  0 x 0  ");
        return lbSize;
    }

    private Separator createSeparator() {
        return new Separator();
    }

}