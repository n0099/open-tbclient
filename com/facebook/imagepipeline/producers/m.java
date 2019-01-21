package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> iut;

    public m(j<O> jVar) {
        this.iut = jVar;
    }

    public j<O> caC() {
        return this.iut;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.iut.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bZk() {
        this.iut.bUx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.iut.az(f);
    }
}
