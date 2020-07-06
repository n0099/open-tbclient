package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mWq;

    public n(k<O> kVar) {
        this.mWq = kVar;
    }

    public k<O> dGo() {
        return this.mWq;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mWq.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dEN() {
        this.mWq.dzh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aN(float f) {
        this.mWq.ay(f);
    }
}
