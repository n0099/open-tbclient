package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes3.dex */
public interface a {
    AnimatedDrawableFrameInfo OO(int i);

    int Py(int i);

    void d(int i, Canvas canvas);

    int evv();

    int evw();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a m(Rect rect);
}
