package com.facebook.imagepipeline.f;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pnj;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pnj = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pnj.esN().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pnj.esN().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pnj != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pnj;
                this.pnj = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pnj == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pnj.esN().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d evt() {
        return this.pnj;
    }
}
