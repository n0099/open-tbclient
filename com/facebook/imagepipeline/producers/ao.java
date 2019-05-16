package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al kcb;
    private final j<T> kcu;
    private final String kdG;
    private final String kdt;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kcu = jVar;
        this.kcb = alVar;
        this.kdG = str;
        this.kdt = str2;
        this.kcb.ez(this.kdt, this.kdG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kcb.a(this.kdt, this.kdG, this.kcb.GT(this.kdt) ? ba(t) : null);
        this.kcu.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kcb.a(this.kdt, this.kdG, exc, this.kcb.GT(this.kdt) ? o(exc) : null);
        this.kcu.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cBy() {
        this.kcb.b(this.kdt, this.kdG, this.kcb.GT(this.kdt) ? cIg() : null);
        this.kcu.cBy();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cIg() {
        return null;
    }
}
