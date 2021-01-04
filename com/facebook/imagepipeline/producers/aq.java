package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes5.dex */
public abstract class aq<T> extends com.facebook.common.b.e<T> {
    private final String mRequestId;
    private final am pEb;
    private final k<T> pEx;
    private final String pFK;

    @Override // com.facebook.common.b.e
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pEx = kVar;
        this.pEb = amVar;
        this.pFK = str;
        this.mRequestId = str2;
        this.pEb.hm(this.mRequestId, this.pFK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.pEb.b(this.mRequestId, this.pFK, this.pEb.ZA(this.mRequestId) ? bz(t) : null);
        this.pEx.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.pEb.a(this.mRequestId, this.pFK, exc, this.pEb.ZA(this.mRequestId) ? D(exc) : null);
        this.pEx.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void etQ() {
        this.pEb.c(this.mRequestId, this.pFK, this.pEb.ZA(this.mRequestId) ? eAQ() : null);
        this.pEx.etQ();
    }

    protected Map<String, String> bz(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> eAQ() {
        return null;
    }
}
