package com.tb.airbnb.lottie.e;
/* loaded from: classes20.dex */
public class d {
    private final float Ir;
    private final float Is;

    public d(float f, float f2) {
        this.Ir = f;
        this.Is = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.Ir;
    }

    public float getScaleY() {
        return this.Is;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
