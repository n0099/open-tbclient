package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> ner;

    public n(k<O> kVar) {
        this.ner = kVar;
    }

    public k<O> dJA() {
        return this.ner;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void E(Throwable th) {
        this.ner.F(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dHZ() {
        this.ner.dCt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.ner.ax(f);
    }
}
