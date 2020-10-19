package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> nXP;

    public n(k<O> kVar) {
        this.nXP = kVar;
    }

    public k<O> eds() {
        return this.nXP;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.nXP.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void ebR() {
        this.nXP.dWm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aY(float f) {
        this.nXP.aJ(f);
    }
}
