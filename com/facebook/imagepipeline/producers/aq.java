package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes8.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> nyB;
    private final am nyf;
    private final String nzM;

    @Override // com.facebook.common.b.h
    protected abstract void aP(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.nyB = kVar;
        this.nyf = amVar;
        this.nzM = str;
        this.mRequestId = str2;
        this.nyf.go(this.mRequestId, this.nzM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.nyf.a(this.mRequestId, this.nzM, this.nyf.UF(this.mRequestId) ? br(t) : null);
        this.nyB.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.nyf.a(this.mRequestId, this.nzM, exc, this.nyf.UF(this.mRequestId) ? C(exc) : null);
        this.nyB.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dOD() {
        this.nyf.b(this.mRequestId, this.nzM, this.nyf.UF(this.mRequestId) ? dWk() : null);
        this.nyB.dOD();
    }

    protected Map<String, String> br(T t) {
        return null;
    }

    protected Map<String, String> C(Exception exc) {
        return null;
    }

    protected Map<String, String> dWk() {
        return null;
    }
}
