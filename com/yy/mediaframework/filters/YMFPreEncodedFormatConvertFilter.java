package com.yy.mediaframework.filters;

import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.MediaCodecUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFPreEncodedFormatConvertFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFI420ToNV12Filter";
    private VideoLiveFilterContext mFilterContex;
    private YMFImageBuffer mI420;
    private YMFImageBuffer mNV12;
    private int mTargetEncodedFormat = 2;

    public YMFPreEncodedFormatConvertFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContex = videoLiveFilterContext;
    }

    public boolean converRgbaToI420(YYMediaSample yYMediaSample) {
        if (this.mI420 == null || this.mI420.mWidth != yYMediaSample.mRGBA.mWidth || this.mI420.mHeight != yYMediaSample.mRGBA.mHeight) {
            this.mI420 = new YMFImageBuffer(yYMediaSample.mRGBA.mWidth, yYMediaSample.mRGBA.mHeight, 2, true);
        }
        int ABGRToI420 = ImageUtil.ABGRToI420(yYMediaSample.mRGBA.mData.array(), yYMediaSample.mRGBA.mWidth, yYMediaSample.mRGBA.mHeight, this.mI420.mData.array(), this.mI420.mData.arrayOffset(), false);
        if (ABGRToI420 != 0) {
            YMFLog.error(this, "[Preproce]", " ABGRToI420 failed, return " + ABGRToI420);
            yYMediaSample.decRef();
            return false;
        }
        yYMediaSample.mI420 = this.mI420;
        yYMediaSample.mImageFormat = 2;
        return true;
    }

    public boolean converRgbaToNV12(YYMediaSample yYMediaSample) {
        converRgbaToI420(yYMediaSample);
        if (this.mNV12 == null || this.mNV12.mWidth != yYMediaSample.mI420.mWidth || this.mNV12.mHeight != yYMediaSample.mI420.mHeight) {
            this.mNV12 = new YMFImageBuffer(yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, 1, true);
        }
        int I420ToNV12 = ImageUtil.I420ToNV12(this.mI420.mData.array(), this.mI420.mData.arrayOffset(), this.mI420.mWidth, this.mI420.mHeight, this.mNV12.mData.array(), false);
        if (I420ToNV12 != 0) {
            YMFLog.error(this, "[Preproce]", " I420ToNV12 failed, return " + I420ToNV12);
            yYMediaSample.decRef();
            return false;
        }
        yYMediaSample.mNV12 = this.mNV12;
        yYMediaSample.mImageFormat = 1;
        return true;
    }

    public boolean converI420ToNV12(YYMediaSample yYMediaSample) {
        if (this.mNV12 == null || this.mNV12.mWidth != yYMediaSample.mI420.mWidth || this.mNV12.mHeight != yYMediaSample.mI420.mHeight) {
            this.mNV12 = new YMFImageBuffer(yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, 1, true);
        }
        int I420ToNV12 = ImageUtil.I420ToNV12(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mData.arrayOffset(), yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, this.mNV12.mData.array(), false);
        if (I420ToNV12 != 0) {
            YMFLog.error(this, "[Preproce]", " I420ToNV12 failed, return " + I420ToNV12);
            yYMediaSample.decRef();
            return false;
        }
        yYMediaSample.mNV12 = this.mNV12;
        yYMediaSample.mImageFormat = 1;
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mFilterContex.getVideoEncoderConfig().mEncodeType != VideoEncoderType.SOFT_ENCODER_X264) {
            int colorFormat = MediaCodecUtil.instance().getColorFormat(this.mFilterContex.getVideoEncoderConfig().mEncodeType);
            if (colorFormat > 0 && MediaCodecUtil.isSemiPlanar(colorFormat)) {
                this.mTargetEncodedFormat = 1;
            }
        } else if (this.mFilterContex.getVideoEncoderConfig().mEncodeType == VideoEncoderType.SOFT_ENCODER_X264) {
            this.mTargetEncodedFormat = 2;
        }
        if (yYMediaSample.mImageFormat == this.mTargetEncodedFormat) {
            return false;
        }
        yYMediaSample.addRef();
        if (this.mTargetEncodedFormat == 2) {
            if (yYMediaSample.mImageFormat == 36 && yYMediaSample.mRGBA != null && yYMediaSample.mRGBA.mData != null) {
                converRgbaToI420(yYMediaSample);
            }
        } else if (this.mTargetEncodedFormat == 1) {
            if (yYMediaSample.mImageFormat == 36 && yYMediaSample.mRGBA != null && yYMediaSample.mRGBA.mData != null) {
                converRgbaToNV12(yYMediaSample);
            } else if (yYMediaSample.mImageFormat == 2 && yYMediaSample.mI420 != null && yYMediaSample.mI420.mData != null) {
                converI420ToNV12(yYMediaSample);
            }
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
    }
}
