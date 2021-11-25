package com.company;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends AnimatedThings{
    public Enemy(String filename, int x, int y, int w, int h, int posx, int posy){
        super(filename);

        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.posx=posx;
        this.posy=posy;
        this.index=0;
        Rectangle2D frame1 = new Rectangle2D(x, y, w, h);
        Rectangle2D frame2 = new Rectangle2D(x+5,y+5,w-5,h-5);
        this.hitbox = new ImageView(sheet);
        this.hitbox.setViewport(frame2);
        this.spriteSheet = new ImageView(sheet);
        this.spriteSheet.setViewport(frame1);
        this.spriteSheet.setX(posx);
        this.spriteSheet.setY(posy);
        this.hitbox.setX(posx);
        this.hitbox.setY(posy);
    }
    @Override
    public void update (long frameDelay) {
        spriteSheet.setX(x);
        /*if (this.index==0){     //passage a la 2eme image
            this.x=95;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 66, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==1){     //passage a la 3eme image
            this.x=173;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 77, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==2){
            this.x=273;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 56, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==3){
            this.x=349;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 62, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==4){
            this.x=427;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 73, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==5){
            this.index=-1;
            this.x=21;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 75, 100);
            this.spriteSheet.setViewport(currentFrame);
        }
*/
    }
}
