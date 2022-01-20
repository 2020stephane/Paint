import Panel.MyFrame;

public final class Paint {

    public Paint() {
        new MyFrame();
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(Paint::new);
    }
}