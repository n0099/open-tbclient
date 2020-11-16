package com.facebook.rebound;
/* loaded from: classes9.dex */
public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    @Override // com.facebook.rebound.SpringLooper
    public void start() {
        this.mStarted = true;
        this.mLastTime = 0L;
    }

    public boolean step(long j) {
        if (this.mSpringSystem == null || !this.mStarted) {
            return false;
        }
        long j2 = this.mLastTime + j;
        this.mSpringSystem.loop(j2);
        this.mLastTime = j2;
        return this.mSpringSystem.getIsIdle();
    }

    @Override // com.facebook.rebound.SpringLooper
    public void stop() {
        this.mStarted = false;
    }
}
