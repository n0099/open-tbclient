package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final j<T> kkL;
    private final al kks;
    private final String klK;
    private final String klX;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kkL = jVar;
        this.kks = alVar;
        this.klX = str;
        this.klK = str2;
        this.kks.eA(this.klK, this.klX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kks.a(this.klK, this.klX, this.kks.HQ(this.klK) ? ba(t) : null);
        this.kkL.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kks.a(this.klK, this.klX, exc, this.kks.HQ(this.klK) ? o(exc) : null);
        this.kkL.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cEV() {
        this.kks.b(this.klK, this.klX, this.kks.HQ(this.klK) ? cLG() : null);
        this.kkL.cEV();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cLG() {
        return null;
    }
}
