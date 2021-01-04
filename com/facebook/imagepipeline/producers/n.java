package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pEx;

    public n(k<O> kVar) {
        this.pEx = kVar;
    }

    public k<O> eAq() {
        return this.pEx;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.pEx.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void eyT() {
        this.pEx.etQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bK(float f) {
        this.pEx.aX(f);
    }
}
