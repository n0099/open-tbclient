package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al jJT;
    private final j<T> jKm;
    private final String jLl;
    private final String jLy;

    @Override // com.facebook.common.b.e
    protected abstract void aD(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.jKm = jVar;
        this.jJT = alVar;
        this.jLy = str;
        this.jLl = str2;
        this.jJT.el(this.jLl, this.jLy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.jJT.a(this.jLl, this.jLy, this.jJT.FI(this.jLl) ? bc(t) : null);
        this.jKm.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.jJT.a(this.jLl, this.jLy, exc, this.jJT.FI(this.jLl) ? o(exc) : null);
        this.jKm.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void ctI() {
        this.jJT.b(this.jLl, this.jLy, this.jJT.FI(this.jLl) ? cAr() : null);
        this.jKm.ctI();
    }

    protected Map<String, String> bc(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cAr() {
        return null;
    }
}
