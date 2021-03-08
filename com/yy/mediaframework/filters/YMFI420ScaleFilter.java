package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFI420ScaleFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFI420ScaleFilter";
    private VideoLiveFilterContext mFilterContex;
    private YMFImageBuffer mI420ScaleTarget;

    public YMFI420ScaleFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContex = videoLiveFilterContext;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample.mImageFormat != 2 || yYMediaSample.mI420 == null || yYMediaSample.mI420.mData == null) {
            YMFLog.error(this, "[Preproce]", "invalid I420 input buffer.");
            return false;
        }
        yYMediaSample.addRef();
        boolean z = yYMediaSample.mCameraFacing == 1 ? yYMediaSample.mIsMirrorEnable : false;
        if (yYMediaSample.mWidth != yYMediaSample.mEncodeWidth || yYMediaSample.mHeight != yYMediaSample.mEncodeHeight || yYMediaSample.mIsMirrorEnable) {
            if (this.mI420ScaleTarget == null || this.mI420ScaleTarget.mWidth != yYMediaSample.mEncodeWidth || this.mI420ScaleTarget.mHeight != yYMediaSample.mEncodeHeight) {
                this.mI420ScaleTarget = new YMFImageBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, 2, true);
            }
            int I420Scale = ImageUtil.I420Scale(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mData.arrayOffset(), yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, this.mI420ScaleTarget.mData.array(), yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, 0, z);
            if (I420Scale == 0) {
                yYMediaSample.mI420 = this.mI420ScaleTarget;
                yYMediaSample.mImageFormat = 2;
                yYMediaSample.mWidth = yYMediaSample.mEncodeWidth;
                yYMediaSample.mHeight = yYMediaSample.mEncodeHeight;
                yYMediaSample.mDataMirror = z;
            } else {
                YMFLog.error(this, "[Preproce]", "I420Scale failed, return " + I420Scale);
                yYMediaSample.mI420 = null;
                yYMediaSample.decRef();
                return false;
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
