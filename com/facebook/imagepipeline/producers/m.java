package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> jJG;

    public m(j<O> jVar) {
        this.jJG = jVar;
    }

    public j<O> czN() {
        return this.jJG;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.jJG.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cyv() {
        this.jJG.ctB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void ba(float f) {
        this.jJG.aM(f);
    }
}
