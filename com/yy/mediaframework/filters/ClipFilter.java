package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class ClipFilter extends AbstractYYMediaFilter {
    public PreviewFilter mPreviewFilter;
    private int mLastSampleWidth = 0;
    private int mLastSampleHeight = 0;

    public void setPreviewFilter(PreviewFilter previewFilter) {
        this.mPreviewFilter = previewFilter;
    }

    private boolean checkOutputChanged(YYMediaSample yYMediaSample, int i, int i2) {
        if (yYMediaSample.mEncodeWidth == 0 && yYMediaSample.mEncodeHeight == 0) {
            YMFLog.error(this, "[Encoder ]", "invalid encoder width or height");
            return false;
        }
        double d = (this.mOutputWidth * 1.0d) / this.mOutputHeight;
        double d2 = (yYMediaSample.mEncodeWidth * 1.0d) / yYMediaSample.mEncodeHeight;
        if (Math.abs(d - d2) <= 0.01d && i == this.mLastSampleWidth && i2 == this.mLastSampleHeight) {
            return false;
        }
        YMFLog.info(this, "[Encoder ]", "input size(width:%d height:%d), encode size(width:%d height:%d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(yYMediaSample.mEncodeWidth), Integer.valueOf(yYMediaSample.mEncodeHeight));
        StringBuilder sb = new StringBuilder();
        sb.append("checkOutputChanged, origOutputWidth:").append(this.mOutputWidth);
        sb.append(",origOutputHeight:").append(this.mOutputHeight);
        if ((i * 1.0d) / i2 > d2) {
            this.mOutputHeight = i2;
            this.mOutputWidth = (int) (i2 * d2);
        } else {
            this.mOutputWidth = i;
            this.mOutputHeight = (int) (i / d2);
        }
        this.mLastSampleWidth = i;
        this.mLastSampleHeight = i2;
        sb.append(", newOutputWidth:").append(this.mOutputWidth);
        sb.append(" newOutputHeight:").append(this.mOutputHeight);
        YMFLog.info(this, "[Encoder ]", sb.toString());
        return true;
    }

    private boolean checkOutputChanged(YYMediaSample yYMediaSample, int i, int i2, int i3) {
        if (yYMediaSample.mEncodeWidth == 0 && yYMediaSample.mEncodeHeight == 0) {
            YMFLog.error(this, "[Encoder ]", "invalid encoder width or height");
            return false;
        }
        double d = (this.mOutputWidth * 1.0d) / this.mOutputHeight;
        double d2 = (yYMediaSample.mEncodeWidth * 1.0d) / yYMediaSample.mEncodeHeight;
        if (Math.abs(d - d2) <= 0.01d && i == this.mLastSampleWidth && i2 == this.mLastSampleHeight) {
            return false;
        }
        YMFLog.info(this, "[Encoder ]", "input size(width:%d height:%d), encode size(width:%d height:%d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(yYMediaSample.mEncodeWidth), Integer.valueOf(yYMediaSample.mEncodeHeight));
        StringBuilder sb = new StringBuilder();
        sb.append("checkOutputChanged, origOutputWidth:").append(this.mOutputWidth);
        sb.append(",origOutputHeight:").append(this.mOutputHeight);
        double d3 = (i * 1.0d) / i2;
        if (i3 == 0) {
            if (d3 > d2) {
                this.mOutputWidth = i;
                this.mOutputHeight = (int) (i / d2);
            } else {
                this.mOutputHeight = i2;
                this.mOutputWidth = (int) (i2 * d2);
            }
        } else if (d3 > d2) {
            this.mOutputHeight = i2;
            this.mOutputWidth = (int) (i2 * d2);
        } else {
            this.mOutputWidth = i;
            this.mOutputHeight = (int) (i / d2);
        }
        this.mLastSampleWidth = i;
        this.mLastSampleHeight = i2;
        sb.append(", newOutputWidth:").append(this.mOutputWidth);
        sb.append(" newOutputHeight:").append(this.mOutputHeight);
        YMFLog.info(this, "[Encoder ]", sb.toString());
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (yYMediaSample.mIsYUVBuffer) {
            if (yYMediaSample.mSwapWidthHeight) {
                checkOutputChanged(yYMediaSample, yYMediaSample.mHeight, yYMediaSample.mWidth);
                yYMediaSample.mClipWidth = this.mOutputHeight;
                yYMediaSample.mClipHeight = this.mOutputWidth;
            } else {
                checkOutputChanged(yYMediaSample, yYMediaSample.mWidth, yYMediaSample.mHeight);
                yYMediaSample.mClipWidth = this.mOutputWidth;
                yYMediaSample.mClipHeight = this.mOutputHeight;
            }
            yYMediaSample.mClipX = ((yYMediaSample.mWidth - yYMediaSample.mClipWidth) / 2) & (-2);
            yYMediaSample.mClipY = ((yYMediaSample.mHeight - yYMediaSample.mClipHeight) / 2) & (-2);
        } else {
            if (!yYMediaSample.mUseExternalVideoFrame) {
                checkOutputChanged(yYMediaSample, yYMediaSample.mWidth, yYMediaSample.mHeight);
            } else {
                checkOutputChanged(yYMediaSample, yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mExternalFrameScaleMode);
            }
            yYMediaSample.mClipWidth = this.mOutputWidth;
            yYMediaSample.mClipHeight = this.mOutputHeight;
        }
        yYMediaSample.mClipWidth &= -4;
        yYMediaSample.mClipHeight &= -4;
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return false;
    }
}
