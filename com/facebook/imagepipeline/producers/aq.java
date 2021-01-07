package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes3.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am pFI;
    private final k<T> pGe;
    private final String pHq;

    @Override // com.facebook.common.b.h
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pGe = kVar;
        this.pFI = amVar;
        this.pHq = str;
        this.mRequestId = str2;
        this.pFI.hn(this.mRequestId, this.pHq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pFI.b(this.mRequestId, this.pHq, this.pFI.ZA(this.mRequestId) ? bA(t) : null);
        this.pGe.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pFI.a(this.mRequestId, this.pHq, exc, this.pFI.ZA(this.mRequestId) ? D(exc) : null);
        this.pGe.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void etW() {
        this.pFI.c(this.mRequestId, this.pHq, this.pFI.ZA(this.mRequestId) ? eBu() : null);
        this.pGe.etW();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> eBu() {
        return null;
    }
}
