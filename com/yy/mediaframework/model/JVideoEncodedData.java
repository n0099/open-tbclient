package com.yy.mediaframework.model;

import com.yy.mediaframework.base.VideoEncoderType;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class JVideoEncodedData {
    public int mFrameType = 255;
    public long mPts = 0;
    public long mDts = 0;
    public long mDataLen = 0;
    public ByteBuffer mByteBuffer = null;
    public VideoEncoderType mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;

    public static native void nativeClassInit();

    private native void nativeRelaseVideoByteBuffer();

    public void releaseVideoByteBuffer() {
        if (this.mByteBuffer != null) {
            nativeRelaseVideoByteBuffer();
            this.mByteBuffer = null;
        }
    }

    public YYMediaSample toYYMediaSample() {
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mDataByteBuffer = this.mByteBuffer;
        alloc.mBufferSize = (int) this.mDataLen;
        alloc.mYYPtsMillions = this.mPts;
        alloc.mDtsMillions = this.mDts;
        alloc.mFrameType = this.mFrameType;
        alloc.mEncoderType = this.mEncodeType;
        return alloc;
    }

    static {
        nativeClassInit();
    }
}
