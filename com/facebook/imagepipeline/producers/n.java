package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pae;

    public n(k<O> kVar) {
        this.pae = kVar;
    }

    public k<O> erf() {
        return this.pae;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.pae.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void epE() {
        this.pae.ejX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void by(float f) {
        this.pae.aU(f);
    }
}
