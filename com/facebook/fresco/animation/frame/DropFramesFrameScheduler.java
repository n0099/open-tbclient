package com.facebook.fresco.animation.frame;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.fresco.animation.backend.AnimationInformation;
/* loaded from: classes6.dex */
public class DropFramesFrameScheduler implements FrameScheduler {
    public static final int UNSET = -1;
    public final AnimationInformation mAnimationInformation;
    public long mLoopDurationMs = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.mAnimationInformation = animationInformation;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        if (isInfiniteAnimation() || j / getLoopDurationMs() < this.mAnimationInformation.getLoopCount()) {
            return getFrameNumberWithinLoop(j % getLoopDurationMs());
        }
        return -1;
    }

    @VisibleForTesting
    public int getFrameNumberWithinLoop(long j) {
        int i2 = 0;
        long j2 = 0;
        do {
            j2 += this.mAnimationInformation.getFrameDurationMs(i2);
            i2++;
        } while (j >= j2);
        return i2 - 1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long j = this.mLoopDurationMs;
        if (j != -1) {
            return j;
        }
        this.mLoopDurationMs = 0L;
        int frameCount = this.mAnimationInformation.getFrameCount();
        for (int i2 = 0; i2 < frameCount; i2++) {
            this.mLoopDurationMs += this.mAnimationInformation.getFrameDurationMs(i2);
        }
        return this.mLoopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        long loopDurationMs = getLoopDurationMs();
        long j2 = 0;
        if (loopDurationMs == 0) {
            return -1L;
        }
        if (isInfiniteAnimation() || j / getLoopDurationMs() < this.mAnimationInformation.getLoopCount()) {
            long j3 = j % loopDurationMs;
            int frameCount = this.mAnimationInformation.getFrameCount();
            for (int i2 = 0; i2 < frameCount && j2 <= j3; i2++) {
                j2 += this.mAnimationInformation.getFrameDurationMs(i2);
            }
            return j + (j2 - j3);
        }
        return -1L;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i2) {
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j += this.mAnimationInformation.getFrameDurationMs(i2);
        }
        return j;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        return this.mAnimationInformation.getLoopCount() == 0;
    }
}
