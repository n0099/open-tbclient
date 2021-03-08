package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFNV21ToI420Filter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFNV21ToI420Filter";
    private VideoLiveFilterContext mFilterContext;
    private YMFImageBuffer mI420;

    public YMFNV21ToI420Filter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (!yYMediaSample.mUseGPUBeauty && yYMediaSample.mIsYUVBuffer && yYMediaSample.mDataBytes != null && !cpuConvertCropRotate(yYMediaSample)) {
            yYMediaSample.decRef();
            return false;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    private boolean cpuConvertCropRotate(YYMediaSample yYMediaSample) {
        int i;
        int i2;
        int i3;
        if (yYMediaSample.mImageFormat != 0) {
            YMFLog.error(this, "[Preproce]", "invalid YUVFormat, need NV21.");
            return false;
        }
        int i4 = yYMediaSample.mClipWidth;
        int i5 = yYMediaSample.mClipHeight;
        if (yYMediaSample.mSwapWidthHeight) {
            int i6 = yYMediaSample.mClipHeight;
            i = yYMediaSample.mClipWidth;
            i2 = i6;
        } else {
            i = i5;
            i2 = i4;
        }
        if (this.mI420 == null || this.mI420.mWidth != i2 || this.mI420.mHeight != i) {
            this.mI420 = new YMFImageBuffer(i2, i, 2, true);
        }
        if (yYMediaSample.mCameraFacing == 1) {
            i3 = 360 - yYMediaSample.mCameraRotate;
        } else {
            i3 = yYMediaSample.mCameraRotate;
        }
        int ConvertToI420Ex = ImageUtil.ConvertToI420Ex(yYMediaSample.mDataBytes, 0, yYMediaSample.mDataBytes.length, this.mI420.mData.array(), this.mI420.mData.arrayOffset(), yYMediaSample.mClipX, yYMediaSample.mClipY, yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight, i3, 0);
        if (ConvertToI420Ex != 0) {
            YMFLog.error(this, "[Preproce]", "ConvertToI420Ex failed, return " + ConvertToI420Ex);
            return false;
        }
        yYMediaSample.mWidth = i2;
        yYMediaSample.mHeight = i;
        yYMediaSample.mCliped = true;
        yYMediaSample.mI420 = this.mI420;
        yYMediaSample.mImageFormat = 2;
        return true;
    }
}
