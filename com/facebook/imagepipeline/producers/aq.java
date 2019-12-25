package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes9.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final am lQB;
    private final k<T> lQX;
    private final String lSi;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aP(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lQX = kVar;
        this.lQB = amVar;
        this.lSi = str;
        this.mRequestId = str2;
        this.lQB.fc(this.mRequestId, this.lSi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lQB.a(this.mRequestId, this.lSi, this.lQB.OF(this.mRequestId) ? bq(t) : null);
        this.lQX.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lQB.a(this.mRequestId, this.lSi, exc, this.lQB.OF(this.mRequestId) ? n(exc) : null);
        this.lQX.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dim() {
        this.lQB.b(this.mRequestId, this.lSi, this.lQB.OF(this.mRequestId) ? dpK() : null);
        this.lQX.dim();
    }

    protected Map<String, String> bq(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dpK() {
        return null;
    }
}
