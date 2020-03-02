package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lVz;

    public n(k<O> kVar) {
        this.lVz = kVar;
    }

    public k<O> drJ() {
        return this.lVz;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.lVz.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dqh() {
        this.lVz.dkE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bs(float f) {
        this.lVz.aK(f);
    }
}
