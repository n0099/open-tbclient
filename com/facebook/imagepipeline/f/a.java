package com.facebook.imagepipeline.f;
/* loaded from: classes14.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pMG;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pMG = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pMG.evO().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pMG.evO().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pMG != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pMG;
                this.pMG = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pMG == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pMG.evO().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d eyw() {
        return this.pMG;
    }
}
