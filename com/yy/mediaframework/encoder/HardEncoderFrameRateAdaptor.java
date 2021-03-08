package com.yy.mediaframework.encoder;

import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class HardEncoderFrameRateAdaptor {
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

    public HardEncoderFrameRateAdaptor() {
        this.mModifiedEncFps = 0;
        this.mModifiedEncFps = 0;
    }

    public boolean checkFrameRate(VideoEncoderConfig videoEncoderConfig) {
        updateSyncFpsParam(videoEncoderConfig.mEncodeParameter);
        if (this.mEnableSyncFps && (videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264 || videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H265)) {
            return checkSyncFps(videoEncoderConfig);
        }
        return false;
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

    private boolean checkSyncFps(VideoEncoderConfig videoEncoderConfig) {
        this.mFrameCount++;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mNewTurnTime == 0) {
            this.mNewTurnTime = currentTimeMillis;
            this.mLastCountTime = currentTimeMillis;
            this.mLastFps.clear();
            return false;
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
        if (currentTimeMillis - this.mNewTurnTime < this.mSyncFpsInterval * 1000) {
            return false;
        }
        if (this.mFrameCount != 0 && j > 0) {
            this.mLastFps.add(Integer.valueOf((int) (this.mFrameCount / (((float) j) / 1000.0f))));
        }
        this.mNewTurnTime = currentTimeMillis;
        if (this.mLastFps.isEmpty()) {
            return false;
        }
        int size = this.mLastFps.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            int intValue = this.mLastFps.get(i).intValue();
            int i5 = (i <= 0 || Math.abs(intValue - i3) <= 3) ? i2 : i2 + 1;
            i4 += intValue;
            i++;
            i2 = i5;
            i3 = intValue;
        }
        int i6 = i4 / size;
        int i7 = videoEncoderConfig.mFrameRate;
        if (i2 <= size / 2 && i6 > 7 && (i6 < i7 - this.mSampleEncFpsDiff || i6 > this.mSampleEncFpsDiff + i7)) {
            YMFLog.info(this, "[Encoder ]", "checkSyncFps, sample len:" + size + ", vibratCount:" + i2 + ", sync camera fps:" + i6 + ", old enc fps:" + i7);
            this.mModifiedEncFps = i6;
            videoEncoderConfig.mFrameRate = this.mModifiedEncFps;
            this.mLastCountTime = 0L;
            this.mFrameCount = 0;
            this.mNewTurnTime = 0L;
            return true;
        }
        YMFLog.info(this, "[Encoder ]", "checkSyncFps, sample len:" + size + ", vibratCount:" + i2 + ", camera fps:" + i6 + ", enc fps:" + i7);
        this.mLastFps.clear();
        return false;
    }
}
