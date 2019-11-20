package com.faceunity.gles;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
import com.baidu.ala.liveRecorder.video.gles.GlUtil;
/* loaded from: classes5.dex */
public class b {
    protected a kmI;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar) {
        this.kmI = aVar;
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.kmI.createWindowSurface(obj);
    }

    public void releaseEglSurface() {
        this.kmI.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void makeCurrent() {
        this.kmI.makeCurrent(this.mEGLSurface);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.kmI.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            Log.d(GlUtil.TAG, "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.kmI.setPresentationTime(this.mEGLSurface, j);
    }
}
