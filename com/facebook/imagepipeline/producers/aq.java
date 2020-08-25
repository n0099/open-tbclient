package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes8.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am nxN;
    private final k<T> nyj;
    private final String nzu;

    @Override // com.facebook.common.b.h
    protected abstract void aP(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.nyj = kVar;
        this.nxN = amVar;
        this.nzu = str;
        this.mRequestId = str2;
        this.nxN.gn(this.mRequestId, this.nzu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.nxN.a(this.mRequestId, this.nzu, this.nxN.UF(this.mRequestId) ? br(t) : null);
        this.nyj.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.nxN.a(this.mRequestId, this.nzu, exc, this.nxN.UF(this.mRequestId) ? C(exc) : null);
        this.nyj.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dOu() {
        this.nxN.b(this.mRequestId, this.nzu, this.nxN.UF(this.mRequestId) ? dWb() : null);
        this.nyj.dOu();
    }

    protected Map<String, String> br(T t) {
        return null;
    }

    protected Map<String, String> C(Exception exc) {
        return null;
    }

    protected Map<String, String> dWb() {
        return null;
    }
}
