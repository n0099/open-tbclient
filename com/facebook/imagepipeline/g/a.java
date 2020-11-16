package com.facebook.imagepipeline.g;
/* loaded from: classes10.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d oYs;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.oYs = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.oYs.enb().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.oYs.enb().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.oYs != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.oYs;
                this.oYs = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.oYs == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.oYs.enb().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d epN() {
        return this.oYs;
    }
}
