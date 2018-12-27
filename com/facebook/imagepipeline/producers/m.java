package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> itl;

    public m(j<O> jVar) {
        this.itl = jVar;
    }

    public j<O> bZU() {
        return this.itl;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.itl.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bYC() {
        this.itl.bTP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.itl.az(f);
    }
}
