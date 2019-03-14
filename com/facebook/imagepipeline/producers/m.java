package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> jKm;

    public m(j<O> jVar) {
        this.jKm = jVar;
    }

    public j<O> czU() {
        return this.jKm;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.jKm.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cyC() {
        this.jKm.ctI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void ba(float f) {
        this.jKm.aM(f);
    }
}
