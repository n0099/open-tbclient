package com.kwai.player.vr;
/* loaded from: classes6.dex */
public class FpsStatistic {
    public static final int FPS_CALCULATE_TIME_MS = 1000;
    public volatile boolean mFpsStar;
    public volatile long mFpsStartTimeMs;
    public volatile int mFpsCounter = 0;
    public volatile int mFps = -1;

    private void resetFpsTimeAndCounter() {
        this.mFpsStartTimeMs = 0L;
        this.mFpsCounter = 0;
    }

    public int getFps() {
        return this.mFps;
    }

    public void onFrame() {
        if (this.mFpsStar) {
            if (this.mFpsStartTimeMs <= 0) {
                this.mFpsStartTimeMs = System.currentTimeMillis();
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mFpsStartTimeMs);
            if (this.mFpsStartTimeMs <= 0 || currentTimeMillis <= 0) {
                return;
            }
            this.mFpsCounter++;
            if (currentTimeMillis <= 1000) {
                return;
            }
            this.mFps = this.mFpsCounter;
        }
        resetFpsTimeAndCounter();
    }

    public void resetFps() {
        this.mFps = -1;
        resetFpsTimeAndCounter();
    }

    public void startFps() {
        this.mFpsStar = true;
    }

    public void stopFps() {
        this.mFpsStar = false;
        resetFpsTimeAndCounter();
    }
}
