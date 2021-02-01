package com.yy.mediaframework.base;

import com.yy.mediaframework.stat.VideoDataStatUtil;
/* loaded from: classes4.dex */
public class VideoEncoderConfig {
    public static final int DEFAULT_ENCODE_HIGH_BITRATE = 1200000;
    public static final int DEFAULT_ENCODE_HIGH_FRAMERATE = 24;
    public static final int DEFAULT_ENCODE_HIGH_HEIGHT = 960;
    public static final int DEFAULT_ENCODE_HIGH_WIDTH = 544;
    public static final int DEFAULT_ENCODE_LOW_BITRATE = 1200000;
    public static final int DEFAULT_ENCODE_LOW_FRAMERATE = 24;
    public static final int DEFAULT_ENCODE_LOW_HEIGHT = 640;
    public static final int DEFAULT_ENCODE_LOW_WIDTH = 368;
    public static final boolean DEFAULT_ENCODE_STABILIZATION = true;
    public static final int SCREEN_RECORD_ENCODE_HIGH_BITRATE = 1200000;
    public static final int SCREEN_RECORD_ENCODE_HIGH_FRAMERATE = 30;
    public static final int SCREEN_RECORD_ENCODE_HIGH_HEIGHT = 864;
    public static final int SCREEN_RECORD_ENCODE_HIGH_WIDTH = 480;
    public static final int SCREEN_RECORD_ENCODE_LOW_BITRATE = 800000;
    public static final int SCREEN_RECORD_ENCODE_LOW_FRAMERATE = 30;
    public static final int SCREEN_RECORD_ENCODE_LOW_HEIGHT = 640;
    public static final int SCREEN_RECORD_ENCODE_LOW_WIDTH = 368;
    public static final int SCREEN_RECORD_ENCODE_ULTRA_HIGH_BITRATE = 2000000;
    public static final int SCREEN_RECORD_ENCODE_ULTRA_HIGH_FRAMERATE = 30;
    public static final int SCREEN_RECORD_ENCODE_ULTRA_HIGH_HEIGHT = 1280;
    public static final int SCREEN_RECORD_ENCODE_ULTRA_HIGH_WIDTH = 720;
    public int mBitRate;
    public int mEncodeHeight;
    public String mEncodeParameter;
    public VideoEncoderType mEncodeType;
    public int mEncodeWidth;
    public int mFrameRate;
    public boolean mLowDelay;
    public int mMaxBitRate;
    public boolean videoStabilization;

    public VideoEncoderConfig() {
        this(DEFAULT_ENCODE_HIGH_WIDTH, 960, 24, 1200000, VideoEncoderType.HARD_ENCODER_H264, null);
    }

    public VideoEncoderConfig(int i, int i2, int i3, int i4, VideoEncoderType videoEncoderType, String str) {
        this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
        this.mEncodeParameter = null;
        this.mLowDelay = false;
        setEncodeSize(i, i2);
        this.mFrameRate = i3;
        this.mBitRate = i4;
        this.mEncodeType = videoEncoderType;
        this.mEncodeParameter = str;
        this.videoStabilization = true;
    }

    public VideoEncoderConfig(VideoEncoderConfig videoEncoderConfig) {
        this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
        this.mEncodeParameter = null;
        this.mLowDelay = false;
        assign(videoEncoderConfig);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mEncodeWidth:").append(getEncodeWidth());
        sb.append(" mEncodeHeith:").append(getEncodeHeight());
        sb.append(" mFrameRate:").append(this.mFrameRate);
        sb.append(" mBitRate:").append(this.mBitRate);
        sb.append(" mEncodeType:").append(this.mEncodeType);
        sb.append(" mLowDelay:").append(this.mLowDelay);
        if (this.mEncodeParameter != null) {
            sb.append(" mEncodeParameter:").append(this.mEncodeParameter);
        }
        return sb.toString();
    }

    public void assign(VideoEncoderConfig videoEncoderConfig) {
        setEncodeSize(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
        this.mFrameRate = videoEncoderConfig.mFrameRate;
        this.videoStabilization = videoEncoderConfig.videoStabilization;
        this.mEncodeType = videoEncoderConfig.mEncodeType;
        this.mBitRate = videoEncoderConfig.mBitRate;
        this.mEncodeParameter = videoEncoderConfig.mEncodeParameter;
        this.mLowDelay = videoEncoderConfig.mLowDelay;
    }

    public void setEncodeSize(int i, int i2) {
        this.mEncodeWidth = i;
        this.mEncodeHeight = i2;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setBitRate(int i) {
        this.mBitRate = i;
    }

    public void setEncodeParam(String str) {
        this.mEncodeParameter = str;
    }

    public void setEncodeType(VideoEncoderType videoEncoderType) {
        this.mEncodeType = videoEncoderType;
    }

    public int getEncodeWidth() {
        return this.mEncodeWidth;
    }

    public int getEncodeHeight() {
        return this.mEncodeHeight;
    }

    public int getBitRate() {
        return this.mBitRate;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public String getRealDPI() {
        return VideoDataStatUtil.getDPI(this.mEncodeWidth, this.mEncodeHeight);
    }
}
