package com.googlecode.mp4parser.h264.model;
/* loaded from: classes6.dex */
public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(255);
    private int value;

    private AspectRatio(int i) {
        this.value = i;
    }

    public static AspectRatio fromValue(int i) {
        return i == Extended_SAR.value ? Extended_SAR : new AspectRatio(i);
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AspectRatio{");
        sb.append("value=").append(this.value);
        sb.append('}');
        return sb.toString();
    }
}
