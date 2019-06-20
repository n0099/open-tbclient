package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kcy;

    public m(j<O> jVar) {
        this.kcy = jVar;
    }

    public j<O> cHK() {
        return this.kcy;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kcy.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cGs() {
        this.kcy.cBz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void be(float f) {
        this.kcy.aQ(f);
    }
}
