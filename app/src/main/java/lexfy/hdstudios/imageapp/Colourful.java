package lexfy.hdstudios.imageapp;

import android.graphics.Bitmap;

public class Colourful {
    private Bitmap bitmap;
    private float redColorValue;
    private float greenColorValue;
    private float blueColorValue;

    public Colourful(Bitmap bitmap, float redColorValue, float greenColorValue, float blueColorValue) {
        this.bitmap = bitmap;
        this.redColorValue = redColorValue;
        this.greenColorValue = greenColorValue;
        this.blueColorValue = blueColorValue;
    }

    public void setRedColorValue(float redValue) {
        if (redValue >= 0 && redValue <= 1) {
            redColorValue = redValue;
        }
    }

    public void greenColorValue(float greenValue) {
        if (greenValue >= 0 && greenValue <= 1) {
            greenColorValue = greenValue;
        }
    }

    public void blueColorValue(float blueValue) {
        if (blueValue >= 0 && blueValue <= 1) {
            blueColorValue = blueValue;
        }
    }

    public float getRedColorValue() {
        return redColorValue;
    }

    public float getGreenColorValue() {
        return greenColorValue;
    }

    public float getBlueColorValue() {
        return blueColorValue;
    }

}
