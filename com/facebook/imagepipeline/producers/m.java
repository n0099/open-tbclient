package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> ihe;

    public m(j<O> jVar) {
        this.ihe = jVar;
    }

    public j<O> bXD() {
        return this.ihe;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.ihe.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bWl() {
        this.ihe.bRy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aK(float f) {
        this.ihe.ax(f);
    }
}
