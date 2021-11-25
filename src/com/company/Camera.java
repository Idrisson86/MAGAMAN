package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class Camera {
    protected Double xc;
    protected Double yc;
    public Camera(Hero mega){
        this.xc=mega.getX()-100;
        this.yc=mega.getY()-100;
    }

    public void update(GameScene gameScene){
        gameScene.xc=gameScene.mega.getX()-100;
    }

    @Override
    public String toString() {
        return xc+", "+yc;
    }
}
