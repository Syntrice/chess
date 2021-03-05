package com.syntrice.chess.piece;

import com.syntrice.chess.Color;

public class Piece {

    Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
