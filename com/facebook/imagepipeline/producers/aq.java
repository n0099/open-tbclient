package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am mVR;
    private final k<T> mWn;
    private final String mXz;

    @Override // com.facebook.common.b.h
    protected abstract void aN(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.mWn = kVar;
        this.mVR = amVar;
        this.mXz = str;
        this.mRequestId = str2;
        this.mVR.fU(this.mRequestId, this.mXz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.mVR.a(this.mRequestId, this.mXz, this.mVR.QP(this.mRequestId) ? bp(t) : null);
        this.mWn.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.mVR.a(this.mRequestId, this.mXz, exc, this.mVR.QP(this.mRequestId) ? y(exc) : null);
        this.mWn.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dzd() {
        this.mVR.b(this.mRequestId, this.mXz, this.mVR.QP(this.mRequestId) ? dGL() : null);
        this.mWn.dzd();
    }

    protected Map<String, String> bp(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dGL() {
        return null;
    }
}
