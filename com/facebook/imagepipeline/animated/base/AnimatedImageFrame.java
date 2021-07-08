package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public interface AnimatedImageFrame {
    void dispose();

    int getDurationMs();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int i2, int i3, Bitmap bitmap);
}
