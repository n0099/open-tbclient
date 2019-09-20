package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> kni;

    public m(j<O> jVar) {
        this.kni = jVar;
    }

    public j<O> cLX() {
        return this.kni;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.kni.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cKE() {
        this.kni.cFJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bg(float f) {
        this.kni.aS(f);
    }
}
