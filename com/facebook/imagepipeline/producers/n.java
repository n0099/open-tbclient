package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> poV;

    public n(k<O> kVar) {
        this.poV = kVar;
    }

    public k<O> ewI() {
        return this.poV;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.poV.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void evj() {
        this.poV.epM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void by(float f) {
        this.poV.aV(f);
    }
}
