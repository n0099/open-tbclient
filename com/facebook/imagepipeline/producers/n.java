package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mWn;

    public n(k<O> kVar) {
        this.mWn = kVar;
    }

    public k<O> dGk() {
        return this.mWn;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mWn.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dEJ() {
        this.mWn.dzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aN(float f) {
        this.mWn.ay(f);
    }
}
