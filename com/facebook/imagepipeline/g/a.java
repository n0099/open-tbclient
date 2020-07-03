package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d mUC;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.mUC = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.mUC.dCi().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.mUC.dCi().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mUC != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.mUC;
                this.mUC = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mUC == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.mUC.dCi().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dES() {
        return this.mUC;
    }
}
