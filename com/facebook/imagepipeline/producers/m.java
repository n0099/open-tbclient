package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kcv;

    public m(j<O> jVar) {
        this.kcv = jVar;
    }

    public j<O> cHL() {
        return this.kcv;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kcv.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cGt() {
        this.kcv.cBA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void be(float f) {
        this.kcv.aQ(f);
    }
}
