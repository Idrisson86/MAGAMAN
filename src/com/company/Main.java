// add any usefull package line
package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
;

public class Main extends Application{
// Variables gravité
    private static double vitesseY = 0;
    private static double g = 0.14d;
//Variables gauche/droite
    private static boolean droite = false;
    private static boolean gauche = false;
//Variables saut
    private static boolean saut = false;
    private static int TIMERSAUTVALUE = 80;
    private static double VITESSESAUT = 5.7;
    private static int timerSaut;
    private static double vMarche = 3.5;
    private int asc = 1;
//Variables scrolling
    private int scrollingSpeed = 0;
    private int stillR = 0;
    private int stillL = 0;
//Variables vies
    private boolean hit = false;
    private static int INVICIBILITY = 200;
    private static int timerInvincibility;

    public void start(Stage primaryStage) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        primaryStage.setTitle("MAGAMAN");
        Group root = new Group();

        GameScene gameScene = new GameScene(root, 1600, 400);
        primaryStage.setScene(gameScene);

        gameScene.nextBack.x=800;

        File file = new File("Projet - Shy Guy.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        AnimationTimer backTimer = new AnimationTimer() {
            @Override
            public void handle(long time){
                //gameScene.platform.y = 250;
                gameScene.back.update(time);
                gameScene.nextBack.update(time);
                gameScene.nextFar.update(time);
                gameScene.far.update(time);
                //if(gameScene.back.x!=-800) {
                    gameScene.far.x-=1;
                    gameScene.nextFar.x-=1;
                    gameScene.back.x -= 5;          //c'est ici qu'on peux choisir de mettre scrollingspeed ou non
                    gameScene.nextBack.x -= 5;      //mais bon j'aimerai bien avoir le systeme masse ressort a la place
                    //gameScene.platform.x -= 5;
                //}
                if(gameScene.nextBack.x<0){
                    gameScene.back.x=gameScene.nextBack.x+799;
                }
                if(gameScene.back.x<0){
                    gameScene.nextBack.x=gameScene.back.x+799;
                }
                if(gameScene.nextFar.x<0){
                    gameScene.far.x=gameScene.nextFar.x+960;
                }
                if(gameScene.far.x<0){
                    gameScene.nextFar.x=gameScene.far.x+960;
                }


                //gravité:
                if ((gameScene.mega.spriteSheet.getY()+gameScene.mega.h)<= 350){
                    gameScene.mega.spriteSheet.setY(gameScene.mega.spriteSheet.getY()+vitesseY);
                    vitesseY += g;
                }

                if (gameScene.mega.spriteSheet.getY()+gameScene.mega.h> 350){
                    gameScene.mega.spriteSheet.setY(350-gameScene.mega.h);
                }

                //déplacements:
                if(droite && gameScene.mega.spriteSheet.getX()+gameScene.mega.w<725) {
                    gameScene.mega.spriteSheet.setX(gameScene.mega.spriteSheet.getX() + vMarche);
                }
                else{
                    gameScene.mega.spriteSheet.setX(gameScene.mega.spriteSheet.getX());
                }
                if(gauche && gameScene.mega.spriteSheet.getX()>=0){
                    gameScene.mega.spriteSheet.setX(gameScene.mega.spriteSheet.getX() - vMarche);
                }
                else{
                    gameScene.mega.spriteSheet.setX(gameScene.mega.spriteSheet.getX());
                }
                if(saut){
                    gameScene.mega.spriteSheet.setY(gameScene.mega.spriteSheet.getY() + vitesseY);
                    timerSaut--;

                    if(timerSaut<=0){
                        saut = false;
                    }
                }
            }
        };
        backTimer.start();


        AnimationTimer heroTimer = new AnimationTimer() {

            public void handle(long time) {
                //défilement des sprites
                gameScene.mega.update(time);

                if (saut == false) {
                    gameScene.mega.index = (int) ((time / 90000000)) % 6;
                } else if (saut == true) {
                    if (asc == 1 && saut == true && gameScene.mega.spriteSheet.getY() > 35) {
                        gameScene.mega.index = 6;
                    }
                    if (saut == true && gameScene.mega.spriteSheet.getY() <= 35) {
                        asc = 0;
                        gameScene.mega.index = 7;
                    }
                }

                //hitbox
                if (gameScene.mega.spriteSheet.intersects(gameScene.monster1.spriteSheet.getLayoutBounds()) && (timerInvincibility <= 0)) {
                    hit = true;
                    gameScene.mega.nbLives--;
                    timerInvincibility = INVICIBILITY;
                    hit = false;
                } else {
                    hit = false;
                }
                timerInvincibility--;
                gameScene.getHit();

                if (gameScene.mega.spriteSheet.intersects(gameScene.monster2.spriteSheet.getLayoutBounds()) && (timerInvincibility <= 0)) {
                    hit = true;
                    gameScene.mega.nbLives--;
                    timerInvincibility = INVICIBILITY;
                    hit = false;
                } else {
                    hit = false;
                }
                timerInvincibility--;
                gameScene.getHit();

                if (gameScene.mega.spriteSheet.intersects(gameScene.monster3.spriteSheet.getLayoutBounds()) && (timerInvincibility <= 0)) {
                    hit = true;
                    gameScene.mega.nbLives--;
                    timerInvincibility = INVICIBILITY;
                    hit = false;
                } else {
                    hit = false;
                }
                timerInvincibility--;
                gameScene.getHit();
            }
        };
        heroTimer.start();

        AnimationTimer monsterTimer = new AnimationTimer() {

            public void handle(long time){
                gameScene.monster1.update(time);
                gameScene.monster2.update(time);
                gameScene.monster3.update(time);

                gameScene.monster1.x -= 5;
                if(gameScene.monster1.x<-200){
                    gameScene.monster1.x=gameScene.nextBack.x+1000;
                }
                gameScene.monster2.x -= 5;
                if(gameScene.monster2.x<-200){
                    gameScene.monster2.x=gameScene.monster1.x+1000;
                }
                gameScene.monster3.x -= 5;
                if(gameScene.monster3.x<-200){
                    gameScene.monster3.x=gameScene.monster2.x+1000;
                }
                if (gameScene.mega.nbLives<=0){
                    backTimer.stop();
                    heroTimer.stop();
                    this.stop();
                    gameScene.death.imageSheet.setX(-70);
                    clip.stop();
                }
            }
        };
        monsterTimer.start();

        gameScene.setOnKeyPressed(e -> {
            switch (e.getCode()) {

                case Q:
                    gauche = true;
                    stillL++;
                    stillR=0;
                    break;
                case D:
                    droite = true;
                    stillR++;
                    stillL=0;
                    break;
                case SPACE:
                    if (!saut) {
                        saut = true;
                        timerSaut = TIMERSAUTVALUE;
                        vitesseY = -VITESSESAUT;
                        asc = 1;
                    }
                    break;
                default:
                    break;
            }
        });

        gameScene.setOnKeyReleased(e -> {
            switch (e.getCode()) {

                case Q:
                    gauche = false;
                    break;
                case D:
                    droite = false;
                    break;
                default:
                    break;
            }
        });

        Scanner scanner = new Scanner(System.in);

/*
        String response = "";

        while(!response.equals("Q")){
            System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response){
                case ("P"): clip.start();
                break;
                case ("S"): clip.stop();
                break;
                case ("R"): clip.setMicrosecondPosition(0);
                break;
                default: System.out.println("Not a valid response");
            }
        }
*/

        primaryStage.show();


    }

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException{
        launch(args);
    }


}
