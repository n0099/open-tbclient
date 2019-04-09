package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> jJH;

    public m(j<O> jVar) {
        this.jJH = jVar;
    }

    public j<O> czN() {
        return this.jJH;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.jJH.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cyv() {
        this.jJH.ctB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void ba(float f) {
        this.jJH.aM(f);
    }
}
