package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes5.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am pLQ;
    private final k<T> pMm;
    private final String pNy;

    @Override // com.facebook.common.b.h
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pMm = kVar;
        this.pLQ = amVar;
        this.pNy = str;
        this.mRequestId = str2;
        this.pLQ.hv(this.mRequestId, this.pNy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pLQ.b(this.mRequestId, this.pNy, this.pLQ.ZG(this.mRequestId) ? bA(t) : null);
        this.pMm.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pLQ.a(this.mRequestId, this.pNy, exc, this.pLQ.ZG(this.mRequestId) ? D(exc) : null);
        this.pMm.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void esD() {
        this.pLQ.c(this.mRequestId, this.pNy, this.pLQ.ZG(this.mRequestId) ? eAc() : null);
        this.pMm.esD();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> eAc() {
        return null;
    }
}
