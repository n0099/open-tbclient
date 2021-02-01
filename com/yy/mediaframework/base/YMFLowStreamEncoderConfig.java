package com.yy.mediaframework.base;
/* loaded from: classes4.dex */
public final class YMFLowStreamEncoderConfig {
    public int mCodeRate;
    public int mConfigId;
    public int mEncodeHeight;
    public String mEncodeParam;
    public int mEncodeWidth;
    public int mEncoderId;
    public int mFrameRate;
    public int mMaxCodeRate;
    public int mMinCodeRate;
    public int mTranscoding;

    public YMFLowStreamEncoderConfig() {
    }

    public YMFLowStreamEncoderConfig(YMFLowStreamEncoderConfig yMFLowStreamEncoderConfig) {
        this.mConfigId = yMFLowStreamEncoderConfig.mConfigId;
        this.mEncoderId = yMFLowStreamEncoderConfig.mEncoderId;
        this.mEncodeWidth = yMFLowStreamEncoderConfig.mEncodeWidth;
        this.mEncodeHeight = yMFLowStreamEncoderConfig.mEncodeHeight;
        this.mFrameRate = yMFLowStreamEncoderConfig.mFrameRate;
        this.mCodeRate = yMFLowStreamEncoderConfig.mCodeRate;
        this.mMaxCodeRate = yMFLowStreamEncoderConfig.mMaxCodeRate;
        this.mMinCodeRate = yMFLowStreamEncoderConfig.mMinCodeRate;
        this.mTranscoding = yMFLowStreamEncoderConfig.mTranscoding;
        this.mEncodeParam = yMFLowStreamEncoderConfig.mEncodeParam;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("YMFLowStreamEncoderConfig{");
        sb.append("mConfigId=").append(this.mConfigId);
        sb.append(", mEncoderId=").append(this.mEncoderId);
        sb.append(", mEncodeWidth=").append(this.mEncodeWidth);
        sb.append(", mEncodeHeight=").append(this.mEncodeHeight);
        sb.append(", mFrameRate=").append(this.mFrameRate);
        sb.append(", mCodeRate=").append(this.mCodeRate);
        sb.append(", mMaxCodeRate=").append(this.mMaxCodeRate);
        sb.append(", mMinCodeRate=").append(this.mMinCodeRate);
        sb.append(", mTranscoding=").append(this.mTranscoding);
        sb.append(", mEncodeParam=").append(this.mEncodeParam);
        sb.append('}');
        return sb.toString();
    }
}
