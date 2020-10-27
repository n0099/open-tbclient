package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes12.dex */
public interface a {
    AnimatedDrawableFrameInfo NQ(int i);

    int OC(int i);

    void c(int i, Canvas canvas);

    int ejm();

    int ejn();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a l(Rect rect);
}
