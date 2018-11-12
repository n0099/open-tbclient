package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> iiP;

    public m(j<O> jVar) {
        this.iiP = jVar;
    }

    public j<O> bWY() {
        return this.iiP;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.iiP.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bVG() {
        this.iiP.bQT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.iiP.az(f);
    }
}
