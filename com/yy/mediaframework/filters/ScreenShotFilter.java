package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.GLUtil;
/* loaded from: classes4.dex */
public class ScreenShotFilter extends AbstractYYMediaFilter {
    private static final String TAG = "ScreenShotFilter";
    private VideoLiveFilterContext mFilterContext;
    private int mOffScreenFrameBuffer = -1;
    private int mOffScreenTextureId = -1;
    private int mTextureWidth = 0;
    private int mTextureHeight = 0;
    private boolean mInited = false;

    public void init(int i, int i2) {
        if (!this.mInited) {
            initScreenShotGlEnv(i, i2);
            this.mInited = true;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        deInitScreenShotGlEnv();
    }

    private void initScreenShotGlEnv(int i, int i2) {
        this.mOffScreenTextureId = GLUtil.genTexture(3553, i, i2);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mOffScreenFrameBuffer = iArr[0];
        GLES20.glBindFramebuffer(36160, this.mOffScreenFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffScreenTextureId, 0);
    }

    private void deInitScreenShotGlEnv() {
        if (this.mOffScreenTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mOffScreenTextureId}, 0);
            this.mOffScreenTextureId = -1;
        }
        if (this.mOffScreenFrameBuffer > 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mOffScreenFrameBuffer}, 0);
            this.mOffScreenFrameBuffer = -1;
        }
    }

    public ScreenShotFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    private void takePreviewShot(YYMediaSample yYMediaSample, Object obj) {
        if (this.mOffScreenTextureId == -1 || this.mTextureWidth != yYMediaSample.mClipWidth || this.mTextureHeight != yYMediaSample.mClipHeight) {
            deInitScreenShotGlEnv();
            initScreenShotGlEnv(yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
            this.mTextureWidth = yYMediaSample.mClipWidth;
            this.mTextureHeight = yYMediaSample.mClipHeight;
        }
        if (this.mFilterContext.getScreenShot() != null && this.mFilterContext.getScreenShot().getScreenState()) {
            GLES20.glViewport(0, 0, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glBindFramebuffer(36160, this.mOffScreenFrameBuffer);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffScreenTextureId, 0);
            if (obj != null && (obj instanceof PreviewFilter)) {
                ((PreviewFilter) obj).drawVideo(yYMediaSample, false);
                this.mFilterContext.getScreenShot().takeScreenShot(yYMediaSample);
            }
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        takePreviewShot(yYMediaSample, obj);
        yYMediaSample.decRef();
        return false;
    }
}
