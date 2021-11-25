package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedThings {
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    protected double x;
    protected double y;
    protected double w;
    protected double h;
    protected double posx;
    protected double posy;
    protected ImageView spriteSheet;
    protected ImageView hitbox;
    protected Image sheet;

    protected int index;   //on teste
    protected int frameDelay;
    protected int maxIndex;
    protected int offset;
    protected int totalFrames;




    public ImageView getSpriteSheet() {
        return spriteSheet;
    }

    public AnimatedThings(String filename) {
        this.sheet = new Image(filename);

    }
  /*
    public Rectangle2D getHitBox(){

    }
    */
    abstract public void update(long frameDelay);

}