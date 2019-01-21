package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZV;
    private final al iua;
    private final j<T> iut;
    private final String ivE;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.iut = jVar;
        this.iua = alVar;
        this.ivE = str;
        this.ZV = str2;
        this.iua.de(this.ZV, this.ivE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.iua.a(this.ZV, this.ivE, this.iua.zE(this.ZV) ? aM(t) : null);
        this.iut.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.iua.a(this.ZV, this.ivE, exc, this.iua.zE(this.ZV) ? k(exc) : null);
        this.iut.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bUx() {
        this.iua.b(this.ZV, this.ivE, this.iua.zE(this.ZV) ? caZ() : null);
        this.iut.bUx();
    }

    protected Map<String, String> aM(T t) {
        return null;
    }

    protected Map<String, String> k(Exception exc) {
        return null;
    }

    protected Map<String, String> caZ() {
        return null;
    }
}
