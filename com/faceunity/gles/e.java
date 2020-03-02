package com.faceunity.gles;

import android.view.Surface;
/* loaded from: classes10.dex */
public class e extends b {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    public void release() {
        releaseEglSurface();
        if (this.mSurface != null) {
            if (this.mReleaseSurface) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
    }

    public void a(a aVar) {
        if (this.mSurface == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.lXG = aVar;
        createWindowSurface(this.mSurface);
    }
}
