package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes3.dex */
public interface a {
    AnimatedDrawableFrameInfo KO(int i);

    int LA(int i);

    void c(int i, Canvas canvas);

    int dRw();

    int dRx();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);
}
