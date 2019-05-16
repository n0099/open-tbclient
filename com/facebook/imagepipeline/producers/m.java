package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kcu;

    public m(j<O> jVar) {
        this.kcu = jVar;
    }

    public j<O> cHJ() {
        return this.kcu;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kcu.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cGr() {
        this.kcu.cBy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void be(float f) {
        this.kcu.aQ(f);
    }
}
