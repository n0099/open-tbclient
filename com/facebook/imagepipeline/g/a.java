package com.facebook.imagepipeline.g;
/* loaded from: classes6.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d nGN;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.nGN = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.nGN.dVF().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.nGN.dVF().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.nGN != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.nGN;
                this.nGN = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nGN == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.nGN.dVF().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dYp() {
        return this.nGN;
    }
}
