package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kkD;

    public m(j<O> jVar) {
        this.kkD = jVar;
    }

    public j<O> cIS() {
        return this.kkD;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kkD.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cHz() {
        this.kkD.cCF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aJ(float f) {
        this.kkD.av(f);
    }
}
