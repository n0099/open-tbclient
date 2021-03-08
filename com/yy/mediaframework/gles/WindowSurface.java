package com.yy.mediaframework.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
/* loaded from: classes6.dex */
public class WindowSurface extends EglSurfaceBase implements IWindowSurface {
    private boolean mReleaseSurface;
    private Surface mSurface;

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        createWindowSurface(surfaceTexture);
    }

    @Override // com.yy.mediaframework.gles.IWindowSurface
    public void release() {
        releaseEglSurface();
        if (this.mSurface != null) {
            if (this.mReleaseSurface) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
    }

    @Override // com.yy.mediaframework.gles.IWindowSurface
    public void recreate(Object obj) {
        if (obj instanceof EglCore) {
            if (this.mSurface == null) {
                throw new RuntimeException("not yet implemented for SurfaceTexture");
            }
            this.mEglCore = (EglCore) obj;
            createWindowSurface(this.mSurface);
            return;
        }
        throw new RuntimeException("newEglCore is not getInstance of EglCore");
    }
}
