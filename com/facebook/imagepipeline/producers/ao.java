package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al kmP;
    private final j<T> kni;
    private final String koh;
    private final String kou;

    @Override // com.facebook.common.b.e
    protected abstract void aB(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.kni = jVar;
        this.kmP = alVar;
        this.kou = str;
        this.koh = str2;
        this.kmP.eB(this.koh, this.kou);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.kmP.a(this.koh, this.kou, this.kmP.Iq(this.koh) ? ba(t) : null);
        this.kni.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.kmP.a(this.koh, this.kou, exc, this.kmP.Iq(this.koh) ? o(exc) : null);
        this.kni.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void cFJ() {
        this.kmP.b(this.koh, this.kou, this.kmP.Iq(this.koh) ? cMu() : null);
        this.kni.cFJ();
    }

    protected Map<String, String> ba(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cMu() {
        return null;
    }
}
