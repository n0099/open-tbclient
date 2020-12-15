package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes15.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am poB;
    private final k<T> poX;
    private final String pqk;

    @Override // com.facebook.common.b.h
    protected abstract void aZ(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.poX = kVar;
        this.poB = amVar;
        this.pqk = str;
        this.mRequestId = str2;
        this.poB.hh(this.mRequestId, this.pqk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.poB.a(this.mRequestId, this.pqk, this.poB.Zq(this.mRequestId) ? bA(t) : null);
        this.poX.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.poB.a(this.mRequestId, this.pqk, exc, this.poB.Zq(this.mRequestId) ? D(exc) : null);
        this.poX.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void epN() {
        this.poB.b(this.mRequestId, this.pqk, this.poB.Zq(this.mRequestId) ? exj() : null);
        this.poX.epN();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> exj() {
        return null;
    }
}
