package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes13.dex */
public interface a {
    AnimatedDrawableFrameInfo Ht(int i);

    int If(int i);

    int dod();

    int doe();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);

    void renderFrame(int i, Canvas canvas);
}
