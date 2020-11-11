package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d oWP;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.oWP = dVar;
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.oWP.ene().getWidth();
    }

    @Override // com.facebook.imagepipeline.g.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.oWP.ene().getHeight();
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.oWP != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.oWP;
                this.oWP = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.oWP == null;
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.oWP.ene().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d epP() {
        return this.oWP;
    }
}
