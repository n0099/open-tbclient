package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d mxl;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.mxl = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.mxl.dxs().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.mxl.dxs().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mxl != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.mxl;
                this.mxl = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mxl == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.mxl.dxs().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dAc() {
        return this.mxl;
    }
}
