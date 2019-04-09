package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final j<T> jJH;
    private final al jJo;
    private final String jKG;
    private final String jKT;

    @Override // com.facebook.common.b.e
    protected abstract void az(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.jJH = jVar;
        this.jJo = alVar;
        this.jKT = str;
        this.jKG = str2;
        this.jJo.em(this.jKG, this.jKT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.jJo.a(this.jKG, this.jKT, this.jJo.Fy(this.jKG) ? aY(t) : null);
        this.jJH.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.jJo.a(this.jKG, this.jKT, exc, this.jJo.Fy(this.jKG) ? o(exc) : null);
        this.jJH.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void ctB() {
        this.jJo.b(this.jKG, this.jKT, this.jJo.Fy(this.jKG) ? cAk() : null);
        this.jJH.ctB();
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
