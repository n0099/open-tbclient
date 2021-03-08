package com.yy.mediaframework.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
/* loaded from: classes6.dex */
public class YMFBitmapWaterMarkFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFI420WaterMarkFilter";
    private VideoLiveFilterContext mFilterContex;
    private YMFImageBuffer mI420;
    private YMFImageBuffer mRGBABuffer;
    private int mFormat = 4;
    private boolean mInited = false;
    private Paint mPaint = null;
    private Canvas mCanvas = null;
    private Bitmap mBitmap = null;

    public YMFBitmapWaterMarkFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContex = videoLiveFilterContext;
    }

    private void init(int i, int i2) {
        if (this.mBitmap == null) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        if (this.mCanvas == null) {
            this.mCanvas = new Canvas(this.mBitmap);
        }
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        if (this.mRGBABuffer == null) {
            this.mRGBABuffer = new YMFImageBuffer(i, i2, 36, true);
        }
        this.mInited = true;
    }

    private void checkUpdata(YMFImageBuffer yMFImageBuffer) {
        if (this.mRGBABuffer == null || this.mRGBABuffer.mWidth != yMFImageBuffer.mWidth || this.mRGBABuffer.mHeight != yMFImageBuffer.mHeight) {
            this.mRGBABuffer = new YMFImageBuffer(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, 36, true);
        }
        if (this.mBitmap == null || this.mBitmap.getWidth() != yMFImageBuffer.mWidth || this.mBitmap.getHeight() != yMFImageBuffer.mHeight) {
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
            if (this.mCanvas != null) {
                this.mCanvas = null;
            }
            this.mBitmap = Bitmap.createBitmap(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    private boolean composeWaterMarkByI420(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mImageFormat != 2 || yYMediaSample.mI420 == null || yYMediaSample.mI420.mData == null) {
            return false;
        }
        yYMediaSample.addRef();
        WaterMark watermark = this.mFilterContex.getWatermark();
        if (watermark != null) {
            if (!this.mInited) {
                init(yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight);
            }
            checkUpdata(yYMediaSample.mI420);
            int I420ToABGR = ImageUtil.I420ToABGR(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, this.mRGBABuffer.mData.array(), YMFImageBuffer.offset(), false);
            if (I420ToABGR != 0) {
                YMFLog.error(this, "[Preproce]", "I420ToABGR failed, return " + I420ToABGR);
                yYMediaSample.decRef();
                return false;
            }
            this.mRGBABuffer.mData.rewind();
            this.mBitmap.copyPixelsFromBuffer(this.mRGBABuffer.mData);
            this.mBitmap.setHasAlpha(true);
            this.mCanvas.drawBitmap(watermark.bitmap, watermark.offsetX, watermark.offsetY, this.mPaint);
            this.mRGBABuffer.mData.rewind();
            this.mBitmap.copyPixelsToBuffer(this.mRGBABuffer.mData);
            int ABGRToI420 = ImageUtil.ABGRToI420(this.mRGBABuffer.mData.array(), this.mRGBABuffer.mWidth, this.mRGBABuffer.mHeight, yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mData.arrayOffset(), false);
            if (ABGRToI420 != 0) {
                YMFLog.error(this, "[Preproce]", "ABGRToI420 failed, return " + ABGRToI420);
                yYMediaSample.decRef();
                return false;
            }
            yYMediaSample.mImageFormat = 2;
            yYMediaSample.mI420.mWidth = this.mRGBABuffer.mWidth;
            yYMediaSample.mI420.mHeight = this.mRGBABuffer.mHeight;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    private boolean composeWaterMarkByRgba(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mImageFormat != 36 || yYMediaSample.mRGBA == null || yYMediaSample.mRGBA.mData == null) {
            return false;
        }
        yYMediaSample.addRef();
        WaterMark watermark = this.mFilterContex.getWatermark();
        if (watermark != null) {
            if (!this.mInited) {
                init(yYMediaSample.mRGBA.mWidth, yYMediaSample.mRGBA.mHeight);
            }
            checkUpdata(yYMediaSample.mRGBA);
            if (this.mI420 == null || this.mI420.mWidth != this.mRGBABuffer.mWidth || this.mI420.mHeight != this.mRGBABuffer.mHeight) {
                this.mI420 = new YMFImageBuffer(this.mRGBABuffer.mWidth, this.mRGBABuffer.mHeight, 2, true);
            }
            yYMediaSample.mRGBA.mData.rewind();
            this.mBitmap.copyPixelsFromBuffer(yYMediaSample.mRGBA.mData);
            this.mBitmap.setHasAlpha(true);
            this.mCanvas.drawBitmap(watermark.bitmap, watermark.offsetX, watermark.offsetY, this.mPaint);
            this.mRGBABuffer.mData.rewind();
            this.mBitmap.copyPixelsToBuffer(this.mRGBABuffer.mData);
            int ABGRToI420 = ImageUtil.ABGRToI420(this.mRGBABuffer.mData.array(), this.mRGBABuffer.mWidth, this.mRGBABuffer.mHeight, this.mI420.mData.array(), this.mI420.mData.arrayOffset(), false);
            if (ABGRToI420 != 0) {
                YMFLog.error(this, "[Preproce]", "ABGRToI420 failed, return " + ABGRToI420);
                yYMediaSample.decRef();
                return false;
            }
            yYMediaSample.mImageFormat = 2;
            yYMediaSample.mI420 = this.mI420;
            yYMediaSample.mI420.mWidth = this.mRGBABuffer.mWidth;
            yYMediaSample.mI420.mHeight = this.mRGBABuffer.mHeight;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample.mImageFormat == 2) {
            composeWaterMarkByI420(yYMediaSample);
            return true;
        } else if (yYMediaSample.mImageFormat == 36) {
            composeWaterMarkByRgba(yYMediaSample);
            return true;
        } else {
            return true;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
        if (this.mCanvas != null) {
            this.mCanvas = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mPaint != null) {
            this.mPaint = null;
        }
    }
}
