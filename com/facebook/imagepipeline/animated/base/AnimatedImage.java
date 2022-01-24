package com.facebook.imagepipeline.animated.base;
/* loaded from: classes3.dex */
public interface AnimatedImage {
    public static final int LOOP_COUNT_INFINITE = 0;

    void dispose();

    boolean doesRenderSupportScaling();

    int getDuration();

    AnimatedImageFrame getFrame(int i2);

    int getFrameCount();

    int[] getFrameDurations();

    AnimatedDrawableFrameInfo getFrameInfo(int i2);

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
