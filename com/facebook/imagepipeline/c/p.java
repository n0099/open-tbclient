package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> iqq;
    private final v iqr;

    public p(t<K, V> tVar, v vVar) {
        this.iqq = tVar;
        this.iqr = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.iqq.aH(k);
        if (aH == null) {
            this.iqr.bXc();
        } else {
            this.iqr.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.iqr.bXd();
        return this.iqq.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.iqq.b(predicate);
    }
}
