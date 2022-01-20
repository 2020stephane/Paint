package Menu;

import javax.swing.*;
import java.awt.*;

public class Menubar {

    public  Menubar(){}

    public JMenuBar menubar(Frame frame) {

        JMenuBar mBar = new JMenuBar();
        FileMenu mFile = new FileMenu(frame);
        EditMenu mEdit = new EditMenu(frame);
        HelpMenu mHelp = new HelpMenu(frame);

        mBar.add(mFile.fileItems());
        mBar.add(mEdit.editItems());
        mBar.add(mHelp.helpItems());

        return mBar;
    }
}
