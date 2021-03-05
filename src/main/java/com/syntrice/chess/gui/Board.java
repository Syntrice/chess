package com.syntrice.chess.gui;

import com.syntrice.chess.Tile;
import com.syntrice.chess.coordinate.Coordinate;
import com.syntrice.chess.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {
    private final int GRID_WIDTH = 8, GRID_HEIGHT = 8;
    private int tileWidth, tileHeight;

    private final Tile[][] GRID;

    public Board() {
        GRID = new Tile[GRID_WIDTH][GRID_HEIGHT];
        initializeGrid();
        repaint();
        placePieces();
        this.addMouseListener(this);
    }

    /**
     * Override method to round width and height down to nearest multiple of number of squares.
     * @param preferredSize prefered size to set
     */
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        int width = (int) (GRID_WIDTH * Math.floor(Math.abs(preferredSize.getWidth() / GRID_WIDTH)));
        int height = (int) (GRID_HEIGHT * Math.floor(Math.abs(preferredSize.getHeight() / GRID_HEIGHT)));
        preferredSize.setSize(width, height);
        super.setPreferredSize(preferredSize);
        tileWidth = width / GRID_WIDTH;
        tileHeight = height / GRID_HEIGHT;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    /**
     * Draws the grid
     * @param g graphics to draw to
     */
    private void paintGrid(Graphics g) {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                if (GRID[x][y].getColor() == com.syntrice.chess.Color.WHITE) {
                    g.setColor(java.awt.Color.WHITE);
                } else {
                    g.setColor(java.awt.Color.BLACK);
                }
                g.fillRect(tileWidth * x, tileHeight * y, tileWidth, tileHeight);

                if (GRID[x][y].hasPiece()) {
                    if (GRID[x][y].getPiece().getColor() == com.syntrice.chess.Color.WHITE) {
                        g.setColor(Color.lightGray);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.fillOval(tileWidth * x, tileHeight * y, tileWidth, tileHeight);
                }


            }
        }
    }

    /**
     * Fills the grid with new tiles in a checkered pattern, corresponding to the given size.
     */
    private void initializeGrid() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                GRID[x][y] = (x + y) % 2 == 0 ? new Tile(com.syntrice.chess.Color.WHITE, new Coordinate(x,y)) : new Tile(com.syntrice.chess.Color.BLACK, new Coordinate(x,y));
            }
        }
    }

    private void placePieces() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < 2; y++) {
                GRID[x][y].setPiece(new Piece(com.syntrice.chess.Color.WHITE));
            }
        }

        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = GRID_HEIGHT - 1; y > GRID_HEIGHT - 3; y--) {
                GRID[x][y].setPiece(new Piece(com.syntrice.chess.Color.BLACK));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click at X Coordinate: " + e.getX() / tileWidth + ", Y Coordinate: " + e.getY() / tileHeight);
        int x = e.getX() / tileWidth;
        int y = e.getY() / tileHeight;
        if (!GRID[x][y].hasPiece()) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                GRID[x][y].setPiece(new Piece(com.syntrice.chess.Color.WHITE));
            }

            if (e.getButton() == MouseEvent.BUTTON1) {
                GRID[x][y].setPiece(new Piece(com.syntrice.chess.Color.BLACK));
            }
        }
        else {
            GRID[x][y].removePiece();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
