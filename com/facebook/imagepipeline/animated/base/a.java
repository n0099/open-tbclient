package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes12.dex */
public interface a {
    int HU(int i);

    AnimatedDrawableFrameInfo Hi(int i);

    int dmo();

    int dmp();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);

    void renderFrame(int i, Canvas canvas);
}
