package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lUQ;

    public n(k<O> kVar) {
        this.lUQ = kVar;
    }

    public k<O> dqv() {
        return this.lUQ;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.lUQ.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void doT() {
        this.lUQ.djp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bt(float f) {
        this.lUQ.aL(f);
    }
}
