package com.yy.mediaframework.filters;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.YMFTexture;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class YMFCaptureReplaceImageFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFCaptureReplaceImageFilter";
    private VideoLiveFilterContext mFilterContext;
    private Bitmap mReplaceBitmap = null;
    private YMFTexture mBitmapTexture = null;
    private YMFImageBuffer mImageBuffer = null;
    private YMFImageBuffer mI420 = null;
    private YMFImageBuffer mNV21 = null;
    private int mRotateAngle = 0;
    private boolean mBitmapChanged = false;

    public YMFCaptureReplaceImageFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    public void setReplaceBitmap(Bitmap bitmap) {
        YMFLog.info(this, "[Preview ]", "setReplaceBitmap, bitmap==null? " + (bitmap == null ? "y" : "n"));
        if (this.mReplaceBitmap != null && !this.mReplaceBitmap.isRecycled()) {
            this.mReplaceBitmap.recycle();
        }
        this.mReplaceBitmap = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mReplaceBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        this.mRotateAngle = 0;
        this.mBitmapChanged = true;
    }

    private void replaceTextrue(YYMediaSample yYMediaSample) {
        int width = this.mReplaceBitmap.getWidth();
        int height = this.mReplaceBitmap.getHeight();
        if (this.mBitmapTexture == null || this.mBitmapTexture.getWidth() != width || this.mBitmapTexture.getHeight() != height || this.mBitmapChanged) {
            if (this.mBitmapTexture != null) {
                this.mBitmapTexture.release();
                this.mBitmapTexture = null;
            }
            this.mBitmapTexture = new YMFTexture(this.mReplaceBitmap, 3553, width, height, 6408, 33984);
            GlUtil.checkGlError("replaceTextrue");
            this.mBitmapChanged = false;
        }
        yYMediaSample.mMasterTextureId = this.mBitmapTexture.getTextureId();
        yYMediaSample.mTextureTarget = this.mBitmapTexture.getTarget();
        yYMediaSample.mWidth = this.mBitmapTexture.getWidth();
        yYMediaSample.mHeight = this.mBitmapTexture.getHeight();
    }

    private Bitmap rotateBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
        return Bitmap.createBitmap(createScaledBitmap, 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), matrix, true);
    }

    private void replaceYUV(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mCameraRotate != 0 && this.mRotateAngle != yYMediaSample.mCameraRotate) {
            this.mReplaceBitmap = rotateBitmap(this.mReplaceBitmap, yYMediaSample.mCameraRotate);
            this.mRotateAngle = yYMediaSample.mCameraRotate;
        }
        int width = this.mReplaceBitmap.getWidth();
        int height = this.mReplaceBitmap.getHeight();
        if (this.mImageBuffer == null || this.mImageBuffer.mWidth != width || this.mImageBuffer.mHeight != height) {
            this.mImageBuffer = new YMFImageBuffer(width, height, 36, false);
            this.mImageBuffer.mData = ByteBuffer.allocateDirect(this.mReplaceBitmap.getByteCount());
        }
        try {
            this.mImageBuffer.mData.rewind();
            this.mReplaceBitmap.copyPixelsToBuffer(this.mImageBuffer.mData);
            this.mImageBuffer.mData.rewind();
            if (this.mI420 == null || this.mI420.mWidth != width || this.mI420.mHeight != height) {
                this.mI420 = new YMFImageBuffer(width, height, 2, true);
            }
            int ABGRToI420 = ImageUtil.ABGRToI420(this.mImageBuffer.mData.array(), this.mImageBuffer.mWidth, this.mImageBuffer.mHeight, this.mI420.mData.array(), this.mI420.mData.arrayOffset(), false);
            if (ABGRToI420 != 0) {
                YMFLog.error(this, "[Preproce]", " ABGRToI420 failed, return " + ABGRToI420);
                yYMediaSample.decRef();
                return;
            }
            if (this.mNV21 == null || this.mNV21.mWidth != width || this.mNV21.mHeight != height) {
                this.mNV21 = new YMFImageBuffer(width, height, 0, true);
            }
            ImageUtil.I420ToNV21(this.mI420.mData.array(), this.mNV21.mData.array(), width, height, false);
            if (ABGRToI420 != 0) {
                YMFLog.error(this, "[Preproce]", " I420ToNV21 failed, return " + ABGRToI420);
                yYMediaSample.decRef();
                return;
            }
            yYMediaSample.mDataBytes = this.mNV21.mData.array();
            yYMediaSample.mImageFormat = 0;
            yYMediaSample.mWidth = width;
            yYMediaSample.mHeight = height;
        } catch (Exception e) {
            YMFLog.error(this, TAG, "Exception: " + e.getMessage());
        }
    }

    private void replaceImage(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mMasterTextureId > 0 && yYMediaSample.mTextureTarget == 3553) {
            replaceTextrue(yYMediaSample);
        } else if (yYMediaSample.mImageFormat == 0) {
            replaceYUV(yYMediaSample);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample == null) {
            return false;
        }
        yYMediaSample.addRef();
        if (this.mReplaceBitmap != null) {
            replaceImage(yYMediaSample);
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[Preview ]", "setReplaceBitmap deInit... ");
        if (this.mBitmapTexture != null) {
            this.mBitmapTexture.release();
            this.mBitmapTexture = null;
        }
        if (this.mReplaceBitmap != null && !this.mReplaceBitmap.isRecycled()) {
            this.mReplaceBitmap.recycle();
        }
        this.mReplaceBitmap = null;
        this.mRotateAngle = 0;
        this.mBitmapChanged = false;
    }
}
