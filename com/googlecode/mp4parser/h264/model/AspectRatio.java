package com.googlecode.mp4parser.h264.model;
/* loaded from: classes6.dex */
public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(255);
    public int value;

    public AspectRatio(int i2) {
        this.value = i2;
    }

    public static AspectRatio fromValue(int i2) {
        AspectRatio aspectRatio = Extended_SAR;
        return i2 == aspectRatio.value ? aspectRatio : new AspectRatio(i2);
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "AspectRatio{value=" + this.value + '}';
    }
}
