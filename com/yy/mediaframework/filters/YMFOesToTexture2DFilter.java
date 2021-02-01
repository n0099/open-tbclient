package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.IRender;
import com.yy.mediaframework.opengles.YMFRender;
import com.yy.mediaframework.opengles.YMFTexture;
/* loaded from: classes4.dex */
public class YMFOesToTexture2DFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFOesToTexture2DFilter";
    private VideoLiveFilterContext mFilterContext;
    private boolean mInited;
    private YMFTexture mOutputTexture;
    private IRender mRender;

    public YMFOesToTexture2DFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    private void init() {
        if (this.mRender == null) {
            this.mRender = new YMFRender(4);
            this.mRender.flipVertical();
        }
        this.mInited = true;
    }

    private void checkUpdate(YYMediaSample yYMediaSample) {
        if (this.mOutputTexture == null || this.mOutputTexture.getWidth() != yYMediaSample.mWidth || this.mOutputTexture.getHeight() != yYMediaSample.mHeight) {
            if (this.mOutputTexture != null) {
                this.mOutputTexture.release();
                this.mOutputTexture = null;
            }
            this.mOutputTexture = new YMFTexture(3553, yYMediaSample.mWidth, yYMediaSample.mHeight, 6408, 33984);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample == null || yYMediaSample.mImageFormat != 70) {
            return false;
        }
        GlUtil.checkGlError("YMFOesToTexture2DFilter enter");
        yYMediaSample.addRef();
        if (!this.mInited) {
            init();
        }
        checkUpdate(yYMediaSample);
        GLES20.glViewport(0, 0, yYMediaSample.mWidth, yYMediaSample.mHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        YMFTexture yMFTexture = new YMFTexture(yYMediaSample.mMasterTextureId, 36197, yYMediaSample.mWidth, yYMediaSample.mHeight, 6408, 33984);
        this.mRender.prepareInputTextureTransformMatrix(yYMediaSample.mMainTransformer);
        if (this.mRender.prepareInputTexture(yMFTexture) && this.mRender.prepareOutputTexture(this.mOutputTexture)) {
            this.mRender.render();
            yYMediaSample.mMasterTextureId = this.mOutputTexture.getTextureId();
            yYMediaSample.mImageFormat = 69;
            yYMediaSample.mTextureTarget = 3553;
            Matrix.setIdentityM(yYMediaSample.mMainTransformer, 0);
            if (this.mFilterContext.isUseYuvCapture() && yYMediaSample.mCameraFacing == 1) {
                yYMediaSample.mIsPreviewMirrorEnable = !yYMediaSample.mIsPreviewMirrorEnable;
            }
        }
        GlUtil.checkGlError("YMFOesToTexture2DFilter out");
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
        if (this.mRender != null) {
            this.mRender.release();
            this.mRender = null;
        }
        if (this.mOutputTexture != null) {
            this.mOutputTexture.release();
            this.mOutputTexture = null;
        }
    }
}
