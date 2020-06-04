package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mAg;

    public n(k<O> kVar) {
        this.mAg = kVar;
    }

    public k<O> dBI() {
        return this.mAg;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mAg.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dAh() {
        this.mAg.duA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aH(float f) {
        this.mAg.at(f);
    }
}
