package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes3.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> pBE;
    private final am pBi;
    private final String pCQ;

    @Override // com.facebook.common.b.h
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pBE = kVar;
        this.pBi = amVar;
        this.pCQ = str;
        this.mRequestId = str2;
        this.pBi.hm(this.mRequestId, this.pCQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pBi.b(this.mRequestId, this.pCQ, this.pBi.Yt(this.mRequestId) ? bA(t) : null);
        this.pBE.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pBi.a(this.mRequestId, this.pCQ, exc, this.pBi.Yt(this.mRequestId) ? D(exc) : null);
        this.pBE.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void eqc() {
        this.pBi.c(this.mRequestId, this.pCQ, this.pBi.Yt(this.mRequestId) ? exC() : null);
        this.pBE.eqc();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> exC() {
        return null;
    }
}
