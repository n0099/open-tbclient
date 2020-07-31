package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes4.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am ndV;
    private final k<T> ner;
    private final String nfD;

    @Override // com.facebook.common.b.h
    protected abstract void aN(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.ner = kVar;
        this.ndV = amVar;
        this.nfD = str;
        this.mRequestId = str2;
        this.ndV.fW(this.mRequestId, this.nfD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.ndV.a(this.mRequestId, this.nfD, this.ndV.RB(this.mRequestId) ? bp(t) : null);
        this.ner.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.ndV.a(this.mRequestId, this.nfD, exc, this.ndV.RB(this.mRequestId) ? y(exc) : null);
        this.ner.F(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dCt() {
        this.ndV.b(this.mRequestId, this.nfD, this.ndV.RB(this.mRequestId) ? dKb() : null);
        this.ner.dCt();
    }

    protected Map<String, String> bp(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dKb() {
        return null;
    }
}
