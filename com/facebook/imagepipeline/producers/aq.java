package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes15.dex */
public abstract class aq<T> extends com.facebook.common.b.h<T> {
    private final String mRequestId;
    private final k<T> poV;
    private final am poz;
    private final String pqi;

    @Override // com.facebook.common.b.h
    protected abstract void aZ(T t);

    public aq(k<T> kVar, am amVar, String str, String str2) {
        this.poV = kVar;
        this.poz = amVar;
        this.pqi = str;
        this.mRequestId = str2;
        this.poz.hh(this.mRequestId, this.pqi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onSuccess(T t) {
        this.poz.a(this.mRequestId, this.pqi, this.poz.Zq(this.mRequestId) ? bA(t) : null);
        this.poV.h(t, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void onFailure(Exception exc) {
        this.poz.a(this.mRequestId, this.pqi, exc, this.poz.Zq(this.mRequestId) ? D(exc) : null);
        this.poV.E(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.h
    public void epM() {
        this.poz.b(this.mRequestId, this.pqi, this.poz.Zq(this.mRequestId) ? exi() : null);
        this.poV.epM();
    }

    protected Map<String, String> bA(T t) {
        return null;
    }

    protected Map<String, String> D(Exception exc) {
        return null;
    }

    protected Map<String, String> exi() {
        return null;
    }
}
