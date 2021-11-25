package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Background extends AnimatedThings{
    public Background(String filename, double position, double w, double h){
        super(filename);

        spriteSheet = getSpriteSheet();
        this.index=0;
        Rectangle2D frame1 = new Rectangle2D(x, y, w, h);
        this.spriteSheet = new ImageView(sheet);
        this.spriteSheet.setViewport(frame1);
        this.spriteSheet.setX(position);
        this.spriteSheet.setY(0);
    }
    @Override
    public void update (long frameDelay) {
        spriteSheet.setX(x);
    }

}
