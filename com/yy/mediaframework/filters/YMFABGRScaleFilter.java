package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFABGRScaleFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFAbgrScaleFliter";
    private VideoLiveFilterContext mFilterContex;
    private YMFImageBuffer mRGBAScale;
    private int mClipX = 0;
    private int mClipY = 0;
    private int mClipW = 0;
    private int mClipH = 0;
    private int mScaleH = 0;
    private int mScaleW = 0;
    private byte[] mRGBAConvert = null;

    public YMFABGRScaleFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContex = videoLiveFilterContext;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        boolean z;
        boolean z2;
        if (yYMediaSample.mImageFormat != 36 || yYMediaSample.mRGBABytes == null) {
            return false;
        }
        yYMediaSample.addRef();
        boolean z3 = false;
        if (yYMediaSample.mCameraFacing == 1 && yYMediaSample.mIsMirrorEnable != yYMediaSample.mDataMirror) {
            z3 = true;
        }
        if (yYMediaSample.mWidth != yYMediaSample.mEncodeWidth || yYMediaSample.mHeight != yYMediaSample.mEncodeHeight || z3) {
            if (this.mRGBAScale == null || this.mRGBAScale.mWidth != yYMediaSample.mEncodeWidth || this.mRGBAScale.mHeight != yYMediaSample.mEncodeHeight) {
                this.mRGBAScale = new YMFImageBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, 36, true);
            }
            if (yYMediaSample.mEncodeWidth * yYMediaSample.mHeight > yYMediaSample.mEncodeHeight * yYMediaSample.mWidth) {
                this.mScaleH = (int) ((((1.0d * yYMediaSample.mEncodeWidth) / yYMediaSample.mWidth) * yYMediaSample.mHeight) + 0.5d);
                this.mScaleW = yYMediaSample.mEncodeWidth;
                this.mClipX = 0;
                this.mClipY = (this.mScaleH - yYMediaSample.mEncodeHeight) / 2;
            } else {
                double d = (1.0d * yYMediaSample.mEncodeHeight) / yYMediaSample.mHeight;
                this.mScaleH = yYMediaSample.mEncodeHeight;
                this.mScaleW = (int) ((d * yYMediaSample.mWidth) + 0.5d);
                this.mClipX = (this.mScaleW - yYMediaSample.mEncodeWidth) / 2;
                this.mClipY = 0;
            }
            this.mClipH = yYMediaSample.mEncodeHeight;
            this.mClipW = yYMediaSample.mEncodeWidth;
            if (this.mRGBAConvert == null || this.mRGBAConvert.length != this.mScaleW * this.mScaleH * 4) {
                this.mRGBAConvert = new byte[this.mScaleW * this.mScaleH * 4];
            }
            this.mRGBAScale.mData.rewind();
            int ABGRScaleClip = ImageUtil.ABGRScaleClip(yYMediaSample.mRGBABytes, yYMediaSample.mWidth, yYMediaSample.mHeight, this.mRGBAConvert, this.mScaleW, this.mScaleH, this.mClipX, this.mClipY, this.mClipW, this.mClipH, this.mRGBAScale.mData.array(), YMFImageBuffer.offset(), 1, z3);
            if (ABGRScaleClip != 0) {
                YMFLog.error(this, "[Preproce]", "ABGRScaleClip failed, return " + ABGRScaleClip);
                yYMediaSample.decRef();
                return false;
            }
            yYMediaSample.mRGBA = this.mRGBAScale;
            yYMediaSample.mCliped = true;
            if (z3) {
                z = !yYMediaSample.mDataMirror;
            } else {
                z = yYMediaSample.mDataMirror;
            }
            yYMediaSample.mDataMirror = z;
            yYMediaSample.mImageFormat = 36;
            yYMediaSample.mRGBA.mWidth = yYMediaSample.mEncodeWidth;
            yYMediaSample.mRGBA.mHeight = yYMediaSample.mEncodeHeight;
        } else {
            if (this.mRGBAScale == null || this.mRGBAScale.mWidth != yYMediaSample.mEncodeWidth || this.mRGBAScale.mHeight != yYMediaSample.mEncodeHeight) {
                this.mRGBAScale = new YMFImageBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, 36, true);
            }
            this.mRGBAScale.mData.put(yYMediaSample.mRGBABytes, 0, yYMediaSample.mEncodeWidth * yYMediaSample.mEncodeHeight * 4);
            yYMediaSample.mRGBA = this.mRGBAScale;
            yYMediaSample.mCliped = true;
            if (z3) {
                z2 = !yYMediaSample.mDataMirror;
            } else {
                z2 = yYMediaSample.mDataMirror;
            }
            yYMediaSample.mDataMirror = z2;
            yYMediaSample.mImageFormat = 36;
            yYMediaSample.mRGBA.mWidth = yYMediaSample.mEncodeWidth;
            yYMediaSample.mRGBA.mHeight = yYMediaSample.mEncodeHeight;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return false;
    }
}
