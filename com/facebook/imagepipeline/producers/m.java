package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> jKu;

    public m(j<O> jVar) {
        this.jKu = jVar;
    }

    public j<O> czR() {
        return this.jKu;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.jKu.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cyz() {
        this.jKu.ctF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void ba(float f) {
        this.jKu.aM(f);
    }
}
