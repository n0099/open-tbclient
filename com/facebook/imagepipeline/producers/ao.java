package com.facebook.imagepipeline.producers;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class ao<T> extends com.facebook.common.b.e<T> {
    private final String ZV;
    private final al itZ;
    private final j<T> ius;
    private final String ivD;

    @Override // com.facebook.common.b.e
    protected abstract void an(T t);

    public ao(j<T> jVar, al alVar, String str, String str2) {
        this.ius = jVar;
        this.itZ = alVar;
        this.ivD = str;
        this.ZV = str2;
        this.itZ.de(this.ZV, this.ivD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onSuccess(T t) {
        this.itZ.a(this.ZV, this.ivD, this.itZ.zE(this.ZV) ? aM(t) : null);
        this.ius.e(t, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void onFailure(Exception exc) {
        this.itZ.a(this.ZV, this.ivD, exc, this.itZ.zE(this.ZV) ? k(exc) : null);
        this.ius.B(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.b.e
    public void bUx() {
        this.itZ.b(this.ZV, this.ivD, this.itZ.zE(this.ZV) ? caZ() : null);
        this.ius.bUx();
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
