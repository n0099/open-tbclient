package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mfb;

    public n(k<O> kVar) {
        this.mfb = kVar;
    }

    public k<O> duf() {
        return this.mfb;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mfb.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dsD() {
        this.mfb.dmV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aI(float f) {
        this.mfb.au(f);
    }
}
