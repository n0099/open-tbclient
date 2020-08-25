package com.facebook.imagepipeline.g;
/* loaded from: classes3.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d nwy;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.nwy = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.nwy.dRy().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.nwy.dRy().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.nwy != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.nwy;
                this.nwy = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nwy == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.nwy.dRy().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d dUi() {
        return this.nwy;
    }
}
