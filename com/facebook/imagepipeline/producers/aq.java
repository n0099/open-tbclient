package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes15.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am oZH;
    private final k<T> pae;
    private final String pbq;

    @Override // com.facebook.common.b.h
    protected abstract void aZ(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.pae = kVar;
        this.oZH = amVar;
        this.pbq = str;
        this.mRequestId = str2;
        this.oZH.gZ(this.mRequestId, this.pbq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.oZH.a(this.mRequestId, this.pbq, this.oZH.XX(this.mRequestId) ? bB(t) : null);
        this.pae.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.oZH.a(this.mRequestId, this.pbq, exc, this.oZH.XX(this.mRequestId) ? D(exc) : null);
        this.pae.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void ejX() {
        this.oZH.b(this.mRequestId, this.pbq, this.oZH.XX(this.mRequestId) ? erG() : null);
        this.pae.ejX();
    }

    protected Map<String, String> bB(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> erG() {
        return null;
    }
}
