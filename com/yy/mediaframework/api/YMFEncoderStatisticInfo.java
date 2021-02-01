package com.yy.mediaframework.api;

import com.yy.mediaframework.base.VideoEncoderType;
/* loaded from: classes4.dex */
public final class YMFEncoderStatisticInfo {
    public int mBitRate;
    public VideoEncoderType mEncoderType;
    public int mFrameRate;
    public int mHeight;
    public int mStreamId;
    public int mWidth;

    public YMFEncoderStatisticInfo(int i) {
        this.mStreamId = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mStreamId:").append(this.mStreamId);
        sb.append(" mEncoderType:").append(this.mEncoderType);
        sb.append(" mWidth:").append(this.mWidth);
        sb.append(" mHeight:").append(this.mHeight);
        sb.append(" mFrameRate:").append(this.mFrameRate);
        sb.append(" mBitRate:").append(this.mBitRate);
        return sb.toString();
    }

    public void assign(YMFEncoderStatisticInfo yMFEncoderStatisticInfo) {
        this.mStreamId = yMFEncoderStatisticInfo.mStreamId;
        this.mEncoderType = yMFEncoderStatisticInfo.mEncoderType;
        this.mFrameRate = yMFEncoderStatisticInfo.mFrameRate;
        this.mBitRate = yMFEncoderStatisticInfo.mBitRate;
        this.mWidth = yMFEncoderStatisticInfo.mWidth;
        this.mHeight = yMFEncoderStatisticInfo.mHeight;
    }
}
