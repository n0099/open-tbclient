package com.facebook.imagepipeline.f;
/* loaded from: classes3.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pKB;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pKB = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pKB.evF().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pKB.evF().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pKB != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pKB;
                this.pKB = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pKB == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pKB.evF().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d eyn() {
        return this.pKB;
    }
}
