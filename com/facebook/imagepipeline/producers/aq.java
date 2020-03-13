package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final k<T> lVK;
    private final am lVo;
    private final String lWV;
    private final String mRequestId;

    @Override // com.facebook.common.b.h
    protected abstract void aR(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.lVK = kVar;
        this.lVo = amVar;
        this.lWV = str;
        this.mRequestId = str2;
        this.lVo.fm(this.mRequestId, this.lWV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.lVo.a(this.mRequestId, this.lWV, this.lVo.Pe(this.mRequestId) ? bt(t) : null);
        this.lVK.g(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.lVo.a(this.mRequestId, this.lWV, exc, this.lVo.Pe(this.mRequestId) ? n(exc) : null);
        this.lVK.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dkF() {
        this.lVo.b(this.mRequestId, this.lWV, this.lVo.Pe(this.mRequestId) ? dsl() : null);
        this.lVK.dkF();
    }

    protected Map<String, String> bt(T t) {
        return null;
    }

    protected Map<String, String> n(Exception exc) {
        return null;
    }

    protected Map<String, String> dsl() {
        return null;
    }
}
