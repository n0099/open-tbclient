package com.yy.mediaframework.opengles;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
/* loaded from: classes4.dex */
public class YMFTexture {
    private int mFormat;
    private int mHeight;
    private int mTarget;
    private int mTextureId;
    private int mTextureUnit;
    private int mWidth;

    public YMFTexture(int i, int i2, int i3, int i4, int i5) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mFormat = i4;
        this.mTarget = i;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureId = iArr[0];
        this.mTextureUnit = i5;
        GLES20.glActiveTexture(i5);
        GLES20.glBindTexture(i, this.mTextureId);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        GLES20.glTexParameteri(i, 10241, 9729);
        GLES20.glTexParameteri(i, 10240, 9729);
        GLES20.glTexImage2D(i, 0, i4, i2, i3, 0, i4, 5121, null);
    }

    public YMFTexture(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mWidth = i3;
        this.mHeight = i4;
        this.mFormat = i5;
        this.mTarget = i2;
        this.mTextureUnit = i6;
        if (i == -1) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.mTextureId = iArr[0];
            return;
        }
        this.mTextureId = i;
    }

    public YMFTexture(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mFormat = i4;
        this.mTarget = i;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureId = iArr[0];
        this.mTextureUnit = i5;
        GLES20.glActiveTexture(i5);
        GLES20.glBindTexture(i, this.mTextureId);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
    }

    public void setTextureUnit(int i) {
        this.mTextureUnit = i;
    }

    public void bind() {
        GLES20.glActiveTexture(this.mTextureUnit);
        GLES20.glBindTexture(this.mTarget, this.mTextureId);
    }

    public void unBind() {
        GLES20.glActiveTexture(this.mTextureUnit);
        GLES20.glBindTexture(this.mTarget, 0);
    }

    public void updateTextureData(Buffer buffer, int i, int i2) {
        if (buffer != null && i == this.mWidth && i2 == this.mHeight) {
            if ((i & 3) != 0) {
                GLES20.glPixelStorei(3317, 1);
            } else {
                GLES20.glPixelStorei(3317, 4);
            }
            GLES20.glActiveTexture(this.mTextureUnit);
            GLES20.glBindTexture(this.mTarget, this.mTextureId);
            GLES20.glTexSubImage2D(this.mTarget, 0, 0, 0, this.mWidth, this.mHeight, this.mFormat, 5121, buffer);
        }
    }

    public void updateTextureData(Bitmap bitmap) {
        if (bitmap != null) {
            GLES20.glActiveTexture(this.mTextureUnit);
            GLES20.glBindTexture(this.mTarget, this.mTextureId);
            GLUtils.texSubImage2D(this.mTarget, 0, 0, 0, bitmap, 6408, 5121);
        }
    }

    public void release() {
        if (this.mTextureId != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
            this.mTextureId = -1;
            this.mHeight = 0;
            this.mWidth = 0;
        }
    }

    public boolean validate() {
        return this.mTextureId > 0 && this.mWidth > 0 && this.mHeight > 0;
    }

    public int getTarget() {
        return this.mTarget;
    }

    public int getTextureId() {
        return this.mTextureId;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getFormat() {
        return this.mFormat;
    }
}
