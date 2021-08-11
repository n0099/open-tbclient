package com.facebook.fresco.animation.frame;
/* loaded from: classes9.dex */
public interface FrameScheduler {
    public static final int FRAME_NUMBER_DONE = -1;
    public static final int NO_NEXT_TARGET_RENDER_TIME = -1;

    int getFrameNumberToRender(long j2, long j3);

    long getLoopDurationMs();

    long getTargetRenderTimeForNextFrameMs(long j2);

    long getTargetRenderTimeMs(int i2);

    boolean isInfiniteAnimation();
}
