package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al kcc;
    private final j<T> kcv;
    private final String kdH;
    private final String kdu;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kcv = jVar;
        this.kcc = alVar;
        this.kdH = str;
        this.kdu = str2;
        this.kcc.ez(this.kdu, this.kdH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kcc.a(this.kdu, this.kdH, this.kcc.GT(this.kdu) ? ba(t) : null);
        this.kcv.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kcc.a(this.kdu, this.kdH, exc, this.kcc.GT(this.kdu) ? o(exc) : null);
        this.kcv.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cBA() {
        this.kcc.b(this.kdu, this.kdH, this.kcc.GT(this.kdu) ? cIi() : null);
        this.kcv.cBA();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cIi() {
        return null;
    }
}
