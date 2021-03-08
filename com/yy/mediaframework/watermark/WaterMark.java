package com.yy.mediaframework.watermark;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public class WaterMark {
    public Align align;
    public Bitmap bitmap;
    public int height;
    public int offsetX;
    public int offsetY;
    public int width;

    /* loaded from: classes6.dex */
    public enum Align {
        LeftTop,
        RightTop,
        LeftBottom,
        RightBottom
    }

    public WaterMark(Bitmap bitmap, int i, int i2, int i3, int i4, Align align) {
        this.bitmap = bitmap;
        this.width = i;
        this.height = i2;
        this.offsetX = i3;
        this.offsetY = i4;
        this.align = align;
    }
}
