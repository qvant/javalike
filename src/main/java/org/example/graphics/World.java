package org.example.graphics;

import java.awt.*;

public class World {
    private Tile[][] tiles;
    private int width;
    private int height;

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int width, int height){
        if (width < 0 || width >= this.width || height < 0 || height >= this.height){
            return Tile.BONDS;
        }
        return tiles[width][height];
    }
    public char getGlyph(int width, int height){
        return tiles[width][height].getGlyph();
    }
    public Color getColor(int width, int height){
        return tiles[width][height].getColor();
    }
}
