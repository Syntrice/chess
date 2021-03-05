package com.syntrice.chess;
import com.syntrice.chess.coordinate.Coordinate;
import com.syntrice.chess.piece.Piece;

public class Tile {
    private Color color;
    private final Coordinate coordinate;
    private Piece piece;

    public Tile(Color color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

    public Color getColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
    }

    public boolean hasPiece() {
        return !(piece == null);
    }

}
