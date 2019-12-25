package com.facebook.imagepipeline.producers;
/* loaded from: classes9.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> lQX;

    public n(k<O> kVar) {
        this.lQX = kVar;
    }

    public k<O> dpj() {
        return this.lQX;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void C(Throwable th) {
        this.lQX.D(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dnL() {
        this.lQX.dim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void bt(float f) {
        this.lQX.aM(f);
    }
}
