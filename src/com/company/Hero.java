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

public class Hero extends AnimatedThings{
    int nbLives = 3;
    public Hero(String filename){
        super(filename);

        this.x=21;
        this.y=13;
        this.h=85;
        this.index=0;
        Rectangle2D frame1 = new Rectangle2D(x, y, 55, h);
        this.spriteSheet = new ImageView(sheet);
        this.spriteSheet.setViewport(frame1);
        this.spriteSheet.setX(200);
        this.spriteSheet.setY(0);
        int nbLives = 3;
    }
    @Override
    public void update (long frameDelay) {
        if (this.index==0){     //passage a la 2eme image
            this.x=95;
            this.y=3;
            this.h=95;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 66, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==1){     //passage a la 3eme image
            this.x=173;
            this.y=15;
            this.h=83;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 77, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==2){
            this.x=273;
            this.y=13;
            this.h=85;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 56, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==3){
            this.x=349;
            this.y=4;
            this.h=94;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 63, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==4){
            this.x=427;
            this.y=17;
            this.h=81;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 73, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==5){
            this.index=-1;
            this.x=21;
            this.y=13;
            this.h=85;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 55, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==6){     //saut ascendant
            this.index=-1;
            this.x=21;
            this.y=163;
            this.h=98;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 47, h);
            this.spriteSheet.setViewport(currentFrame);
        }
        if (this.index==7){     //saut descendant
            this.index=-1;
            this.x=95;
            this.y=163;
            this.h=93;
            Rectangle2D currentFrame = new Rectangle2D(x, y, 63, h);
            this.spriteSheet.setViewport(currentFrame);
        }
    }
}
