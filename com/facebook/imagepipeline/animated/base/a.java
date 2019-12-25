package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
/* loaded from: classes11.dex */
public interface a {
    int HL(int i);

    AnimatedDrawableFrameInfo Hd(int i);

    int dlj();

    int dlk();

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getWidth();

    a k(Rect rect);

    void renderFrame(int i, Canvas canvas);
}
