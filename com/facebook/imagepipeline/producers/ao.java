package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZM;
    private final al igL;
    private final j<T> ihe;
    private final String iip;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.ihe = jVar;
        this.igL = alVar;
        this.iip = str;
        this.ZM = str2;
        this.igL.cX(this.ZM, this.iip);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.igL.a(this.ZM, this.iip, this.igL.yD(this.ZM) ? aM(t) : null);
        this.ihe.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void j(Exception exc) {
        this.igL.a(this.ZM, this.iip, exc, this.igL.yD(this.ZM) ? l(exc) : null);
        this.ihe.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bRy() {
        this.igL.b(this.ZM, this.iip, this.igL.yD(this.ZM) ? bYa() : null);
        this.ihe.bRy();
    }

    protected Map<String, String> aM(T t) {
        return null;
    }

    protected Map<String, String> l(Exception exc) {
        return null;
    }

    protected Map<String, String> bYa() {
        return null;
    }
}
