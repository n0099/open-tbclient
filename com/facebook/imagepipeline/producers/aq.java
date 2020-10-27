package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes18.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am oOL;
    private final k<T> oPh;
    private final String oQs;

    @Override // com.facebook.common.b.h
    protected abstract void aY(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.oPh = kVar;
        this.oOL = amVar;
        this.oQs = str;
        this.mRequestId = str2;
        this.oOL.gX(this.mRequestId, this.oQs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.oOL.a(this.mRequestId, this.oQs, this.oOL.XI(this.mRequestId) ? bA(t) : null);
        this.oPh.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.oOL.a(this.mRequestId, this.oQs, exc, this.oOL.XI(this.mRequestId) ? D(exc) : null);
        this.oPh.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void egk() {
        this.oOL.b(this.mRequestId, this.oQs, this.oOL.XI(this.mRequestId) ? enS() : null);
        this.oPh.egk();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> enS() {
        return null;
    }
}
