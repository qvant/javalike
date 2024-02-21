package org.example.screens.impl;

import asciiPanel.AsciiPanel;
import org.example.screens.Screen;

import java.awt.event.KeyEvent;

public class WinScreen implements Screen {
    @Override
    public void display(AsciiPanel terminal) {
        terminal.write("You are won", 1, 1);
        terminal.write("--Press [Enter] to restart --", 22, 22);
    }

    @Override
    public Screen processInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER){
            return new PlayScreen();
        }
        return this;
    }
}
