package com.tb.airbnb.lottie.e;
/* loaded from: classes7.dex */
public class d {
    private final float scaleX;
    private final float scaleY;

    public d(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
