package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZM;
    private final al igM;
    private final j<T> ihf;
    private final String iiq;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.ihf = jVar;
        this.igM = alVar;
        this.iiq = str;
        this.ZM = str2;
        this.igM.cX(this.ZM, this.iiq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.igM.a(this.ZM, this.iiq, this.igM.yD(this.ZM) ? aM(t) : null);
        this.ihf.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void j(Exception exc) {
        this.igM.a(this.ZM, this.iiq, exc, this.igM.yD(this.ZM) ? l(exc) : null);
        this.ihf.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bRy() {
        this.igM.b(this.ZM, this.iiq, this.igM.yD(this.ZM) ? bYa() : null);
        this.ihf.bRy();
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
