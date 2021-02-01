package com.yy.mediaframework.inteligence.framerate;

import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class CaptureSyncEncodeFrameRateModify implements IFrameRateModify {
    private int mModifiedEncFps;
    private boolean mEnableSyncFps = true;
    private int mSampleEncFpsDiff = 3;
    private int mSyncFpsInterval = 15;
    private int mFrameCount = 0;
    private long mLastCountTime = 0;
    private long mNewTurnTime = 0;
    private long mStatInterval = 5;
    private List<Integer> mLastFps = new ArrayList();
    private String mConfigStr = null;
    private int mLastBitRateSuggest = 0;
    private int mCurrentBitRateSuggest = 0;
    public AdjustFrameRateModify mAjustFRModify = null;

    public CaptureSyncEncodeFrameRateModify() {
        this.mModifiedEncFps = 0;
        this.mModifiedEncFps = 0;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public boolean onInterceptDoFrame(long j) {
        if (this.mAjustFRModify != null) {
            return this.mAjustFRModify.onInterceptDoFrame(j);
        }
        return true;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishNetworkCodeRate(int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i + ", last:" + this.mLastBitRateSuggest + " enableSyncFps:" + this.mEnableSyncFps);
        this.mCurrentBitRateSuggest = i;
        if (this.mAjustFRModify != null) {
            this.mAjustFRModify.publishNetworkCodeRate(i);
        }
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentFrameRate(int i) {
        if (this.mAjustFRModify != null) {
            this.mAjustFRModify.publishCurrentFrameRate(i);
        }
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void publishCurrentResolution(int i, int i2, int i3) {
        if (this.mAjustFRModify != null) {
            this.mAjustFRModify.publishCurrentResolution(i, i2, i3);
        }
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void release() {
        if (this.mAjustFRModify != null) {
            this.mAjustFRModify.release();
        }
    }

    public void reInit(int i, int i2, int i3, int i4, List<ResolutionModifyConfig> list) {
        YMFLog.info(this, "[Encoder ]", "reInit");
        this.mLastCountTime = 0L;
        this.mFrameCount = 0;
        this.mNewTurnTime = 0L;
        this.mModifiedEncFps = 0;
        release();
        init(i, i2, i3, i4, list);
    }

    public void init(int i, int i2, int i3, int i4, List<ResolutionModifyConfig> list) {
        YMFLog.info(this, "[Encoder ]", "init FrameRateModify frameRate:" + i + ", codeRate:" + i2 + ", width:" + i3 + ", heigh:" + i4 + "config:" + Arrays.toString(list.toArray()));
        try {
            this.mAjustFRModify = new AdjustFrameRateModify();
            this.mAjustFRModify.init(i, i2, i3, i4, list);
        } catch (ResolutionModifyNotFoundException e) {
            YMFLog.error(this, "[Encoder ]", "init FrameRateModify exception:%s", e.toString());
            this.mAjustFRModify = null;
        }
    }

    public int checkFrameRate(int i, String str, VideoEncoderType videoEncoderType) {
        updateSyncFpsParam(str);
        if (this.mEnableSyncFps) {
            if (videoEncoderType == VideoEncoderType.HARD_ENCODER_H264 || videoEncoderType == VideoEncoderType.HARD_ENCODER_H265) {
                return checkSyncFps(i);
            }
            return i;
        }
        return i;
    }

    private void updateSyncFpsParam(String str) {
        if (str != null) {
            if (this.mConfigStr == null || !this.mConfigStr.equals(str)) {
                try {
                    String[] split = str.split(":");
                    for (int i = 0; i < split.length; i++) {
                        YMFLog.info(this, "[Encoder ]", "updateSyncFpsParam parse:" + split[i]);
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2) {
                            YMFLog.info(this, "[Encoder ]", "updateSyncFpsParam param item, name:" + split2[0] + ", value:" + split2[1]);
                            setSyncSampleEncParams(split2[0], split2[1]);
                        } else {
                            YMFLog.info(this, "[Encoder ]", "updateSyncFpsParam invalid param item:" + Arrays.toString(split2));
                        }
                    }
                    this.mConfigStr = str;
                } catch (Exception e) {
                    YMFLog.info(this, "[Encoder ]", "updateSyncFpsParam parse exception:" + e);
                }
            }
        }
    }

    private void setSyncSampleEncParams(String str, String str2) {
        char c = 65535;
        switch (str.hashCode()) {
            case -649105266:
                if (str.equals("fpsDiff")) {
                    c = 0;
                    break;
                }
                break;
            case -623052469:
                if (str.equals("enableSyncFps")) {
                    c = 2;
                    break;
                }
                break;
            case -324580557:
                if (str.equals("syncFpsInterval")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mSampleEncFpsDiff = Integer.parseInt(str2);
                YMFLog.info(this, "[Encoder ]", "setSyncSampleEncParams fpsDiff:" + this.mSampleEncFpsDiff);
                return;
            case 1:
                this.mSyncFpsInterval = Integer.parseInt(str2);
                YMFLog.info(this, "[Encoder ]", "setSyncSampleEncParams syncFpsInterval:" + this.mSyncFpsInterval);
                return;
            case 2:
                this.mEnableSyncFps = Boolean.parseBoolean(str2);
                YMFLog.info(this, "[Encoder ]", "setSyncSampleEncParams enableSyncFps:" + this.mEnableSyncFps);
                return;
            default:
                return;
        }
    }

    private int checkSyncFps(int i) {
        this.mFrameCount++;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mNewTurnTime == 0) {
            this.mNewTurnTime = currentTimeMillis;
            this.mLastCountTime = currentTimeMillis;
            this.mLastFps.clear();
            return i;
        }
        long j = currentTimeMillis - this.mLastCountTime;
        if (j >= this.mStatInterval * 1000) {
            this.mLastFps.add(Integer.valueOf((int) (this.mFrameCount / (((float) j) / 1000.0f))));
            if (this.mLastFps.size() > 100) {
                this.mLastFps.remove(0);
            }
            this.mLastCountTime = currentTimeMillis;
            this.mFrameCount = 0;
        }
        if (currentTimeMillis - this.mNewTurnTime >= this.mSyncFpsInterval * 1000) {
            if (this.mFrameCount != 0 && j > 0) {
                this.mLastFps.add(Integer.valueOf((int) (this.mFrameCount / (((float) j) / 1000.0f))));
            }
            if (this.mAjustFRModify != null && this.mCurrentBitRateSuggest > 0) {
                this.mAjustFRModify.publishNetworkCodeRate(this.mCurrentBitRateSuggest);
                YMFLog.info(this, "[Encoder ]", "update suggest bitrate, last:" + this.mLastBitRateSuggest + ", now:" + this.mCurrentBitRateSuggest);
            }
            this.mLastBitRateSuggest = this.mCurrentBitRateSuggest;
            this.mNewTurnTime = currentTimeMillis;
            if (!this.mLastFps.isEmpty()) {
                int size = this.mLastFps.size();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i2 < size) {
                    int intValue = this.mLastFps.get(i2).intValue();
                    int i6 = (i2 <= 0 || Math.abs(intValue - i4) <= 3) ? i3 : i3 + 1;
                    i5 += intValue;
                    i2++;
                    i3 = i6;
                    i4 = intValue;
                }
                int i7 = i5 / size;
                if (i3 <= size / 2 && i7 > 7 && (i7 < i - this.mSampleEncFpsDiff || i7 > this.mSampleEncFpsDiff + i)) {
                    YMFLog.info(this, "[Encoder ]", "sample len:" + size + ", vibratCount:" + i3 + ", sync camera fps:" + i7 + ", old enc fps:" + i + ", suggest fps:" + ((this.mAjustFRModify == null || !(this.mAjustFRModify instanceof AdjustFrameRateModify)) ? 0 : (int) this.mAjustFRModify.getLastFrameRate()));
                    int i8 = this.mModifiedEncFps;
                    this.mModifiedEncFps = i7;
                    if (this.mModifiedEncFps != i8) {
                        this.mLastCountTime = 0L;
                        this.mFrameCount = 0;
                        this.mNewTurnTime = 0L;
                        return this.mModifiedEncFps;
                    }
                } else {
                    YMFLog.info(this, "[Encoder ]", "sample len:" + size + ", vibratCount:" + i3 + ", camera fps:" + i7 + ", enc fps:" + i);
                }
                this.mLastFps.clear();
                return i;
            }
            return i;
        }
        return i;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public float getLastFrameRate() {
        if (this.mAjustFRModify != null) {
            return this.mAjustFRModify.getLastFrameRate();
        }
        return 0.0f;
    }

    @Override // com.yy.mediaframework.inteligence.framerate.IFrameRateModify
    public void setLastFrameRate(float f) {
        if (this.mAjustFRModify != null) {
            this.mAjustFRModify.setLastFrameRate(f);
        }
    }
}
