package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZM;
    private final j<T> iiP;
    private final al iiw;
    private final String ika;

    @Override // com.facebook.common.b.e
    protected abstract void am(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.iiP = jVar;
        this.iiw = alVar;
        this.ika = str;
        this.ZM = str2;
        this.iiw.cW(this.ZM, this.ika);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.iiw.a(this.ZM, this.ika, this.iiw.yI(this.ZM) ? aL(t) : null);
        this.iiP.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void j(Exception exc) {
        this.iiw.a(this.ZM, this.ika, exc, this.iiw.yI(this.ZM) ? l(exc) : null);
        this.iiP.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bQT() {
        this.iiw.b(this.ZM, this.ika, this.iiw.yI(this.ZM) ? bXv() : null);
        this.iiP.bQT();
    }

    protected Map<String, String> aL(T t) {
        return null;
    }

    protected Map<String, String> l(Exception exc) {
        return null;
    }

    protected Map<String, String> bXv() {
        return null;
    }
}
