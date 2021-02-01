package com.yy.mediaframework.opengles;

import android.opengl.GLES20;
/* loaded from: classes4.dex */
public class YMFFramebuffer {
    private int[] mFrameBuffers = new int[1];

    public YMFFramebuffer() {
        GLES20.glGenFramebuffers(1, this.mFrameBuffers, 0);
    }

    public void attachTexture(int i) {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
    }

    public void unAttachTexture() {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
    }

    public void bind() {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
    }

    public void unBind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void release() {
        if (this.mFrameBuffers != null) {
            GLES20.glDeleteFramebuffers(1, this.mFrameBuffers, 0);
            this.mFrameBuffers[0] = -1;
        }
    }
}
