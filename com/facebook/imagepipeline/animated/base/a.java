package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes13.dex */
public interface a {
    AnimatedDrawableFrameInfo GI(int i);

    int Hu(int i);

    void c(int i, Canvas canvas);

    int dxE();

    int dxF();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);
}
