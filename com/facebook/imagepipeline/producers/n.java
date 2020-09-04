package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> nyB;

    public n(k<O> kVar) {
        this.nyB = kVar;
    }

    public k<O> dVJ() {
        return this.nyB;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.nyB.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dUi() {
        this.nyB.dOD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aS(float f) {
        this.nyB.aD(f);
    }
}
