package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes3.dex */
public interface a {
    AnimatedDrawableFrameInfo OP(int i);

    int Pz(int i);

    void d(int i, Canvas canvas);

    int evD();

    int evE();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a m(Rect rect);
}
