package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes25.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am nIc;
    private final k<T> nIy;
    private final String nJJ;

    @Override // com.facebook.common.b.h
    protected abstract void aR(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.nIy = kVar;
        this.nIc = amVar;
        this.nJJ = str;
        this.mRequestId = str2;
        this.nIc.gA(this.mRequestId, this.nJJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.nIc.a(this.mRequestId, this.nJJ, this.nIc.Vh(this.mRequestId) ? bt(t) : null);
        this.nIy.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.nIc.a(this.mRequestId, this.nJJ, exc, this.nIc.Vh(this.mRequestId) ? D(exc) : null);
        this.nIy.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dSB() {
        this.nIc.b(this.mRequestId, this.nJJ, this.nIc.Vh(this.mRequestId) ? eai() : null);
        this.nIy.dSB();
    }

    protected Map<String, String> bt(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> eai() {
        return null;
    }
}
