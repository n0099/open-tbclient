package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public interface c {
    void dispose();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int i, int i2, Bitmap bitmap);
}
