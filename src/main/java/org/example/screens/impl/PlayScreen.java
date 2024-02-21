package org.example.screens.impl;

import asciiPanel.AsciiPanel;
import org.example.graphics.World;
import org.example.graphics.WorldBuilder;
import org.example.screens.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    private World world;
    private int centerWidth;
    private int centerHeight;
    private int screenWidth;
    private int screenHeight;

    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
    }

    private void createWorld(){
        world = new WorldBuilder(90, 31).makeCaves().build();
    }

    public int getScrollX(){
        return Math.max(0, Math.min(centerWidth - screenWidth / 2, world.getWidth() - screenWidth));
    }

    public int getScrollY(){
        return Math.max(0, Math.min(centerHeight - screenHeight / 2, world.getHeight() - screenHeight));
    }

    private void displayWorld(AsciiPanel terminal, int left, int top){
        for(int x = 0; x < screenWidth; x++){
            for(int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;
                char glyph = world.getGlyph(wx, wy);
                Color color = world.getColor(wx, wy);
                terminal.write(glyph, x, y, color);
            }
        }
    }

    @Override
    public void display(AsciiPanel terminal) {
        terminal.write("Some gameplay", 1, 1);
        terminal.write("--Press [Enter] to win or [Escape] to lose --", 22, 22);
        int left = getScrollX();
        int top = getScrollX();
        displayWorld(terminal, left, top);
        terminal.write('X', centerWidth - left, centerHeight - top);
    }
    private void scrollBy(int mx, int my){
        centerWidth = Math.max(0, Math.min(centerWidth + mx, world.getWidth() - 1));
        centerHeight = Math.max(0, Math.min(centerHeight + my, world.getHeight() - 1));
    }

    @Override
    public Screen processInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_H:
            case KeyEvent.VK_LEFT: scrollBy(-1, 0);break;
            case KeyEvent.VK_L:
            case KeyEvent.VK_RIGHT: scrollBy(1, 0);break;
            case KeyEvent.VK_J:
            case KeyEvent.VK_DOWN: scrollBy(0, 1);break;
            case KeyEvent.VK_K:
            case KeyEvent.VK_UP: scrollBy(0, -1);break;
            case KeyEvent.VK_Y: scrollBy(-1, -1);break;
            case KeyEvent.VK_U: scrollBy(1, -1);break;
            case KeyEvent.VK_B: scrollBy(-1, 1);break;
            case KeyEvent.VK_N: scrollBy(1, 1);
        }
        return this;
    }
}
