package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final am lVd;
    private final k<T> lVz;
    private final String lWK;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aR(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lVz = kVar;
        this.lVd = amVar;
        this.lWK = str;
        this.mRequestId = str2;
        this.lVd.fm(this.mRequestId, this.lWK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lVd.a(this.mRequestId, this.lWK, this.lVd.Pd(this.mRequestId) ? bt(t) : null);
        this.lVz.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lVd.a(this.mRequestId, this.lWK, exc, this.lVd.Pd(this.mRequestId) ? n(exc) : null);
        this.lVz.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dkE() {
        this.lVd.b(this.mRequestId, this.lWK, this.lVd.Pd(this.mRequestId) ? dsk() : null);
        this.lVz.dkE();
    }

    protected Map<String, String> bt(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dsk() {
        return null;
    }
}
