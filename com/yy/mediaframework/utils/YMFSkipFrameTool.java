package com.yy.mediaframework.utils;
/* loaded from: classes4.dex */
public class YMFSkipFrameTool {
    private int mFrameRate;
    private long mLastFramePts = 0;
    private long targetFrameDuration;

    public YMFSkipFrameTool(int i) {
        updateTargetFrameRate(i);
    }

    public void updateTargetFrameRate(int i) {
        this.mFrameRate = i;
        this.targetFrameDuration = 1000 / i;
    }

    public int getTargetFrameRate() {
        return this.mFrameRate;
    }

    public boolean skipCurrentFrame(long j) {
        boolean z = false;
        if (this.mLastFramePts != 0 && j - this.mLastFramePts < this.targetFrameDuration) {
            z = true;
        }
        if (this.mLastFramePts == 0) {
            this.mLastFramePts = TimeUtil.getTickCountLong();
        } else if (!z) {
            this.mLastFramePts += this.targetFrameDuration;
        }
        return z;
    }
}
