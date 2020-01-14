package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes10.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final k<T> lUQ;
    private final am lUu;
    private final String lWb;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aP(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lUQ = kVar;
        this.lUu = amVar;
        this.lWb = str;
        this.mRequestId = str2;
        this.lUu.fe(this.mRequestId, this.lWb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lUu.a(this.mRequestId, this.lWb, this.lUu.OQ(this.mRequestId) ? br(t) : null);
        this.lUQ.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lUu.a(this.mRequestId, this.lWb, exc, this.lUu.OQ(this.mRequestId) ? n(exc) : null);
        this.lUQ.D(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void djp() {
        this.lUu.b(this.mRequestId, this.lWb, this.lUu.OQ(this.mRequestId) ? dqW() : null);
        this.lUQ.djp();
    }

    protected Map<String, String> br(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dqW() {
        return null;
    }
}
