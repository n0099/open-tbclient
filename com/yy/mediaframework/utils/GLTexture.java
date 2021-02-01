package com.yy.mediaframework.utils;

import android.opengl.GLES20;
/* loaded from: classes4.dex */
public class GLTexture {
    private int mTarget = -1;
    private int mTextureHandle;

    public int getTextureId() {
        return this.mTextureHandle;
    }

    public void init(int i) {
        this.mTarget = i;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureHandle = iArr[0];
        GLES20.glBindTexture(this.mTarget, iArr[0]);
        GLES20.glTexParameteri(this.mTarget, 10242, 33071);
        GLES20.glTexParameteri(this.mTarget, 10243, 33071);
        GLES20.glTexParameteri(this.mTarget, 10241, 9729);
        GLES20.glTexParameteri(this.mTarget, 10240, 9729);
    }

    public void destroy() {
        if (this.mTarget >= 0) {
            int[] iArr = {this.mTarget};
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
        }
        this.mTarget = -1;
    }
}
