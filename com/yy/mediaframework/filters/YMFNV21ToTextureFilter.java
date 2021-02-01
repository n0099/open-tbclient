package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.IRender;
import com.yy.mediaframework.opengles.YMFRender;
import com.yy.mediaframework.opengles.YMFTexture;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFNV21ToTextureFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFNV21ToTextureFilter";
    private int mCameraFacing;
    private VideoLiveFilterContext mFilterContext;
    private boolean mInited;
    private IRender mNv21Render;
    private int mRotateAngle;
    private YMFTexture mYuvTargetTexture;

    public YMFNV21ToTextureFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    private void init(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
        this.mNv21Render = new YMFRender(YMFRender.imageFormatToProgramType(i3));
        setRenderParam(i5, i4, i, i2);
        if (z) {
            this.mYuvTargetTexture = new YMFTexture(3553, i2, i, 6408, 33984);
        } else {
            this.mYuvTargetTexture = new YMFTexture(3553, i, i2, 6408, 33984);
        }
        this.mInited = true;
    }

    private void setRenderParam(int i, int i2, int i3, int i4) {
        int i5;
        if (i == 1) {
            i5 = (360 - i2) % EncoderTextureDrawer.X264_WIDTH;
        } else {
            i5 = i2 % EncoderTextureDrawer.X264_WIDTH;
        }
        this.mNv21Render.rotate(i5);
        this.mRotateAngle = i2;
        this.mCameraFacing = i;
        this.mNv21Render.flipReset();
        if (this.mFilterContext.isYuvTextureMode()) {
            if (i == 1) {
                this.mNv21Render.flipVertical();
                this.mNv21Render.flipHorizontal();
            }
            if (i == 0 && i2 == 90) {
                this.mNv21Render.flipHorizontal();
            }
            if (i == 0 && i2 == 0) {
                this.mNv21Render.flipVertical();
            }
        } else if (i == 1) {
            if (i3 > i4) {
                this.mNv21Render.flipVertical();
            } else {
                this.mNv21Render.flipHorizontal();
            }
        }
    }

    private void checkUpdate(YYMediaSample yYMediaSample) {
        if (this.mImageWidth != yYMediaSample.mWidth || this.mImageHeight != yYMediaSample.mHeight || this.mRotateAngle != yYMediaSample.mCameraRotate) {
            this.mImageWidth = yYMediaSample.mWidth;
            this.mImageHeight = yYMediaSample.mHeight;
            if (this.mYuvTargetTexture != null) {
                this.mYuvTargetTexture.release();
                this.mYuvTargetTexture = null;
            }
            if (yYMediaSample.mSwapWidthHeight) {
                this.mYuvTargetTexture = new YMFTexture(3553, this.mImageHeight, this.mImageWidth, 6408, 33984);
            } else {
                this.mYuvTargetTexture = new YMFTexture(3553, this.mImageWidth, this.mImageHeight, 6408, 33984);
            }
        }
        if (this.mCameraFacing != yYMediaSample.mCameraFacing || this.mRotateAngle != yYMediaSample.mCameraRotate) {
            setRenderParam(yYMediaSample.mCameraFacing, yYMediaSample.mCameraRotate, yYMediaSample.mWidth, yYMediaSample.mHeight);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (!this.mInited) {
            init(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mImageFormat, yYMediaSample.mCameraRotate, yYMediaSample.mCameraFacing, yYMediaSample.mSwapWidthHeight);
        }
        checkUpdate(yYMediaSample);
        if (renderNv21ToTexture(yYMediaSample)) {
            deliverToDownStream(yYMediaSample);
        }
        yYMediaSample.decRef();
        return true;
    }

    private boolean renderNv21ToTexture(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mDataBytes == null || yYMediaSample.mImageFormat != 0) {
            YMFLog.error(this, "[Preproce]", " need NV21 input. ");
            return false;
        }
        GlUtil.checkGlError("YMFNV21ToTextureFilter renderNv21ToTexture enter ");
        if (yYMediaSample.mSwapWidthHeight) {
            GLES20.glViewport(0, 0, yYMediaSample.mHeight, yYMediaSample.mWidth);
        } else {
            GLES20.glViewport(0, 0, yYMediaSample.mWidth, yYMediaSample.mHeight);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.mNv21Render.prepareInputImageData(yYMediaSample.mNv21Buffer) && this.mNv21Render.prepareOutputTexture(this.mYuvTargetTexture)) {
            if (yYMediaSample.mCameraNV21DataUsed != null) {
                yYMediaSample.mCameraNV21DataUsed.set(true);
            }
            this.mNv21Render.render();
            yYMediaSample.mMasterTextureId = this.mYuvTargetTexture.getTextureId();
            yYMediaSample.mTextureTarget = 3553;
            yYMediaSample.mImageFormat = 69;
            Matrix.setIdentityM(yYMediaSample.mMainTransformer, 0);
            if (yYMediaSample.mSwapWidthHeight) {
                yYMediaSample.mWidth = yYMediaSample.mNv21Buffer.mHeight;
                yYMediaSample.mHeight = yYMediaSample.mNv21Buffer.mWidth;
                int i = yYMediaSample.mClipWidth;
                yYMediaSample.mClipWidth = yYMediaSample.mClipHeight;
                yYMediaSample.mClipHeight = i;
                yYMediaSample.mSwapWidthHeight = false;
            }
        }
        GlUtil.checkGlError("YMFNV21ToTextureFilter renderNv21ToTexture out");
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[Preproce]", "deInit start.");
        super.deInit();
        if (this.mYuvTargetTexture != null) {
            this.mYuvTargetTexture.release();
            this.mYuvTargetTexture = null;
        }
        if (this.mNv21Render != null) {
            this.mNv21Render.release();
        }
        YMFLog.info(this, "[Preproce]", "deInit done.");
    }
}
