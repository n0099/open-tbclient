package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes4.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am ndX;
    private final k<T> neu;
    private final String nfF;

    @Override // com.facebook.common.b.h
    protected abstract void aN(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.neu = kVar;
        this.ndX = amVar;
        this.nfF = str;
        this.mRequestId = str2;
        this.ndX.fW(this.mRequestId, this.nfF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.ndX.a(this.mRequestId, this.nfF, this.ndX.RB(this.mRequestId) ? bp(t) : null);
        this.neu.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.ndX.a(this.mRequestId, this.nfF, exc, this.ndX.RB(this.mRequestId) ? y(exc) : null);
        this.neu.F(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dCu() {
        this.ndX.b(this.mRequestId, this.nfF, this.ndX.RB(this.mRequestId) ? dKc() : null);
        this.neu.dCu();
    }

    protected Map<String, String> bp(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dKc() {
        return null;
    }
}
