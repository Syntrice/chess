package com.syntrice.chess;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final int gridWidth = 8, gridHeight = 8;
    private final int panelWidth = 600, panelHeight = 600;
    private final int tileWidth, tileHeight;

    private final Tile[][] grid;

    public Board() {
        grid = new Tile[gridWidth][gridHeight];
        tileWidth = panelWidth / gridWidth;
        tileHeight = panelHeight / gridHeight;
        initializeGrid();
        repaint();
    }

    public void draw() {

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(panelWidth,panelHeight);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < gridWidth; r++) {
            for (int c = 0; c < gridHeight; c++) {
                if (grid[r][c].getColor() == Color.WHITE) {
                    g.setColor(java.awt.Color.WHITE);
                } else {
                    g.setColor(java.awt.Color.BLACK);
                }
                g.fillRect(tileWidth * c, tileHeight * r, tileWidth, tileHeight);
            }
        }
    }

    private void initializeGrid() {
        for (int r = 0; r < gridWidth; r++) {
            for (int c = 0; c < gridHeight; c++) {
                grid[r][c] = (r + c) % 2 == 0 ? new Tile(Color.WHITE) : new Tile(Color.BLACK);
                System.out.println(grid[r][c].getColor());
            }
        }
    }
}
