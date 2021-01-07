package com.facebook.imagepipeline.f;
/* loaded from: classes5.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pEt;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pEt = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pEt.ewX().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pEt.ewX().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pEt != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pEt;
                this.pEt = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pEt == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pEt.ewX().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d ezE() {
        return this.pEt;
    }
}
