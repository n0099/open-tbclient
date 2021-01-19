package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pBE;

    public n(k<O> kVar) {
        this.pBE = kVar;
    }

    public k<O> exc() {
        return this.pBE;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.pBE.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void evD() {
        this.pBE.eqc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bK(float f) {
        this.pBE.aX(f);
    }
}
