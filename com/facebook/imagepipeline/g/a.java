package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d mUF;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.mUF = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.mUF.dCm().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.mUF.dCm().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mUF != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.mUF;
                this.mUF = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mUF == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.mUF.dCm().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dEW() {
        return this.mUF;
    }
}
