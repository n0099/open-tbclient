package com.facebook.imagepipeline.f;
/* loaded from: classes5.dex */
public class a extends c {
    private com.facebook.imagepipeline.animated.base.d pzT;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this.pzT = dVar;
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.pzT.etf().getWidth();
    }

    @Override // com.facebook.imagepipeline.f.f
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.pzT.etf().getHeight();
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.pzT != null) {
                com.facebook.imagepipeline.animated.base.d dVar = this.pzT;
                this.pzT = null;
                dVar.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pzT == null;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.pzT.etf().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.f.c
    public boolean isStateful() {
        return true;
    }

    public synchronized com.facebook.imagepipeline.animated.base.d evM() {
        return this.pzT;
    }
}
