package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> poX;

    public n(k<O> kVar) {
        this.poX = kVar;
    }

    public k<O> ewJ() {
        return this.poX;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.poX.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void evk() {
        this.poX.epN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void by(float f) {
        this.poX.aV(f);
    }
}
