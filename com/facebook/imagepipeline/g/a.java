package com.facebook.imagepipeline.g;
/* loaded from: classes11.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d lPo;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.lPo = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.lPo.dll().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.lPo.dll().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.lPo != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.lPo;
                this.lPo = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lPo == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.lPo.dll().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dnU() {
        return this.lPo;
    }
}
