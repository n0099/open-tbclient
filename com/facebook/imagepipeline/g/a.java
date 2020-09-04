package com.facebook.imagepipeline.g;
/* loaded from: classes3.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d nwQ;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.nwQ = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.nwQ.dRH().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.nwQ.dRH().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.nwQ != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.nwQ;
                this.nwQ = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nwQ == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.nwQ.dRH().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dUr() {
        return this.nwQ;
    }
}
