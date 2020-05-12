package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes13.dex */
public interface a {
    AnimatedDrawableFrameInfo FU(int i);

    int GG(int i);

    void c(int i, Canvas canvas);

    int dpY();

    int dpZ();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);
}
