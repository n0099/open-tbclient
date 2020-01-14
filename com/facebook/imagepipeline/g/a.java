package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d lTf;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.lTf = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.lTf.dms().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.lTf.dms().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.lTf != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.lTf;
                this.lTf = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTf == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.lTf.dms().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dpc() {
        return this.lTf;
    }
}
