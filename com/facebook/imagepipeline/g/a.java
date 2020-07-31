package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d ncG;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.ncG = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.ncG.dFy().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.ncG.dFy().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.ncG != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.ncG;
                this.ncG = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.ncG == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.ncG.dFy().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dIi() {
        return this.ncG;
    }
}
