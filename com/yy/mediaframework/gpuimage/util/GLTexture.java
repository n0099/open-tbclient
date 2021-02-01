package com.yy.mediaframework.gpuimage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
/* loaded from: classes4.dex */
public class GLTexture {
    private int mTarget;
    private int mTextureID = -1;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mFormat = 6408;

    public GLTexture(int i) {
        this.mTarget = 3553;
        this.mTarget = i;
    }

    public void create(int i, int i2, int i3) {
        destory();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureID = iArr[0];
        GLES20.glBindTexture(this.mTarget, this.mTextureID);
        GLES20.glTexParameteri(this.mTarget, 10242, 33071);
        GLES20.glTexParameteri(this.mTarget, 10243, 33071);
        GLES20.glTexParameteri(this.mTarget, 10241, 9729);
        GLES20.glTexParameteri(this.mTarget, 10240, 9729);
        GLES20.glTexImage2D(this.mTarget, 0, i3, i, i2, 0, i3, 5121, null);
        this.mWidth = i;
        this.mHeight = i2;
        this.mFormat = i3;
    }

    public void destory() {
        if (this.mTextureID != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureID}, 0);
            this.mTextureID = -1;
            this.mHeight = 0;
            this.mWidth = 0;
        }
    }

    public void loadTextures(Context context, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        this.mWidth = decodeResource.getWidth();
        this.mHeight = decodeResource.getHeight();
        GLES20.glBindTexture(3553, this.mTextureID);
        GLUtils.texImage2D(3553, 0, decodeResource, 0);
        GLES20.glBindTexture(this.mTarget, this.mTextureID);
        GLES20.glTexParameteri(this.mTarget, 10242, 33071);
        GLES20.glTexParameteri(this.mTarget, 10243, 33071);
        GLES20.glTexParameteri(this.mTarget, 10241, 9729);
        GLES20.glTexParameteri(this.mTarget, 10240, 9729);
    }

    public void bindFBO(int i) {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glBindTexture(this.mTarget, this.mTextureID);
        GLES20.glFramebufferTexture2D(36160, 36064, this.mTarget, this.mTextureID, 0);
    }

    public int getTarget() {
        return this.mTarget;
    }

    public int getTextureId() {
        return this.mTextureID;
    }

    public void setTextureId(int i) {
        this.mTextureID = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
