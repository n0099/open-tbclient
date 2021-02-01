package com.yy.mediaframework.model;
/* loaded from: classes4.dex */
public class YUVImageBuffer extends ImageBuffer {
    public long mPts = 0;
    public int mStreamId = 0;
    public int mFrameRate = 0;
    public int mBitRate = 0;
    public boolean mLowDelay = false;
    public String mEncodeParameter = null;

    @Override // com.yy.mediaframework.model.ImageBuffer
    public int imageSize() {
        return ((this.mWidth * this.mHeight) * 3) / 2;
    }
}
