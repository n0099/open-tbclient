package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> myW;

    public n(k<O> kVar) {
        this.myW = kVar;
    }

    public k<O> dBu() {
        return this.myW;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.myW.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dzT() {
        this.myW.dum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aH(float f) {
        this.myW.at(f);
    }
}
