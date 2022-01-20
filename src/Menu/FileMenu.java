package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenu implements ActionListener {

    private Frame frame;
    private JMenu mFile;
    private JMenuItem mNew;
    private JMenuItem mOpen;
    private JMenuItem mSave;
    private JMenuItem mSaveAs;
    private JMenuItem mExit;

    public FileMenu(Frame fram) {
        this.frame = fram;
    }

    public JMenu fileItems() {
        mFile = new JMenu("File");

        mFile.add(fileNew());
        mFile.add(fileOpen());
        mFile.add(fileSave());
        mFile.add(fileSaveAs());
        mFile.add(fileExit());
        return mFile;
    }
    private JMenuItem fileNew() {
        mNew = new JMenuItem("New");
        mNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        mNew.addActionListener(this);
        return mNew;
    }

    private JMenuItem fileOpen() {
        mOpen = new JMenuItem("Open...");
        mOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        mOpen.addActionListener(this);
        return mOpen;
    }

    private JMenuItem fileSave() {
        mSave = new JMenuItem("Save");
        mSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        mSave.addActionListener(this);
        return mSave;
    }

    private JMenuItem fileSaveAs() {
        mSaveAs = new JMenuItem("Save as...");
        mSaveAs.setAccelerator(KeyStroke.getKeyStroke("ctrl alt S"));
        mSaveAs.addActionListener(this);
        return mSaveAs;
    }
    private JMenuItem fileExit() {
        mExit = new JMenuItem("Exit");
        mExit.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
        mExit.addActionListener(this);
        return mExit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
    }

}
