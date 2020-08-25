package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> nyj;

    public n(k<O> kVar) {
        this.nyj = kVar;
    }

    public k<O> dVA() {
        return this.nyj;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.nyj.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dTZ() {
        this.nyj.dOu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aS(float f) {
        this.nyj.aD(f);
    }
}
