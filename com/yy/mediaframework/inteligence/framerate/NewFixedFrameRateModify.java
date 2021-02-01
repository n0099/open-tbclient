package com.yy.mediaframework.inteligence.framerate;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class NewFixedFrameRateModify implements IFrameRateModify {
    protected static final int FRAMERATE_FLOOR = 10;
    protected static final long ONE_SECOND = 1000000000;
    public static final String TAG = NewFixedFrameRateModify.class.getSimpleName();
    private int mConfigCodeRate;
    private int mConfigFrameRate;
    private int mCurrentFrameRate;
    private int mFixedFrameRate;
    private long mLastTimestampNanos;
    private boolean mNeedIntercept = true;
    private float mNewFrameRate;
    private long mStepNanos;

    public void init(int i, int i2, int i3) {
        this.mConfigFrameRate = i;
        this.mConfigCodeRate = i2;
        this.mStepNanos = ONE_SECOND / this.mConfigFrameRate;
        this.mCurrentFrameRate = 0;
        this.mFixedFrameRate = i3;
        YMFLog.info(this, "[Encoder ]", "init cfr:%d ccr:%d ffr:%d", Integer.valueOf(this.mConfigFrameRate), Integer.valueOf(this.mConfigCodeRate), Integer.valueOf(this.mFixedFrameRate));
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public boolean onInterceptDoFrame(long j) {
        if (this.mNeedIntercept) {
            long nanoTime = this.mStepNanos - (System.nanoTime() - this.mLastTimestampNanos);
            if (this.mLastTimestampNanos != -1 && nanoTime > 0) {
                try {
                    Thread.sleep(nanoTime / TimeUtils.NANOS_PER_MS);
                } catch (InterruptedException e) {
                    YMFLog.error(this, "[Encoder ]", "sleep exception:%s", e);
                }
                this.mLastTimestampNanos = System.nanoTime();
                return true;
            }
            this.mLastTimestampNanos = System.nanoTime();
            return true;
        }
        return false;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishNetworkCodeRate(int i) {
        this.mNewFrameRate = this.mFixedFrameRate;
        if (this.mNewFrameRate < 10.0f) {
            this.mNewFrameRate = 10.0f;
        }
        this.mStepNanos = 1.0E9f / this.mNewFrameRate;
        YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate nfr:%f ncr:%d sn:%d", Float.valueOf(this.mNewFrameRate), Integer.valueOf(i), Long.valueOf(this.mStepNanos));
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentFrameRate(int i) {
        this.mCurrentFrameRate = i;
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
