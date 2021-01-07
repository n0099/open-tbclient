package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pGe;

    public n(k<O> kVar) {
        this.pGe = kVar;
    }

    public k<O> eAU() {
        return this.pGe;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.pGe.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void ezv() {
        this.pGe.etW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bK(float f) {
        this.pGe.aX(f);
    }
}
