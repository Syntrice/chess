package com.syntrice.chess;

import javax.swing.*;

public class Application extends JFrame {

    Board board = new Board();

    public Application() {
        this.add(board);
        this.pack();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setResizable(false);
        application.setVisible(true);
    }
}
