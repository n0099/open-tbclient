package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d myv;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.myv = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.myv.dxG().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.myv.dxG().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.myv != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.myv;
                this.myv = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.myv == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.myv.dxG().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dAq() {
        return this.myv;
    }
}
