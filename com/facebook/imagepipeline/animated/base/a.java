package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes14.dex */
public interface a {
    AnimatedDrawableFrameInfo OT(int i);

    int PD(int i);

    void d(int i, Canvas canvas);

    int evM();

    int evN();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a m(Rect rect);
}
