package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes18.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> nXP;
    private final am nXt;
    private final String nZa;

    @Override // com.facebook.common.b.h
    protected abstract void aU(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.nXP = kVar;
        this.nXt = amVar;
        this.nZa = str;
        this.mRequestId = str2;
        this.nXt.gH(this.mRequestId, this.nZa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.nXt.a(this.mRequestId, this.nZa, this.nXt.VV(this.mRequestId) ? bw(t) : null);
        this.nXP.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.nXt.a(this.mRequestId, this.nZa, exc, this.nXt.VV(this.mRequestId) ? D(exc) : null);
        this.nXP.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dWm() {
        this.nXt.b(this.mRequestId, this.nZa, this.nXt.VV(this.mRequestId) ? edT() : null);
        this.nXP.dWm();
    }

    protected Map<String, String> bw(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> edT() {
        return null;
    }
}
