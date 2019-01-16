package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> iqp;
    private final v iqq;

    public p(t<K, V> tVar, v vVar) {
        this.iqp = tVar;
        this.iqq = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.iqp.aH(k);
        if (aH == null) {
            this.iqq.bXc();
        } else {
            this.iqq.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.iqq.bXd();
        return this.iqp.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.iqp.b(predicate);
    }
}
