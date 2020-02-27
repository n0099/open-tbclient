package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lVx;

    public n(k<O> kVar) {
        this.lVx = kVar;
    }

    public k<O> drH() {
        return this.lVx;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.lVx.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dqf() {
        this.lVx.dkC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bs(float f) {
        this.lVx.aK(f);
    }
}
