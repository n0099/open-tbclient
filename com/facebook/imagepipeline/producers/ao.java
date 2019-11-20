package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final j<T> kkD;
    private final al kkk;
    private final String klC;
    private final String klP;

    @Override // com.facebook.common.b.e
    protected abstract void aw(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kkD = jVar;
        this.kkk = alVar;
        this.klP = str;
        this.klC = str2;
        this.kkk.en(this.klC, this.klP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kkk.a(this.klC, this.klP, this.kkk.GH(this.klC) ? aV(t) : null);
        this.kkD.f(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kkk.a(this.klC, this.klP, exc, this.kkk.GH(this.klC) ? n(exc) : null);
        this.kkD.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cCF() {
        this.kkk.b(this.klC, this.klP, this.kkk.GH(this.klC) ? cJp() : null);
        this.kkD.cCF();
    }

    protected Map<String, String> aV(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> cJp() {
        return null;
    }
}
