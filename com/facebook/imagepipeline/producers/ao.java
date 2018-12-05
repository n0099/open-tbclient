package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZM;
    private final al ipI;
    private final j<T> iqb;
    private final String irm;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.iqb = jVar;
        this.ipI = alVar;
        this.irm = str;
        this.ZM = str2;
        this.ipI.db(this.ZM, this.irm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.ipI.a(this.ZM, this.irm, this.ipI.zl(this.ZM) ? aM(t) : null);
        this.iqb.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void j(Exception exc) {
        this.ipI.a(this.ZM, this.irm, exc, this.ipI.zl(this.ZM) ? l(exc) : null);
        this.iqb.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bSZ() {
        this.ipI.b(this.ZM, this.irm, this.ipI.zl(this.ZM) ? bZB() : null);
        this.iqb.bSZ();
    }

    protected Map<String, String> aM(T t) {
        return null;
    }

    protected Map<String, String> l(Exception exc) {
        return null;
    }

    protected Map<String, String> bZB() {
        return null;
    }
}
