package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lXq;

    public n(k<O> kVar) {
        this.lXq = kVar;
    }

    public k<O> dsh() {
        return this.lXq;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.lXq.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dqF() {
        this.lXq.dlc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bs(float f) {
        this.lXq.aK(f);
    }
}
