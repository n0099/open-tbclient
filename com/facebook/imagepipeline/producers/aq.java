package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final am lVb;
    private final k<T> lVx;
    private final String lWI;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aR(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lVx = kVar;
        this.lVb = amVar;
        this.lWI = str;
        this.mRequestId = str2;
        this.lVb.fm(this.mRequestId, this.lWI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lVb.a(this.mRequestId, this.lWI, this.lVb.Pd(this.mRequestId) ? bt(t) : null);
        this.lVx.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lVb.a(this.mRequestId, this.lWI, exc, this.lVb.Pd(this.mRequestId) ? n(exc) : null);
        this.lVx.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dkC() {
        this.lVb.b(this.mRequestId, this.lWI, this.lVb.Pd(this.mRequestId) ? dsi() : null);
        this.lVx.dkC();
    }

    protected Map<String, String> bt(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dsi() {
        return null;
    }
}
