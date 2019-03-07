package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public abstract class m<I, O> extends b<I> {
    private final j<O> jKb;

    public m(j<O> jVar) {
        this.jKb = jVar;
    }

    public j<O> czH() {
        return this.jKb;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void B(Throwable th) {
        this.jKb.C(th);
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void cyp() {
        this.jKb.ctv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void ba(float f) {
        this.jKb.aM(f);
    }
}
