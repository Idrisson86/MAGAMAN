package com.company;

import javafx.animation.AnimationTimer;
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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;


public class GameScene extends Scene{
    public GameScene (Group root, int x, int y) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(root, 800, 400, true);
        heart1.imageSheet.setFitHeight(30);
        heart1.imageSheet.setFitWidth(20);
        heart2.imageSheet.setFitHeight(30);
        heart2.imageSheet.setFitWidth(20);
        heart3.imageSheet.setFitHeight(30);
        heart3.imageSheet.setFitWidth(20);

        back.spriteSheet.setFitWidth(800);
        back.spriteSheet.setFitHeight(400);

        nextBack.spriteSheet.setFitWidth(800);
        nextBack.spriteSheet.setFitHeight(400);

        far.spriteSheet.setFitWidth(960);
        far.spriteSheet.setFitHeight(480);

        nextFar.spriteSheet.setFitWidth(960);
        nextFar.spriteSheet.setFitHeight(480);

        monster1.spriteSheet.setFitHeight(86); //86
        monster1.spriteSheet.setFitWidth(120);  //120

        monster2.spriteSheet.setFitHeight(101); //101
        monster2.spriteSheet.setFitWidth(91);  //

        monster3.spriteSheet.setFitHeight(101); //101
        monster3.spriteSheet.setFitWidth(91);  //

        monster2.setX(1400);
        monster2.setY(121);

        root.getChildren().add(far.spriteSheet);
        root.getChildren().add(nextFar.spriteSheet);

        root.getChildren().add(back.spriteSheet);
        root.getChildren().add(nextBack.spriteSheet);

        root.getChildren().add(heart1.getImageSheet());
        root.getChildren().add(heart2.getImageSheet());
        root.getChildren().add(heart3.getImageSheet());

        root.getChildren().add(mega.spriteSheet);
        root.getChildren().add(monster1.spriteSheet);
        root.getChildren().add(monster2.spriteSheet);
        root.getChildren().add(monster3.spriteSheet);
        root.getChildren().add(death.getImageSheet());

    }

    //staticThings leftback = new staticThings(0, 0, "C:\\Users\\idris\\Documents\\ENSEA\\2A\\S7\\Informatique\\Java\\desert.png");
    //staticThings rightback = new staticThings(800, 0, "C:\\Users\\idris\\Documents\\ENSEA\\2A\\S7\\Informatique\\Java\\desert.png");
    Hero mega = new Hero("./image/heros.png");
    DarkHero Idris = new DarkHero("image\\DarkHero.png");
    //Background platform = new Background("C:\\Users\\idris\\Documents\\ENSEA\\2A\\S7\\Informatique\\Java\\pngegg.png",500);
    Enemy monster1 = new Enemy("image\\monster.png",7,0,199,150,400,264);
    Enemy monster2 = new Enemy("image\\trump1.png",0,0,548,610,400,121);
    Enemy monster3 = new Enemy("image\\trump2.png",0,0,548,610,400,241);
    staticThings heart1 = new staticThings(20, 20, "image\\CoeurHumain.svg.png");
    staticThings heart2 = new staticThings(50, 20, "image\\CoeurHumain.svg.png");
    staticThings heart3 = new staticThings(80, 20, "image\\CoeurHumain.svg.png");
    staticThings death = new staticThings(1000,50,"image\\youdied.png");
    Background far = new Background("image\\fond.jpg",0,1920,960);
    Background nextFar = new Background("image\\fond.jpg",0,1920,960);
    Background back = new Background("image\\fond2.png",0,1920,960);
    Background nextBack = new Background("image\\fond2.png",800,1920,960);
    Double xc = 100.0;
    Camera cam1 = new Camera(mega);
    public void render(Double heroposx, Double xc){
        mega.setX(heroposx-xc);
        back.setX(-(xc%800));
        nextBack.setX(800-(xc%800));
    }
    public void getHit(){
        if (mega.nbLives == 2){
            heart3.imageSheet.setX(1000);
        }
        if (mega.nbLives == 1){
            heart2.imageSheet.setX(1000);
        }
        if (mega.nbLives == 0){
            heart1.imageSheet.setX(1000);
        }
    }

}
