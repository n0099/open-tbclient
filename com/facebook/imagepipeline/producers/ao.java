package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final al jKb;
    private final j<T> jKu;
    private final String jLG;
    private final String jLt;

    @Override // com.facebook.common.b.e
    protected abstract void aD(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.jKu = jVar;
        this.jKb = alVar;
        this.jLG = str;
        this.jLt = str2;
        this.jKb.em(this.jLt, this.jLG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.jKb.a(this.jLt, this.jLG, this.jKb.FK(this.jLt) ? bc(t) : null);
        this.jKu.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.jKb.a(this.jLt, this.jLG, exc, this.jKb.FK(this.jLt) ? o(exc) : null);
        this.jKu.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void ctF() {
        this.jKb.b(this.jLt, this.jLG, this.jKb.FK(this.jLt) ? cAo() : null);
        this.jKu.ctF();
    }

    protected Map<String, String> bc(T t) {
        return null;
    }

    protected Map<String, String> o(Exception exc) {
        return null;
    }

    protected Map<String, String> cAo() {
        return null;
    }
}
