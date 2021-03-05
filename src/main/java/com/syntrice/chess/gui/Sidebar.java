package com.syntrice.chess.gui;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {

    JLabel title;

    public Sidebar () {
        this.setBackground(Color.DARK_GRAY);
        title = new JLabel();
        title.setForeground(Color.white);
        title.setText("Java Chess Game");
        this.add(title);
    }


}
