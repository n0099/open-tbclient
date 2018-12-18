package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> iqb;

    public m(j<O> jVar) {
        this.iqb = jVar;
    }

    public j<O> bZd() {
        return this.iqb;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.iqb.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bXL() {
        this.iqb.bSY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.iqb.az(f);
    }
}
