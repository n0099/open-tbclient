package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes13.dex */
public interface a {
    int HZ(int i);

    AnimatedDrawableFrameInfo Hn(int i);

    int dnD();

    int dnE();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);

    void renderFrame(int i, Canvas canvas);
}
