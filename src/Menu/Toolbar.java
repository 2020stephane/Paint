package Menu;

import Figures.shape;
import Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Toolbar implements ActionListener {

    private JButton btnColor;
    private JDialog colorDialog;
    private JColorChooser colorChooser;
    private JComboBox<String> cbTools;

    public Toolbar() {  }

    public  JToolBar toolbar(Frame frame) {

        colorDialog = new JDialog(frame, "Color Chooser", false);
        colorChooser = new JColorChooser(Color.black);
        colorDialog.add(colorChooser);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        toolBar.add(createSeparator());
        toolBar.add(newImage());
        toolBar.add(openImage());
        toolBar.add(saveImage());
        toolBar.add(createSeparator());
        toolBar.add(cutImage());
        toolBar.add(copyImage());
        toolBar.add(createSeparator());
        toolBar.add(undoImage());
        toolBar.add(redoImage());
        toolBar.add(createSeparator());
        toolBar.add(colors());
        toolBar.add(createSeparator());
        toolBar.add(cbTools());
        return toolBar;
    }

    private JComboBox<String> cbTools() {
        cbTools = new JComboBox<>();

        cbTools.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Pencil", "Line", "Rectangle",
                        "Oval"}));
        cbTools.setMaximumSize(new java.awt.Dimension(140, 25));
        cbTools.addActionListener(this);
        return cbTools;
    }

    private JButton newImage() {
        JButton btnNew = new JButton();
        btnNew.setIcon(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/icon/newFile.png"))));
        btnNew.addActionListener(this);
        return btnNew;
    }

    private JButton openImage() {
        JButton btnOpen = new JButton();
        btnOpen.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/openFile.png"))));
        btnOpen.addActionListener(this);
        return btnOpen;
    }

    private JButton saveImage() {
        JButton btnSave = new JButton();
        btnSave.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/save.png"))));
        btnSave.addActionListener(this);
        return btnSave;
    }

    private JButton cutImage() {
        JButton btnCut = new JButton();
        btnCut.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/scissors.png"))));
        btnCut.addActionListener(this);
        return btnCut;
    }

    private JButton copyImage() {
        JButton btnCopy = new JButton();
        btnCopy.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/copy.png"))));
        btnCopy.addActionListener(this);
        return btnCopy;
    }


    private JButton undoImage() {
        JButton btnUndo = new JButton();
        btnUndo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/undo.png"))));
        btnUndo.addActionListener(this);
        return btnUndo;
    }

    private JButton redoImage() {
        JButton btnRedo = new JButton();
        btnRedo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/redo.png"))));
        btnRedo.addActionListener(this);
        return btnRedo;
    }

    private JButton colors() {
        btnColor = new JButton();
        btnColor.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/icon/palete.png"))));
        btnColor.addActionListener(this);
        return btnColor;
    }

    private JToolBar.Separator createSeparator() {
        return new JToolBar.Separator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();

        if (event == btnColor) {
            actionColorPicker();
        }else if (event == cbTools) {
            actionPickTools(e);
        }
    }

    private void actionColorPicker() {
        colorDialog.setVisible(true);
        colorDialog.setSize(620, 350);
        colorChooser.getSelectionModel().addChangeListener(
                e -> {
                    Color newColor = colorChooser.getColor();
                    if (newColor != null) {
                        Mypanel.setCouleur(newColor);
                    }

                });

    }
    private void actionPickTools(ActionEvent e) {
        JComboBox<?> cb = (JComboBox<?>) e.getSource();
        String string = (String) cb.getSelectedItem();
        switch (Objects.requireNonNull(string)) {
            case "Pencil" -> Mypanel.setShape(shape.PENCIL);
            case "Line" -> Mypanel.setShape(shape.LINE);
            case "Rectangle" -> Mypanel.setShape(shape.RECTANGLE);
            case "Oval" -> Mypanel.setShape(shape.CIRCLE);
        }
    }
}

