package com.facebook.imagepipeline.f;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pnh;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pnh = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pnh.esM().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pnh.esM().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pnh != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pnh;
                this.pnh = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pnh == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pnh.esM().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d evs() {
        return this.pnh;
    }
}
