package com.yy.mediaframework.model;

import java.util.Locale;
/* loaded from: classes6.dex */
public class Rect {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public Rect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public void update(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Rect::left: %f, right %f, top %f, bottom %f", Float.valueOf(this.left), Float.valueOf(this.top), Float.valueOf(this.right), Float.valueOf(this.bottom));
    }

    public boolean valueEquals(Rect rect) {
        return rect != null && this.left == rect.left && this.bottom == rect.bottom && this.right == rect.right && this.top == rect.top;
    }
}
