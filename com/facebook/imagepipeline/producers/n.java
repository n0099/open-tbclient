package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lVK;

    public n(k<O> kVar) {
        this.lVK = kVar;
    }

    public k<O> drK() {
        return this.lVK;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.lVK.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dqi() {
        this.lVK.dkF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bs(float f) {
        this.lVK.aK(f);
    }
}
