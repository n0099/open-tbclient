package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> ius;

    public m(j<O> jVar) {
        this.ius = jVar;
    }

    public j<O> caC() {
        return this.ius;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.ius.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bZk() {
        this.ius.bUx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.ius.az(f);
    }
}
