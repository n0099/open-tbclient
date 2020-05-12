package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public abstract class n<I, O> extends b<I> {
    private final k<O> mff;

    public n(k<O> kVar) {
        this.mff = kVar;
    }

    public k<O> dud() {
        return this.mff;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void F(Throwable th) {
        this.mff.G(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void dsB() {
        this.mff.dmT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aI(float f) {
        this.mff.au(f);
    }
}
