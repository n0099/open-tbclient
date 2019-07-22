package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final j<T> kjF;
    private final al kjm;
    private final String kkE;
    private final String kkR;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kjF = jVar;
        this.kjm = alVar;
        this.kkR = str;
        this.kkE = str2;
        this.kjm.eA(this.kkE, this.kkR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kjm.a(this.kkE, this.kkR, this.kjm.HP(this.kkE) ? ba(t) : null);
        this.kjF.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kjm.a(this.kkE, this.kkR, exc, this.kjm.HP(this.kkE) ? o(exc) : null);
        this.kjF.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cEA() {
        this.kjm.b(this.kkE, this.kkR, this.kjm.HP(this.kkE) ? cLl() : null);
        this.kjF.cEA();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cLl() {
        return null;
    }
}
