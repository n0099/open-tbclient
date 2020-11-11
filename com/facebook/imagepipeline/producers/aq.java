package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes18.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> oYA;
    private final am oYe;
    private final String oZL;

    @Override // com.facebook.common.b.h
    protected abstract void aY(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.oYA = kVar;
        this.oYe = amVar;
        this.oZL = str;
        this.mRequestId = str2;
        this.oYe.gZ(this.mRequestId, this.oZL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.oYe.a(this.mRequestId, this.oZL, this.oYe.Ym(this.mRequestId) ? bA(t) : null);
        this.oYA.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.oYe.a(this.mRequestId, this.oZL, exc, this.oYe.Ym(this.mRequestId) ? D(exc) : null);
        this.oYA.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void ejZ() {
        this.oYe.b(this.mRequestId, this.oZL, this.oYe.Ym(this.mRequestId) ? erI() : null);
        this.oYA.ejZ();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> erI() {
        return null;
    }
}
