package com.syntrice.chess.gui;

import com.syntrice.chess.Tile;
import com.syntrice.chess.coordinate.Coordinate;

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
        for (int r = 0; r < GRID_WIDTH; r++) {
            for (int c = 0; c < GRID_HEIGHT; c++) {
                if (GRID[r][c].getColor() == com.syntrice.chess.Color.WHITE) {
                    g.setColor(java.awt.Color.WHITE);
                } else {
                    g.setColor(java.awt.Color.BLACK);
                }
                g.fillRect(tileWidth * c, tileHeight * r, tileWidth, tileHeight);
            }
        }
    }

    /**
     * Fills the grid with new tiles in a checkered pattern, corresponding to the given size.
     */
    private void initializeGrid() {
        for (int r = 0; r < GRID_WIDTH; r++) {
            for (int c = 0; c < GRID_HEIGHT; c++) {
                GRID[r][c] = (r + c) % 2 == 0 ? new Tile(com.syntrice.chess.Color.WHITE, new Coordinate(r,c)) : new Tile(com.syntrice.chess.Color.BLACK, new Coordinate(r,c));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click at X Coordinate: " + e.getX() / tileWidth + ", Y Coordinate: " + e.getY() / tileHeight);
        int x = e.getX() / tileWidth;
        int y = e.getY() / tileHeight;
        if (GRID[y][x].getColor() == com.syntrice.chess.Color.WHITE) {
            GRID[y][x].setColor(com.syntrice.chess.Color.BLACK);
        } else {
            GRID[y][x].setColor(com.syntrice.chess.Color.WHITE);
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
