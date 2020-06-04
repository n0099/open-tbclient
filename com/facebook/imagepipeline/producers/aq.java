package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final k<T> mAg;
    private final String mBs;
    private final String mRequestId;
    private final am mzK;

    @Override // com.facebook.common.b.h
    protected abstract void aM(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.mAg = kVar;
        this.mzK = amVar;
        this.mBs = str;
        this.mRequestId = str2;
        this.mzK.fK(this.mRequestId, this.mBs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.mzK.a(this.mRequestId, this.mBs, this.mzK.Qd(this.mRequestId) ? bo(t) : null);
        this.mAg.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.mzK.a(this.mRequestId, this.mBs, exc, this.mzK.Qd(this.mRequestId) ? y(exc) : null);
        this.mAg.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void duA() {
        this.mzK.b(this.mRequestId, this.mBs, this.mzK.Qd(this.mRequestId) ? dCj() : null);
        this.mAg.duA();
    }

    protected Map<String, String> bo(T t) {
        return null;
    }

    protected Map<String, String> y(Exception exc) {
        return null;
    }

    protected Map<String, String> dCj() {
        return null;
    }
}
