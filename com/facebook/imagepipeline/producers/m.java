package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kkL;

    public m(j<O> jVar) {
        this.kkL = jVar;
    }

    public j<O> cLj() {
        return this.kkL;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kkL.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cJQ() {
        this.kkL.cEV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bf(float f) {
        this.kkL.aR(f);
    }
}
