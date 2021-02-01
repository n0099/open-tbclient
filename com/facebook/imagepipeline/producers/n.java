package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> pLM;

    public n(k<O> kVar) {
        this.pLM = kVar;
    }

    public k<O> ezu() {
        return this.pLM;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.pLM.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void exW() {
        this.pLM.esv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bN(float f) {
        this.pLM.ba(f);
    }
}
