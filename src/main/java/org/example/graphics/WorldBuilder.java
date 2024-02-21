package org.example.graphics;

public class WorldBuilder {
    private Tile[][] tiles;


    private int width;
    private int height;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public World build(){
        return new World(tiles);
    }

    private void generateTiles(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                tiles[i][j] = Math.random() < 0.5f ? Tile.FLOOR : Tile.WALL;
            }
        }
    }

    public WorldBuilder makeCaves(){
        generateTiles();
        smooth(8);
        return this;
    }

    private void smooth(int times){
        Tile[][] tiles2 = new Tile[width][height];
        for(int time = 0; time < times; time++){
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;
                    for(int ox = -1; ox < 2; ox++){
                        for(int oy = -1; oy < 2; oy++){
                            if( x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height){
                                continue;
                            }
                            if (tiles[x + ox][y + oy] == Tile.FLOOR){
                                floors++;
                            }
                            else {
                                rocks++;
                            }
                        }
                    }
                    if (floors > rocks){
                        tiles2[x][y] = Tile.FLOOR;
                    }
                    else {
                        tiles2[x][y] = Tile.WALL;
                    }
                }
            }
        }
        tiles = tiles2;
    }
}
