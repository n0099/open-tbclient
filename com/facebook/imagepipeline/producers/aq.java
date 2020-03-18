package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final am lWU;
    private final k<T> lXq;
    private final String lYB;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aR(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lXq = kVar;
        this.lWU = amVar;
        this.lYB = str;
        this.mRequestId = str2;
        this.lWU.fk(this.mRequestId, this.lYB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lWU.a(this.mRequestId, this.lYB, this.lWU.Pd(this.mRequestId) ? bt(t) : null);
        this.lXq.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lWU.a(this.mRequestId, this.lYB, exc, this.lWU.Pd(this.mRequestId) ? n(exc) : null);
        this.lXq.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dlc() {
        this.lWU.b(this.mRequestId, this.lYB, this.lWU.Pd(this.mRequestId) ? dsI() : null);
        this.lXq.dlc();
    }

    protected Map<String, String> bt(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dsI() {
        return null;
    }
}
