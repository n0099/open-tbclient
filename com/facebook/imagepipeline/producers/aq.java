package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes3.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> pBD;
    private final am pBh;
    private final String pCP;

    @Override // com.facebook.common.b.h
    protected abstract void ba(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pBD = kVar;
        this.pBh = amVar;
        this.pCP = str;
        this.mRequestId = str2;
        this.pBh.hm(this.mRequestId, this.pCP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.pBh.b(this.mRequestId, this.pCP, this.pBh.Ys(this.mRequestId) ? bA(t) : null);
        this.pBD.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.pBh.a(this.mRequestId, this.pCP, exc, this.pBh.Ys(this.mRequestId) ? D(exc) : null);
        this.pBD.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void eqc() {
        this.pBh.c(this.mRequestId, this.pCP, this.pBh.Ys(this.mRequestId) ? exC() : null);
        this.pBD.eqc();
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
