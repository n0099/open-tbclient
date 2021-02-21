package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pMm;

    public n(k<O> kVar) {
        this.pMm = kVar;
    }

    public k<O> ezC() {
        return this.pMm;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.pMm.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void eye() {
        this.pMm.esD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bN(float f) {
        this.pMm.ba(f);
    }
}
