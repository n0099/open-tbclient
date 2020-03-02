package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d lTO;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.lTO = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.lTO.dnH().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.lTO.dnH().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.lTO != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.lTO;
                this.lTO = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTO == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.lTO.dnH().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dqq() {
        return this.lTO;
    }
}
