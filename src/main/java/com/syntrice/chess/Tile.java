package com.syntrice.chess;
import com.syntrice.chess.coordinate.Coordinate;

public class Tile {
    private Color color;
    private Coordinate coordinate;

    public Tile(Color color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
