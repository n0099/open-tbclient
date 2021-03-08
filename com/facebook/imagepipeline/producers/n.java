package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pOr;

    public n(k<O> kVar) {
        this.pOr = kVar;
    }

    public k<O> ezL() {
        return this.pOr;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.pOr.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void eyn() {
        this.pOr.esM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bR(float f) {
        this.pOr.be(f);
    }
}
