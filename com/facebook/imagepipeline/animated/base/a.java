package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes12.dex */
public interface a {
    int IW(int i);

    AnimatedDrawableFrameInfo Ik(int i);

    void c(int i, Canvas canvas);

    int dFx();

    int dFy();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);
}
