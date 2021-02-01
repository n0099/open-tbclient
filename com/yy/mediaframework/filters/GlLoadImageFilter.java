package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.GLUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.Buffer;
/* loaded from: classes4.dex */
public class GlLoadImageFilter extends AbstractYYMediaFilter {
    private boolean mbPBOSupport = false;
    private boolean mInited = false;
    private int mTextureId = -1;

    private void init(int i, int i2, Buffer buffer) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
        YMFLog.info(this, "[Util    ]", "GlLoadImageFilter init");
        this.mTextureId = GLUtil.genTexture(3553, this.mImageWidth, this.mImageHeight);
        GLES20.glBindTexture(3553, this.mTextureId);
        GLES20.glTexImage2D(3553, 0, 6408, this.mImageWidth, this.mImageHeight, 0, 6408, 5121, buffer);
        GLES20.glBindTexture(3553, 0);
        this.mInited = true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[Util    ]", "GlLoadImageFilter deInit");
        if (this.mTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
            this.mTextureId = -1;
        }
        this.mInited = false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample.mDataByteBuffer != null && yYMediaSample.mDataByteBuffer.remaining() != 0) {
            if (yYMediaSample.mWidth != this.mImageWidth || yYMediaSample.mHeight != this.mImageHeight) {
                YMFLog.info(this, "[Util    ]", "GlLoadImageFilter image size update, origWidth:" + this.mImageWidth + " origHeight:" + this.mImageHeight + " newWidth:" + yYMediaSample.mWidth + " newHeight:" + yYMediaSample.mHeight + " imageDataSize:" + yYMediaSample.mDataByteBuffer.remaining());
                this.mImageWidth = yYMediaSample.mWidth;
                this.mImageHeight = yYMediaSample.mHeight;
                deInit();
                init(this.mImageWidth, this.mImageHeight, yYMediaSample.mDataByteBuffer);
            } else if (!this.mbPBOSupport) {
                GLES20.glBindTexture(3553, this.mTextureId);
                GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mImageWidth, this.mImageHeight, 6408, 5121, yYMediaSample.mDataByteBuffer);
                GLES20.glBindTexture(3553, 0);
            }
            yYMediaSample.mMasterTextureId = this.mTextureId;
            yYMediaSample.mTextureTarget = 3553;
            System.arraycopy(Constant.mtxIdentity, 0, yYMediaSample.mMainTransformer, 0, yYMediaSample.mMainTransformer.length);
            yYMediaSample.mDataByteBuffer = null;
            deliverToDownStream(yYMediaSample);
        }
        return false;
    }
}
