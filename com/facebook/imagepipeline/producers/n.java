package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> neu;

    public n(k<O> kVar) {
        this.neu = kVar;
    }

    public k<O> dJB() {
        return this.neu;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void E(Throwable th) {
        this.neu.F(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dIa() {
        this.neu.dCu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aM(float f) {
        this.neu.ax(f);
    }
}
