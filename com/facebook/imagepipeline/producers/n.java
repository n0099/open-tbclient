package com.facebook.imagepipeline.producers;
/* loaded from: classes25.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> nIy;

    public n(k<O> kVar) {
        this.nIy = kVar;
    }

    public k<O> dZH() {
        return this.nIy;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.nIy.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dYg() {
        this.nIy.dSB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aS(float f) {
        this.nIy.aD(f);
    }
}
