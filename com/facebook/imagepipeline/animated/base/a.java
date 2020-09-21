package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes6.dex */
public interface a {
    AnimatedDrawableFrameInfo Lt(int i);

    int Mf(int i);

    void c(int i, Canvas canvas);

    int dVD();

    int dVE();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);
}
