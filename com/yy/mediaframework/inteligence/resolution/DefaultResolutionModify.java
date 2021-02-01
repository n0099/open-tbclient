package com.yy.mediaframework.inteligence.resolution;

import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.utils.YMFLog;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class DefaultResolutionModify implements IResolutionModify {
    protected static final long ONE_SECOND = 1000000000;
    public static final String TAG = DefaultResolutionModify.class.getSimpleName();
    protected int mConfigCodeRate;
    protected int mConfigFrameRate;
    protected int mCurrentFrameRate;
    protected int mIdx;
    protected long mLastTimestampNanos;
    protected List<ResolutionModifyConfig> mModifyConfigList;
    protected int mNetworkCodeRate;
    protected long mResolutionChangeInterval = 10000000000L;
    protected ResolutionModifyListener mResolutionModifyListener;

    public void init(int i, int i2, int i3, int i4, int i5, List<ResolutionModifyConfig> list, ResolutionModifyListener resolutionModifyListener) throws ResolutionModifyNotFoundException {
        this.mConfigFrameRate = i;
        this.mConfigCodeRate = i2;
        this.mCurrentFrameRate = 0;
        this.mModifyConfigList = list;
        this.mIdx = findConfigIdx(i3, i4, i2);
        this.mLastTimestampNanos = System.nanoTime();
        this.mResolutionModifyListener = resolutionModifyListener;
        this.mResolutionChangeInterval = i5 * ONE_SECOND;
        YMFLog.info(this, "[Encoder ]", "init cfr:%d ccr:%d idx:%d interval:%d config:%s", Integer.valueOf(this.mConfigFrameRate), Integer.valueOf(this.mConfigCodeRate), Integer.valueOf(this.mIdx), Long.valueOf(this.mResolutionChangeInterval), Arrays.toString(this.mModifyConfigList.toArray()));
    }

    @Override // com.yy.mediaframework.inteligence.resolution.IResolutionModify
    public void publishNetworkCodeRate(int i) {
        this.mNetworkCodeRate = i;
        if (this.mIdx >= this.mModifyConfigList.size()) {
            YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate index error, index:" + this.mIdx + ", size:" + this.mModifyConfigList.size());
            return;
        }
        ResolutionModifyConfig findConfigFromIdx = findConfigFromIdx(this.mIdx);
        YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate config min:" + findConfigFromIdx.minCodeRate + ", max:" + findConfigFromIdx.maxCodeRate + ", current:" + this.mNetworkCodeRate);
        if (this.mNetworkCodeRate < findConfigFromIdx.minCodeRate) {
            if (System.nanoTime() - this.mLastTimestampNanos > this.mResolutionChangeInterval) {
                int i2 = this.mIdx;
                this.mIdx = findBestConfigIdx(this.mNetworkCodeRate, false, this.mIdx);
                if (this.mIdx != i2) {
                    notifyToListener(this.mIdx, this.mNetworkCodeRate);
                    YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate config index change:" + i2 + " -> " + this.mIdx);
                }
            }
        } else if (this.mNetworkCodeRate > findConfigFromIdx.maxCodeRate && System.nanoTime() - this.mLastTimestampNanos > this.mResolutionChangeInterval) {
            int i3 = this.mIdx;
            this.mIdx = findBestConfigIdx(this.mNetworkCodeRate, true, this.mIdx);
            if (this.mIdx != i3) {
                notifyToListener(this.mIdx, this.mNetworkCodeRate);
                YMFLog.info(this, "[Encoder ]", "publishNetworkCodeRate config index change:" + i3 + " -> " + this.mIdx);
            }
        }
    }

    protected void notifyToListener(int i, int i2) {
        ResolutionModifyConfig findConfigFromIdx = findConfigFromIdx(i);
        if (findConfigFromIdx == null) {
            YMFLog.warn(this, "[Encoder ]", "cannot find config idx:%d", Integer.valueOf(i));
        } else {
            YMFLog.info(this, "[Encoder ]", "notify to modify resolution idx:" + i + " config:" + findConfigFromIdx.toString());
            if (this.mResolutionModifyListener != null) {
                this.mResolutionModifyListener.onReceiveSuggestResolution(findConfigFromIdx.width, findConfigFromIdx.height, findConfigFromIdx.maxFrameRate, findConfigFromIdx.encoderParams, findConfigFromIdx.videoEncoderType, findConfigFromIdx.videoEncoderType == VideoEncoderType.SOFT_ENCODER_X264 ? i2 : findConfigFromIdx.maxCodeRate);
            }
        }
        this.mLastTimestampNanos = System.nanoTime();
    }

    @Override // com.yy.mediaframework.inteligence.resolution.IResolutionModify
    public void publishCurrentFrameRate(int i) {
        this.mCurrentFrameRate = i;
    }

    protected int findBestConfigIdx(int i, boolean z, int i2) {
        if (z) {
            if (i2 >= this.mModifyConfigList.size() - 2) {
                return i2 == this.mModifyConfigList.size() + (-2) ? i2 + 1 : i2;
            }
            int i3 = i2 + 1;
            while (true) {
                int i4 = i3;
                if (i4 < this.mModifyConfigList.size()) {
                    if (i > this.mModifyConfigList.get(i4).maxCodeRate) {
                        i3 = i4 + 1;
                    } else {
                        return i4;
                    }
                } else {
                    return this.mModifyConfigList.size() - 1;
                }
            }
        } else if (i2 > 1) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                if (i >= this.mModifyConfigList.get(i5).minCodeRate) {
                    return i5;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

    protected ResolutionModifyConfig findConfigFromIdx(int i) {
        return this.mModifyConfigList.get(i);
    }

    protected int findConfigIdx(int i, int i2, int i3) throws ResolutionModifyNotFoundException {
        for (int i4 = 0; i4 < this.mModifyConfigList.size(); i4++) {
            ResolutionModifyConfig resolutionModifyConfig = this.mModifyConfigList.get(i4);
            if ((i4 == 0 && i3 <= resolutionModifyConfig.minCodeRate) || ((i3 > resolutionModifyConfig.minCodeRate && i3 <= resolutionModifyConfig.maxCodeRate) || (i4 == this.mModifyConfigList.size() - 1 && i3 > resolutionModifyConfig.maxCodeRate))) {
                return i4;
            }
        }
        YMFLog.info(this, "[Encoder ]", "findConfigIdx fail, width:" + i + ", height:" + i2 + ", codeRate:" + i3);
        for (int i5 = 0; i5 < this.mModifyConfigList.size(); i5++) {
            YMFLog.info(this, "[Encoder ]", "findConfigIdx fail, config part" + i5 + ":" + this.mModifyConfigList.get(i5).toString());
        }
        throw new ResolutionModifyNotFoundException(i, i2, i3);
    }

    @Override // com.yy.mediaframework.inteligence.resolution.IResolutionModify
    public void release() {
        this.mResolutionModifyListener = null;
    }

    public long getLastTimestampNanos() {
        return this.mLastTimestampNanos;
    }

    public void setLastTimestampNanos() {
        this.mLastTimestampNanos = System.nanoTime();
    }
}
