package com.yy.mediaframework.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes4.dex */
public class WindowSurfaceKhronos extends EglSurfaceBaseKhronos implements IWindowSurface {
    private boolean mReleaseSurface;
    private SurfaceHolder mSurfaceHolder;

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSurfaceKhronos(EglCoreKhronos eglCoreKhronos, SurfaceHolder surfaceHolder, boolean z) {
        super(eglCoreKhronos);
        createWindowSurface(surfaceHolder);
        this.mSurfaceHolder = surfaceHolder;
        this.mReleaseSurface = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSurfaceKhronos(EglCoreKhronos eglCoreKhronos, SurfaceTexture surfaceTexture) {
        super(eglCoreKhronos);
        createWindowSurface(surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSurfaceKhronos(EglCoreKhronos eglCoreKhronos, Surface surface) {
        super(eglCoreKhronos);
        createWindowSurface(surface);
    }

    @Override // com.yy.mediaframework.gles.IWindowSurface
    public void release() {
        releaseEglSurface();
        if (this.mSurfaceHolder != null) {
            if (this.mReleaseSurface) {
                this.mSurfaceHolder.getSurface().release();
            }
            this.mSurfaceHolder = null;
        }
    }

    @Override // com.yy.mediaframework.gles.IWindowSurface
    public void recreate(Object obj) {
        if (obj instanceof EglCoreKhronos) {
            if (this.mSurfaceHolder == null) {
                throw new RuntimeException("not yet implemented for SurfaceTexture");
            }
            this.mEglCore = (EglCoreKhronos) obj;
            createWindowSurface(this.mSurfaceHolder);
            return;
        }
        throw new RuntimeException("newEglCore is not getInstance of EglCoreKhronos");
    }
}
