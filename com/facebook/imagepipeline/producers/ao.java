package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final j<T> jJG;
    private final al jJn;
    private final String jKF;
    private final String jKS;

    @Override // com.facebook.common.b.e
    protected abstract void az(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.jJG = jVar;
        this.jJn = alVar;
        this.jKS = str;
        this.jKF = str2;
        this.jJn.em(this.jKF, this.jKS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.jJn.a(this.jKF, this.jKS, this.jJn.Fy(this.jKF) ? aY(t) : null);
        this.jJG.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.jJn.a(this.jKF, this.jKS, exc, this.jJn.Fy(this.jKF) ? o(exc) : null);
        this.jJG.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void ctB() {
        this.jJn.b(this.jKF, this.jKS, this.jJn.Fy(this.jKF) ? cAk() : null);
        this.jJG.ctB();
    }

    protected Map<String, String> aY(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cAk() {
        return null;
    }
}
