package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZM;
    private final al isS;
    private final j<T> itl;
    private final String iuw;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.itl = jVar;
        this.isS = alVar;
        this.iuw = str;
        this.ZM = str2;
        this.isS.db(this.ZM, this.iuw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.isS.a(this.ZM, this.iuw, this.isS.zo(this.ZM) ? aM(t) : null);
        this.itl.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void j(Exception exc) {
        this.isS.a(this.ZM, this.iuw, exc, this.isS.zo(this.ZM) ? l(exc) : null);
        this.itl.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bTP() {
        this.isS.b(this.ZM, this.iuw, this.isS.zo(this.ZM) ? car() : null);
        this.itl.bTP();
    }

    protected Map<String, String> aM(T t) {
        return null;
    }

    protected Map<String, String> l(Exception exc) {
        return null;
    }

    protected Map<String, String> car() {
        return null;
    }
}
