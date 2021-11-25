package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThings{
    protected int x;
    protected int y;

    public ImageView getImageSheet() {
        return imageSheet;
    }

    protected ImageView imageSheet;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public staticThings(Integer x, Integer y, String imageCd) {
        this.x = x;
        this.y = y;
        Image spriteSheet = new Image(imageCd);
        this.imageSheet = new ImageView(spriteSheet);
        this.imageSheet.setX(x);
        this.imageSheet.setY(y);
    }


}
