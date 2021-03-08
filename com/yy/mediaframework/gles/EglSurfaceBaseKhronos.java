package com.yy.mediaframework.gles;

import com.yy.mediaframework.utils.YMFLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes6.dex */
public class EglSurfaceBaseKhronos implements IEglSurfaceBase {
    protected static final String TAG = "GlUtil";
    protected EglCoreKhronos mEglCore;
    protected EGLSurface mEGLSurface = EGL10.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglSurfaceBaseKhronos(EglCoreKhronos eglCoreKhronos) {
        this.mEglCore = eglCoreKhronos;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL10.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void createOffscreenSurface(int i, int i2) {
        if (this.mEGLSurface != EGL10.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public int getWidth() {
        return this.mWidth < 0 ? this.mEglCore._querySurface(this.mEGLSurface, 12375) : this.mWidth;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public int getHeight() {
        return this.mHeight < 0 ? this.mEglCore._querySurface(this.mEGLSurface, 12374) : this.mHeight;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL10.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void makeCurrent() {
        this.mEglCore._makeCurrent(this.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public boolean isCurrent() {
        return this.mEglCore._isCurrent(this.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void makeCurrentReadFrom(Object obj) {
        if (obj instanceof EglSurfaceBaseKhronos) {
            this.mEglCore._makeCurrent(this.mEGLSurface, ((EglSurfaceBaseKhronos) obj).mEGLSurface);
            return;
        }
        throw new RuntimeException("makeCurrentReadFrom readSurface is not getInstance of  EglSurfaceBaseKhronos");
    }

    private void makeCurrentReadFrom(EglSurfaceBaseKhronos eglSurfaceBaseKhronos) {
        this.mEglCore._makeCurrent(this.mEGLSurface, eglSurfaceBaseKhronos.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public boolean swapBuffers() {
        boolean _swapBuffers = this.mEglCore._swapBuffers(this.mEGLSurface);
        if (!_swapBuffers) {
            YMFLog.debug(this, "[Util    ]", "WARNING: swapBuffers() failed");
        }
        return _swapBuffers;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void setPresentationTime(long j) {
    }

    public EGLSurface getEGLSurface() {
        return this.mEGLSurface;
    }
}
