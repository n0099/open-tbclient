package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes10.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final k<T> lUL;
    private final am lUp;
    private final String lVW;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aP(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lUL = kVar;
        this.lUp = amVar;
        this.lVW = str;
        this.mRequestId = str2;
        this.lUp.fe(this.mRequestId, this.lVW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lUp.a(this.mRequestId, this.lVW, this.lUp.OQ(this.mRequestId) ? br(t) : null);
        this.lUL.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lUp.a(this.mRequestId, this.lVW, exc, this.lUp.OQ(this.mRequestId) ? n(exc) : null);
        this.lUL.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void djn() {
        this.lUp.b(this.mRequestId, this.lVW, this.lUp.OQ(this.mRequestId) ? dqU() : null);
        this.lUL.djn();
    }

    protected Map<String, String> br(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dqU() {
        return null;
    }
}
