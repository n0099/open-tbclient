package com.facebook.imagepipeline.f;
/* loaded from: classes3.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pKb;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pKb = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pKb.evx().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pKb.evx().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pKb != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pKb;
                this.pKb = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pKb == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pKb.evx().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d eyf() {
        return this.pKb;
    }
}
