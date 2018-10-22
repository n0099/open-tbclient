package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> ihf;

    public m(j<O> jVar) {
        this.ihf = jVar;
    }

    public j<O> bXD() {
        return this.ihf;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void A(Throwable th) {
        this.ihf.B(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void bWl() {
        this.ihf.bRy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void aK(float f) {
        this.ihf.ax(f);
    }
}
