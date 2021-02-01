package com.yy.mediaframework.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes4.dex */
public interface IEglCore {
    IEglSurfaceBase createSurfaceBase();

    IWindowSurface createWindowSurface(SurfaceTexture surfaceTexture);

    IWindowSurface createWindowSurface(Surface surface, boolean z);

    IWindowSurface createWindowSurface(SurfaceHolder surfaceHolder, boolean z);

    Object getEGLContext();

    int getGlVersion();

    boolean isCurrent(IEglSurfaceBase iEglSurfaceBase);

    void makeCurrent(IEglSurfaceBase iEglSurfaceBase);

    void makeCurrent(IEglSurfaceBase iEglSurfaceBase, IEglSurfaceBase iEglSurfaceBase2);

    void makeNothingCurrent();

    int querySurface(IEglSurfaceBase iEglSurfaceBase, int i);

    void release();

    void setPresentationTime(IEglSurfaceBase iEglSurfaceBase, long j);

    boolean swapBuffers(IEglSurfaceBase iEglSurfaceBase);
}
