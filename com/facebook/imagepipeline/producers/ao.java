package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al klb;
    private final j<T> klu;
    private final String kmG;
    private final String kmt;

    @Override // com.facebook.common.b.e
    protected abstract void aw(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.klu = jVar;
        this.klb = alVar;
        this.kmG = str;
        this.kmt = str2;
        this.klb.en(this.kmt, this.kmG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.klb.a(this.kmt, this.kmG, this.klb.GH(this.kmt) ? aV(t) : null);
        this.klu.f(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.klb.a(this.kmt, this.kmG, exc, this.klb.GH(this.kmt) ? o(exc) : null);
        this.klu.A(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cCH() {
        this.klb.b(this.kmt, this.kmG, this.klb.GH(this.kmt) ? cJr() : null);
        this.klu.cCH();
    }

    protected Map<String, String> aV(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cJr() {
        return null;
    }
}
