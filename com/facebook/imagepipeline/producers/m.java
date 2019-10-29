package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> klu;

    public m(j<O> jVar) {
        this.klu = jVar;
    }

    public j<O> cIU() {
        return this.klu;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void z(Throwable th) {
        this.klu.A(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cHB() {
        this.klu.cCH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aJ(float f) {
        this.klu.av(f);
    }
}
