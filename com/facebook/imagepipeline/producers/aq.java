package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mAh;
    private final String mRequestId;
    private final am myA;
    private final k<T> myW;

    @Override // com.facebook.common.b.h
    protected abstract void aM(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.myW = kVar;
        this.myA = amVar;
        this.mAh = str;
        this.mRequestId = str2;
        this.myA.fK(this.mRequestId, this.mAh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.myA.a(this.mRequestId, this.mAh, this.myA.Qc(this.mRequestId) ? bo(t) : null);
        this.myW.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.myA.a(this.mRequestId, this.mAh, exc, this.myA.Qc(this.mRequestId) ? y(exc) : null);
        this.myW.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dum() {
        this.myA.b(this.mRequestId, this.mAh, this.myA.Qc(this.mRequestId) ? dBV() : null);
        this.myW.dum();
    }

    protected Map<String, String> bo(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dBV() {
        return null;
    }
}
