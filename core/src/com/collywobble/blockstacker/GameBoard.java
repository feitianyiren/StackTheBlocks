package com.collywobble.blockstacker;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameBoard extends Actor {
    int[][] array;
    Rectangle boardOutline;
    Texture boardOutLineTexture;
    final int WIDTH = 1 + (25 * 10) + 1;
    final int HEIGHT = 1 + (25 * 20) + 1;
    final int START_X = 50 - 1;
    final int START_Y = 800 - HEIGHT - 50 + 1;


    public GameBoard() {
        makeBoardArray();
        boardOutline = new Rectangle(START_X, START_Y, WIDTH, HEIGHT);
        makeBoardOutlineTexture();

    }

    private void makeBoardArray() {
        array = new int[25][25];

        for (int i = 0; i < array.length; i++) {
            array[i][1] = 9;
            array[i][12] = 9;
        }
        for (int i = 0; i < array[0].length; i++) {
            array[22][i] = 9;
        }

    }

    private void makeBoardOutlineTexture() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.drawRectangle(0, 0, WIDTH, HEIGHT);
        boardOutLineTexture = new Texture(pixmap);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(boardOutLineTexture, boardOutline.getX(), boardOutline.getY());
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }
}
