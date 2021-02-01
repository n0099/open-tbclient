package com.yy.mediaframework;

import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
/* loaded from: classes4.dex */
public class PublishVideoConfig extends VideoEncoderConfig {
    public static final int PUBLISH_VIDEO_MODE_HIGHQULITY = 1;
    public static final int PUBLISH_VIDEO_MODE_NORMAL = 0;
    public static final int PUBLISH_VIDEO_MODE_SCREEN_RECORD_HIGHQULITY = 3;
    public static final int PUBLISH_VIDEO_MODE_SCREEN_RECORD_NORMAL = 2;
    public static final int PUBLISH_VIDEO_MODE_SCREEN_RECORD_ULTRA_HIGHQULITY = 4;

    public PublishVideoConfig(int i) {
        if (i == 0) {
            this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
            this.mLowDelay = false;
            setEncodeSize(368, 640);
            this.mFrameRate = 24;
            this.mBitRate = 1200000;
            this.mEncodeParameter = "";
            this.videoStabilization = true;
        } else if (i == 1) {
            this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
            this.mLowDelay = false;
            setEncodeSize(VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH, 960);
            this.mFrameRate = 24;
            this.mBitRate = 1200000;
            this.mEncodeParameter = "";
            this.videoStabilization = true;
        } else if (i == 2) {
            this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
            this.mLowDelay = false;
            setEncodeSize(368, 640);
            this.mFrameRate = 30;
            this.mBitRate = VideoEncoderConfig.SCREEN_RECORD_ENCODE_LOW_BITRATE;
            this.mEncodeParameter = "";
            this.videoStabilization = true;
        } else if (i == 3) {
            this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
            this.mLowDelay = false;
            setEncodeSize(480, VideoEncoderConfig.SCREEN_RECORD_ENCODE_HIGH_HEIGHT);
            this.mFrameRate = 30;
            this.mBitRate = 1200000;
            this.mEncodeParameter = "";
            this.videoStabilization = true;
        } else if (i == 4) {
            this.mEncodeType = VideoEncoderType.HARD_ENCODER_H264;
            this.mLowDelay = false;
            setEncodeSize(720, 1280);
            this.mFrameRate = 30;
            this.mBitRate = VideoEncoderConfig.SCREEN_RECORD_ENCODE_ULTRA_HIGH_BITRATE;
            this.mEncodeParameter = "";
            this.videoStabilization = true;
        }
    }

    @Override // com.yy.mediaframework.base.VideoEncoderConfig
    public void assign(VideoEncoderConfig videoEncoderConfig) {
        setEncodeSize(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
        this.mFrameRate = videoEncoderConfig.mFrameRate;
        this.videoStabilization = videoEncoderConfig.videoStabilization;
        this.mEncodeType = videoEncoderConfig.mEncodeType;
        this.mBitRate = videoEncoderConfig.mBitRate;
        this.mEncodeParameter = videoEncoderConfig.mEncodeParameter;
        this.mLowDelay = videoEncoderConfig.mLowDelay;
    }

    @Override // com.yy.mediaframework.base.VideoEncoderConfig
    public void setEncodeSize(int i, int i2) {
        this.mEncodeWidth = i;
        this.mEncodeHeight = i2;
    }

    public PublishVideoConfig() {
        this(VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH, 960, 24, 1200000, VideoEncoderType.HARD_ENCODER_H264.ordinal(), "");
    }

    public PublishVideoConfig(int i, int i2, int i3, int i4, int i5, String str) {
        VideoEncoderType videoEncoderType;
        if (i5 == VideoEncoderType.HARD_ENCODER_H264.ordinal()) {
            videoEncoderType = VideoEncoderType.HARD_ENCODER_H264;
        } else if (i5 == VideoEncoderType.SOFT_ENCODER_X264.ordinal()) {
            videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
        } else {
            videoEncoderType = i5 == VideoEncoderType.SOFT_ENCODER_H265.ordinal() ? VideoEncoderType.SOFT_ENCODER_H265 : null;
        }
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
}
