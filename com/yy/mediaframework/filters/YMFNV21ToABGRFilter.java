package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFNV21ToABGRFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFNV21ToABGRFilter";
    private byte[] ABGRTargetData;
    private byte[] ARGB;
    private byte[] ARGBScaleData;
    private VideoLiveFilterContext mFilterContext;

    public YMFNV21ToABGRFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    public boolean convertNV21ToABGR(YYMediaSample yYMediaSample) {
        int i;
        if (this.ARGB == null || this.ARGB.length != yYMediaSample.mWidth * yYMediaSample.mHeight * 4) {
            this.ARGB = new byte[yYMediaSample.mHeight * yYMediaSample.mWidth * 4];
        }
        int i2 = yYMediaSample.mWidth;
        int i3 = yYMediaSample.mHeight;
        if (yYMediaSample.mSwapWidthHeight) {
            i2 = yYMediaSample.mHeight;
            i3 = yYMediaSample.mWidth;
        }
        if (this.ARGBScaleData == null || this.ARGBScaleData.length != i3 * i2 * 4) {
            this.ARGBScaleData = new byte[i3 * i2 * 4];
        }
        if (this.ABGRTargetData == null || this.ABGRTargetData.length != i3 * i2 * 4) {
            this.ABGRTargetData = new byte[i3 * i2 * 4];
        }
        if (yYMediaSample.mCameraFacing == 1) {
            i = 360 - yYMediaSample.mCameraRotate;
        } else {
            i = yYMediaSample.mCameraRotate;
        }
        int NV21ToARGB = ImageUtil.NV21ToARGB(yYMediaSample.mDataBytes, yYMediaSample.mWidth, yYMediaSample.mHeight, this.ARGB);
        if (NV21ToARGB != 0) {
            YMFLog.error(this, "[Preproce]", "NV21ToARGB failed, return " + NV21ToARGB);
            return false;
        }
        int ARGBRatation = ImageUtil.ARGBRatation(this.ARGB, yYMediaSample.mWidth, yYMediaSample.mHeight, this.ARGBScaleData, i);
        if (ARGBRatation != 0) {
            YMFLog.error(this, "[Preproce]", "ScaleAndRatationARGB failed, return " + ARGBRatation);
            return false;
        }
        int ARGBToABGR = ImageUtil.ARGBToABGR(this.ARGBScaleData, i2 * 4, this.ABGRTargetData, i2 * 4, i2, i3);
        if (ARGBToABGR != 0) {
            YMFLog.error(this, "[Preproce]", "ARGBToABGR failed, return " + ARGBToABGR);
            return false;
        }
        yYMediaSample.mWidth = i2;
        yYMediaSample.mHeight = i3;
        yYMediaSample.mRGBABytes = this.ABGRTargetData;
        yYMediaSample.mImageFormat = 36;
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (!yYMediaSample.mUseGPUBeauty && yYMediaSample.mIsYUVBuffer && yYMediaSample.mDataBytes != null && !convertNV21ToABGR(yYMediaSample)) {
            yYMediaSample.decRef();
            return false;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }
}
