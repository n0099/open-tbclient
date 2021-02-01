package com.yy.mediaframework.inteligence.common;

import com.yy.mediaframework.base.VideoEncoderType;
/* loaded from: classes4.dex */
public class ResolutionModifyConfig {
    public String encoderParams;
    public int height;
    public int maxCodeRate;
    public int maxFrameRate;
    public int minCodeRate;
    public int minFrameRate;
    public VideoEncoderType videoEncoderType;
    public int width;

    public ResolutionModifyConfig(int i, int i2, int i3, int i4, int i5, int i6, VideoEncoderType videoEncoderType, String str) {
        this.videoEncoderType = VideoEncoderType.HARD_ENCODER_H264;
        this.width = i;
        this.height = i2;
        this.minCodeRate = i3;
        this.maxCodeRate = i4;
        this.minFrameRate = i5;
        this.maxFrameRate = i6;
        this.videoEncoderType = videoEncoderType;
        this.encoderParams = str;
    }

    public ResolutionModifyConfig(ResolutionModifyConfig resolutionModifyConfig) {
        this.videoEncoderType = VideoEncoderType.HARD_ENCODER_H264;
        if (resolutionModifyConfig != null) {
            this.width = resolutionModifyConfig.width;
            this.height = resolutionModifyConfig.height;
            this.minCodeRate = resolutionModifyConfig.minCodeRate;
            this.maxCodeRate = resolutionModifyConfig.maxCodeRate;
            this.minFrameRate = resolutionModifyConfig.minFrameRate;
            this.maxFrameRate = resolutionModifyConfig.maxFrameRate;
            this.videoEncoderType = resolutionModifyConfig.videoEncoderType;
            this.encoderParams = resolutionModifyConfig.encoderParams;
        }
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0 && this.minCodeRate > 0 && this.maxCodeRate >= this.minCodeRate && this.minFrameRate > 0 && this.maxFrameRate >= this.minFrameRate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResolutionModifyConfig{");
        sb.append("width=").append(this.width);
        sb.append(", height=").append(this.height);
        sb.append(", minCodeRate=").append(this.minCodeRate);
        sb.append(", maxCodeRate=").append(this.maxCodeRate);
        sb.append(", minFrameRate=").append(this.minFrameRate);
        sb.append(", maxFrameRate=").append(this.maxFrameRate);
        sb.append(", videoEncoderType=").append(this.videoEncoderType);
        sb.append(", encoderParams=").append(this.encoderParams);
        sb.append('}');
        return sb.toString();
    }
}
