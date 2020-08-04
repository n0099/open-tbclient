package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d ncI;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.ncI = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.ncI.dFz().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.ncI.dFz().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.ncI != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.ncI;
                this.ncI = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.ncI == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.ncI.dFz().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dIj() {
        return this.ncI;
    }
}
