package com.facebook.fresco.animation.backend;
/* loaded from: classes7.dex */
public interface AnimationInformation {
    public static final int LOOP_COUNT_INFINITE = 0;

    int getFrameCount();

    int getFrameDurationMs(int i2);

    int getLoopCount();
}
