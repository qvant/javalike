package org.example.graphics;

import asciiPanel.AsciiPanel;

import java.awt.*;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BONDS('x', AsciiPanel.brightBlack),
    ;

    private char glyph;
    private Color color;

    public char getGlyph() {
        return glyph;
    }

    public Color getColor() {
        return color;
    }

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }
}
