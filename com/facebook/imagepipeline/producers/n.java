package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pBD;

    public n(k<O> kVar) {
        this.pBD = kVar;
    }

    public k<O> exc() {
        return this.pBD;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.pBD.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void evD() {
        this.pBD.eqc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bK(float f) {
        this.pBD.aX(f);
    }
}
