package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public interface AnimatedImageFrame {
    void dispose();

    int getDurationMs();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int i, int i2, Bitmap bitmap);
}
