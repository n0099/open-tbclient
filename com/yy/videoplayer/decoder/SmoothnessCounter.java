package com.yy.videoplayer.decoder;
/* loaded from: classes6.dex */
public class SmoothnessCounter {
    private long mIntervalMilliTs;
    private long mPreviousRenderMilliTs = 0;
    private long mFirstRenderMilliTs = 0;
    private int mFrameCount = 0;
    private int mDifSum = 0;
    private int mDifSquaredSum = 0;

    public SmoothnessCounter(long j) {
        this.mIntervalMilliTs = 20000L;
        this.mIntervalMilliTs = j;
    }

    public boolean RenderOneFrame(long j, long j2) {
        if (this.mFirstRenderMilliTs == 0) {
            this.mPreviousRenderMilliTs = j2;
            this.mFirstRenderMilliTs = j2;
        } else {
            this.mFrameCount++;
            long j3 = j2 - this.mPreviousRenderMilliTs;
            this.mDifSum = (int) (this.mDifSum + j3);
            this.mDifSquaredSum = (int) ((j3 * j3) + this.mDifSquaredSum);
            this.mPreviousRenderMilliTs = j2;
            if (j2 - this.mFirstRenderMilliTs > this.mIntervalMilliTs) {
                return true;
            }
        }
        return false;
    }

    public void ResetToInitialState() {
        this.mPreviousRenderMilliTs = 0L;
        this.mFirstRenderMilliTs = 0L;
        this.mFrameCount = 0;
        this.mDifSum = 0;
        this.mDifSquaredSum = 0;
    }

    public double ComputeCoefficientOfVariationAndReset() {
        double d = (this.mDifSum * 1.0d) / this.mFrameCount;
        double sqrt = Math.sqrt((((this.mDifSquaredSum + (((this.mFrameCount * 1.0d) * d) * d)) - ((2.0d * this.mDifSum) * d)) * 1.0d) / this.mFrameCount) / d;
        ResetToInitialState();
        return sqrt;
    }

    public long GetIntervalMilliTs() {
        return this.mIntervalMilliTs;
    }
}
