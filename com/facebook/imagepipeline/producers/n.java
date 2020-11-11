package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> oYA;

    public n(k<O> kVar) {
        this.oYA = kVar;
    }

    public k<O> erh() {
        return this.oYA;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void D(Throwable th) {
        this.oYA.E(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void epG() {
        this.oYA.ejZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void br(float f) {
        this.oYA.aN(f);
    }
}
