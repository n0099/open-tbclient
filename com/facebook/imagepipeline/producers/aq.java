package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am mVU;
    private final k<T> mWq;
    private final String mXC;

    @Override // com.facebook.common.b.h
    protected abstract void aN(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.mWq = kVar;
        this.mVU = amVar;
        this.mXC = str;
        this.mRequestId = str2;
        this.mVU.fU(this.mRequestId, this.mXC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.mVU.a(this.mRequestId, this.mXC, this.mVU.QQ(this.mRequestId) ? bp(t) : null);
        this.mWq.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.mVU.a(this.mRequestId, this.mXC, exc, this.mVU.QQ(this.mRequestId) ? y(exc) : null);
        this.mWq.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dzh() {
        this.mVU.b(this.mRequestId, this.mXC, this.mVU.QQ(this.mRequestId) ? dGP() : null);
        this.mWq.dzh();
    }

    protected Map<String, String> bp(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dGP() {
        return null;
    }
}
