package com.googlecode.mp4parser.h264.model;

import android.support.v4.view.MotionEventCompat;
/* loaded from: classes2.dex */
public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(MotionEventCompat.ACTION_MASK);
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
