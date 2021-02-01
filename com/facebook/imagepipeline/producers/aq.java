package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes5.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> pLM;
    private final am pLq;
    private final String pMY;

    @Override // com.facebook.common.b.h
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pLM = kVar;
        this.pLq = amVar;
        this.pMY = str;
        this.mRequestId = str2;
        this.pLq.ht(this.mRequestId, this.pMY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pLq.b(this.mRequestId, this.pMY, this.pLq.Zu(this.mRequestId) ? bA(t) : null);
        this.pLM.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pLq.a(this.mRequestId, this.pMY, exc, this.pLq.Zu(this.mRequestId) ? D(exc) : null);
        this.pLM.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void esv() {
        this.pLq.c(this.mRequestId, this.pMY, this.pLq.Zu(this.mRequestId) ? ezU() : null);
        this.pLM.esv();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> ezU() {
        return null;
    }
}
