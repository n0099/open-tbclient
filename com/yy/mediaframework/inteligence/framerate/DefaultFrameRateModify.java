package com.yy.mediaframework.inteligence.framerate;

import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class DefaultFrameRateModify implements IFrameRateModify {
    protected static final int FRAMERATE_FLOOR = 10;
    protected static final long ONE_SECOND = 1000000000;
    public static final String TAG = DefaultFrameRateModify.class.getSimpleName();
    private int mConfigCodeRate;
    private int mConfigFrameRate;
    private int mCurrentFrameRate;
    private int mDropCount;
    private int mDropThreshold;
    private long mLastSecondNanos;
    private long mLastTimestampNanos;
    private int mMinCodeRate;
    private boolean mNeedIntercept = false;
    private int mNetworkCodeRate;
    private float mNewFrameRate;
    private float mReduceFrameWeight;
    private long mStepNanos;

    public void init(int i, int i2, int i3, float f) {
        this.mConfigFrameRate = i;
        this.mConfigCodeRate = i2;
        this.mMinCodeRate = i3;
        this.mReduceFrameWeight = f;
        this.mStepNanos = ONE_SECOND / this.mConfigFrameRate;
        this.mDropThreshold = 0;
        this.mNetworkCodeRate = i2;
        this.mCurrentFrameRate = 0;
        YMFLog.info(this, "[Encoder ]", "init cfr:%d ccr:%d mcr:%d rfw:%f", Integer.valueOf(this.mConfigFrameRate), Integer.valueOf(this.mConfigCodeRate), Integer.valueOf(this.mMinCodeRate), Float.valueOf(this.mReduceFrameWeight));
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public boolean onInterceptDoFrame(long j) {
        if (this.mNeedIntercept) {
            if (this.mLastTimestampNanos != -1 && j - this.mLastTimestampNanos < this.mStepNanos && this.mDropCount <= this.mDropThreshold) {
                this.mDropCount++;
                return true;
            }
            if (j - this.mLastSecondNanos > ONE_SECOND) {
                YMFLog.debug(this, "[Encoder ]", "mDropCount:%d", Integer.valueOf(this.mDropCount));
                this.mDropCount = 0;
                this.mLastSecondNanos = j;
            }
            this.mLastTimestampNanos = j;
            return false;
        }
        return false;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishNetworkCodeRate(int i) {
        this.mNetworkCodeRate = i;
        if (this.mNetworkCodeRate < this.mMinCodeRate && this.mCurrentFrameRate != 0) {
            this.mNeedIntercept = true;
            this.mNewFrameRate = (this.mCurrentFrameRate + this.mDropThreshold) * this.mReduceFrameWeight;
            if (this.mNewFrameRate < 10.0f) {
                this.mNewFrameRate = 10.0f;
            }
            this.mStepNanos = 1.0E9f / this.mNewFrameRate;
            YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate nfr:%f ncr:%d sn:%d", Float.valueOf(this.mNewFrameRate), Integer.valueOf(i), Long.valueOf(this.mStepNanos));
            return;
        }
        this.mNeedIntercept = false;
        this.mDropThreshold = 0;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentFrameRate(int i) {
        this.mCurrentFrameRate = i;
        if (this.mNeedIntercept) {
            int i2 = (int) this.mNewFrameRate;
            if (this.mCurrentFrameRate > i2) {
                this.mDropThreshold++;
            } else if (this.mCurrentFrameRate != i2) {
                this.mDropThreshold--;
            }
            YMFLog.info(this, "[Encoder ]", "publishCurrentFrameRate currentFrameRate:%d mDropThreshold:%d", Integer.valueOf(i), Integer.valueOf(this.mDropThreshold));
        }
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentResolution(int i, int i2, int i3) {
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void release() {
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public float getLastFrameRate() {
        return 0.0f;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void setLastFrameRate(float f) {
    }
}
