package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes12.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final am meJ;
    private final k<T> mff;
    private final String mgq;

    @Override // com.facebook.common.b.h
    protected abstract void aI(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.mff = kVar;
        this.meJ = amVar;
        this.mgq = str;
        this.mRequestId = str2;
        this.meJ.fi(this.mRequestId, this.mgq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.meJ.a(this.mRequestId, this.mgq, this.meJ.Oo(this.mRequestId) ? bk(t) : null);
        this.mff.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.meJ.a(this.mRequestId, this.mgq, exc, this.meJ.Oo(this.mRequestId) ? r(exc) : null);
        this.mff.G(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void dmT() {
        this.meJ.b(this.mRequestId, this.mgq, this.meJ.Oo(this.mRequestId) ? duE() : null);
        this.mff.dmT();
    }

    protected Map<String, String> bk(T t) {
        return null;
    }

    protected Map<String, String> r(Exception exc) {
        return null;
    }

    protected Map<String, String> duE() {
        return null;
    }
}
