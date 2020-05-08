package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mff;

    public n(k<O> kVar) {
        this.mff = kVar;
    }

    public k<O> duc() {
        return this.mff;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mff.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dsA() {
        this.mff.dmS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aI(float f) {
        this.mff.au(f);
    }
}
