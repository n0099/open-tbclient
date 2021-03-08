package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes5.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am pNV;
    private final k<T> pOr;
    private final String pPD;

    @Override // com.facebook.common.b.h
    protected abstract void bc(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pOr = kVar;
        this.pNV = amVar;
        this.pPD = str;
        this.mRequestId = str2;
        this.pNV.hv(this.mRequestId, this.pPD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pNV.b(this.mRequestId, this.pPD, this.pNV.ZM(this.mRequestId) ? bC(t) : null);
        this.pOr.f(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pNV.a(this.mRequestId, this.pPD, exc, this.pNV.ZM(this.mRequestId) ? D(exc) : null);
        this.pOr.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void esM() {
        this.pNV.c(this.mRequestId, this.pPD, this.pNV.ZM(this.mRequestId) ? eAl() : null);
        this.pOr.esM();
    }

    protected Map<String, String> bC(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> eAl() {
        return null;
    }
}
