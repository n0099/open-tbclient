package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kjF;

    public m(j<O> jVar) {
        this.kjF = jVar;
    }

    public j<O> cKO() {
        return this.kjF;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kjF.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cJv() {
        this.kjF.cEA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bf(float f) {
        this.kjF.aR(f);
    }
}
