package com.syntrice.chess;

import com.syntrice.chess.gui.Board;
import com.syntrice.chess.gui.Sidebar;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    Board board = new Board();
    Sidebar sidebar = new Sidebar();

    public Application() {
        board.setPreferredSize(new Dimension(600,600));
        sidebar.setPreferredSize(new Dimension(300,600));
        this.add(board, BorderLayout.WEST);
        this.add(sidebar, BorderLayout.EAST);
        this.pack();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //application.setResizable(false);
        application.setVisible(true);
    }
}
