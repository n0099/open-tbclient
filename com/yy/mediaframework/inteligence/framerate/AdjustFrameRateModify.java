package com.yy.mediaframework.inteligence.framerate;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.utils.YMFLog;
import java.util.List;
/* loaded from: classes4.dex */
public class AdjustFrameRateModify implements IFrameRateModify {
    protected static final int FRAMERATE_FLOOR = 4;
    protected static final long ONE_SECOND = 1000000000;
    public static final String TAG = AdjustFrameRateModify.class.getSimpleName();
    protected int mConfigCodeRate;
    protected int mConfigFrameRate;
    protected ResolutionModifyConfig mCurrentConfig;
    protected int mIdx;
    protected long mLastTimestampNanos;
    protected List<ResolutionModifyConfig> mModifyConfigList;
    protected int mNetworkCodeRate;
    protected float mNewFrameRate = 0.0f;
    protected long mStepNanos;

    public void init(int i, int i2, int i3, int i4, List<ResolutionModifyConfig> list) throws ResolutionModifyNotFoundException {
        int i5 = 0;
        this.mConfigFrameRate = i;
        this.mConfigCodeRate = i2;
        this.mStepNanos = ONE_SECOND / this.mConfigFrameRate;
        this.mModifyConfigList = list;
        this.mIdx = findConfigIdx(i3, i4, i2);
        if (this.mIdx >= this.mModifyConfigList.size()) {
            this.mIdx = this.mModifyConfigList.size() - 1;
        }
        this.mCurrentConfig = findConfigFromIdx(this.mIdx);
        this.mLastTimestampNanos = -1L;
        YMFLog.info(this, "[Encoder ]", "init ConfigFrameRate:%d ConfigCodeRate:%d idx:%d", Integer.valueOf(this.mConfigFrameRate), Integer.valueOf(this.mConfigCodeRate), Integer.valueOf(this.mIdx));
        while (true) {
            int i6 = i5;
            if (i6 < this.mModifyConfigList.size()) {
                YMFLog.info(this, "[Encoder ]", "init config.part" + i6 + ":" + this.mModifyConfigList.get(i6).toString());
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public boolean onInterceptDoFrame(long j) {
        long nanoTime = this.mStepNanos - (System.nanoTime() - this.mLastTimestampNanos);
        if (this.mLastTimestampNanos != -1 && nanoTime > 0) {
            try {
                Thread.sleep(nanoTime / TimeUtils.NANOS_PER_MS);
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Encoder ]", "sleep exception:%s", e.toString());
            }
            this.mLastTimestampNanos = System.nanoTime();
        } else {
            this.mLastTimestampNanos = System.nanoTime();
        }
        return true;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishNetworkCodeRate(int i) {
        int i2;
        this.mNetworkCodeRate = i;
        if (this.mNetworkCodeRate < this.mCurrentConfig.minCodeRate) {
            i2 = this.mCurrentConfig.minCodeRate;
        } else if (this.mNetworkCodeRate > this.mCurrentConfig.maxCodeRate) {
            i2 = this.mCurrentConfig.maxCodeRate;
        } else {
            i2 = this.mNetworkCodeRate;
        }
        try {
            this.mNewFrameRate = (((float) ((i2 - this.mCurrentConfig.minCodeRate) / (this.mCurrentConfig.maxCodeRate - this.mCurrentConfig.minCodeRate))) * (this.mCurrentConfig.maxFrameRate - this.mCurrentConfig.minFrameRate)) + this.mCurrentConfig.minFrameRate;
        } catch (Exception e) {
            YMFLog.error(this, "[Encoder ]", "publishNetworkCodeRate exception:" + e.toString());
        }
        if (this.mNewFrameRate < 4.0f) {
            this.mNewFrameRate = 4.0f;
        }
        this.mStepNanos = 1.0E9f / this.mNewFrameRate;
        VideoDataStat.getInstance().setDynamicEncodeFrameRate(this.mNewFrameRate);
        YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate NewFrameRate:%f networkCodeRate:%d mStepNanos:%d", Float.valueOf(this.mNewFrameRate), Integer.valueOf(i), Long.valueOf(this.mStepNanos / TimeUtils.NANOS_PER_MS));
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentFrameRate(int i) {
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentResolution(int i, int i2, int i3) {
        ResolutionModifyConfig findConfigFromWH = findConfigFromWH(i, i2, i3);
        if (findConfigFromWH != null) {
            this.mCurrentConfig = findConfigFromWH;
        }
        YMFLog.info(this, "[Encoder ]", "publishCurrentResolution width:%d height:%d config:%s", Integer.valueOf(i), Integer.valueOf(i2), findConfigFromWH);
    }

    protected ResolutionModifyConfig findConfigFromIdx(int i) {
        return this.mModifyConfigList.get(i);
    }

    protected ResolutionModifyConfig findConfigFromWH(int i, int i2, int i3) {
        for (ResolutionModifyConfig resolutionModifyConfig : this.mModifyConfigList) {
            if (i == resolutionModifyConfig.width && i2 == resolutionModifyConfig.height && i3 >= resolutionModifyConfig.minCodeRate && i3 <= resolutionModifyConfig.maxCodeRate) {
                return resolutionModifyConfig;
            }
        }
        return null;
    }

    public int findConfigIdx(int i, int i2, int i3) throws ResolutionModifyNotFoundException {
        for (int i4 = 0; i4 < this.mModifyConfigList.size(); i4++) {
            ResolutionModifyConfig resolutionModifyConfig = this.mModifyConfigList.get(i4);
            if ((i4 == 0 && i3 <= resolutionModifyConfig.maxCodeRate) || ((i3 > resolutionModifyConfig.minCodeRate && i3 <= resolutionModifyConfig.maxCodeRate) || (i4 == this.mModifyConfigList.size() - 1 && i3 > resolutionModifyConfig.maxCodeRate))) {
                return i4;
            }
        }
        YMFLog.info(this, "[Encoder ]", "findConfigIdx fail, width:" + i + ", height:" + i2 + ", codeRate:" + i3);
        for (int i5 = 0; i5 < this.mModifyConfigList.size(); i5++) {
            YMFLog.info(this, "[Encoder ]", "findConfigIdx fail, config part" + i5 + ":" + this.mModifyConfigList.get(i5).toString());
        }
        throw new ResolutionModifyNotFoundException(i, i2, i3);
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void release() {
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public float getLastFrameRate() {
        return this.mNewFrameRate;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void setLastFrameRate(float f) {
        this.mNewFrameRate = f;
        this.mStepNanos = 1.0E9f / this.mNewFrameRate;
        YMFLog.info(this, "[Encoder ]", "setLastFrameRate NewFrameRate:%f  mStepNanos:%d", Float.valueOf(this.mNewFrameRate), Long.valueOf(this.mStepNanos / TimeUtils.NANOS_PER_MS));
    }
}
