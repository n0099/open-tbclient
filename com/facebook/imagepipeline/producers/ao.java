package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al jJI;
    private final j<T> jKb;
    private final String jLa;
    private final String jLn;

    @Override // com.facebook.common.b.e
    protected abstract void aC(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.jKb = jVar;
        this.jJI = alVar;
        this.jLn = str;
        this.jLa = str2;
        this.jJI.em(this.jLa, this.jLn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.jJI.a(this.jLa, this.jLn, this.jJI.FH(this.jLa) ? bb(t) : null);
        this.jKb.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.jJI.a(this.jLa, this.jLn, exc, this.jJI.FH(this.jLa) ? o(exc) : null);
        this.jKb.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void ctv() {
        this.jJI.b(this.jLa, this.jLn, this.jJI.FH(this.jLa) ? cAe() : null);
        this.jKb.ctv();
    }

    protected Map<String, String> bb(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cAe() {
        return null;
    }
}
