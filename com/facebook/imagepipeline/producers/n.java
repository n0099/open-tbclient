package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lUL;

    public n(k<O> kVar) {
        this.lUL = kVar;
    }

    public k<O> dqt() {
        return this.lUL;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.lUL.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void doR() {
        this.lUL.djn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bt(float f) {
        this.lUL.aL(f);
    }
}
