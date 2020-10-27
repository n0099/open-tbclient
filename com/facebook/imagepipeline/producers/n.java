package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> oPh;

    public n(k<O> kVar) {
        this.oPh = kVar;
    }

    public k<O> enr() {
        return this.oPh;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.oPh.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void elP() {
        this.oPh.egk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bp(float f) {
        this.oPh.aL(f);
    }
}
