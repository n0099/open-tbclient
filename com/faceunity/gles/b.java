package com.faceunity.gles;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes8.dex */
public class b {
    protected a pOr;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar) {
        this.pOr = aVar;
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.pOr.createWindowSurface(obj);
    }

    public void releaseEglSurface() {
        this.pOr.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void makeCurrent() {
        this.pOr.makeCurrent(this.mEGLSurface);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.pOr.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.pOr.setPresentationTime(this.mEGLSurface, j);
    }
}
