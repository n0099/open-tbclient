package com.googlecode.mp4parser.h264.model;
/* loaded from: classes8.dex */
public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(255);
    public int value;

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "AspectRatio{value=" + this.value + '}';
    }

    public AspectRatio(int i) {
        this.value = i;
    }

    public static AspectRatio fromValue(int i) {
        AspectRatio aspectRatio = Extended_SAR;
        if (i == aspectRatio.value) {
            return aspectRatio;
        }
        return new AspectRatio(i);
    }
}
