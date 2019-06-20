package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al kcf;
    private final j<T> kcy;
    private final String kdK;
    private final String kdx;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kcy = jVar;
        this.kcf = alVar;
        this.kdK = str;
        this.kdx = str2;
        this.kcf.ez(this.kdx, this.kdK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kcf.a(this.kdx, this.kdK, this.kcf.GV(this.kdx) ? ba(t) : null);
        this.kcy.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kcf.a(this.kdx, this.kdK, exc, this.kcf.GV(this.kdx) ? o(exc) : null);
        this.kcy.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cBz() {
        this.kcf.b(this.kdx, this.kdK, this.kcf.GV(this.kdx) ? cIh() : null);
        this.kcy.cBz();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cIh() {
        return null;
    }
}
