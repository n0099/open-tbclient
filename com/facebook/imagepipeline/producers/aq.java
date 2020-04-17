package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am meF;
    private final k<T> mfb;
    private final String mgm;

    @Override // com.facebook.common.b.h
    protected abstract void aH(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.mfb = kVar;
        this.meF = amVar;
        this.mgm = str;
        this.mRequestId = str2;
        this.meF.fi(this.mRequestId, this.mgm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.meF.a(this.mRequestId, this.mgm, this.meF.Ol(this.mRequestId) ? bj(t) : null);
        this.mfb.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.meF.a(this.mRequestId, this.mgm, exc, this.meF.Ol(this.mRequestId) ? q(exc) : null);
        this.mfb.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dmV() {
        this.meF.b(this.mRequestId, this.mgm, this.meF.Ol(this.mRequestId) ? duG() : null);
        this.mfb.dmV();
    }

    protected Map<String, String> bj(T t) {
        return null;
    }

    protected Map<String, String> q(Exception exc) {
        return null;
    }

    protected Map<String, String> duG() {
        return null;
    }
}
