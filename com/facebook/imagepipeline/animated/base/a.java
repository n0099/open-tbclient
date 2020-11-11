package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes12.dex */
public interface a {
    int OX(int i);

    AnimatedDrawableFrameInfo Ol(int i);

    void c(int i, Canvas canvas);

    int enb();

    int enc();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a m(Rect rect);
}
