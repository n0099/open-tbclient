package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jYq;
    private final v jYr;

    public p(t<K, V> tVar, v vVar) {
        this.jYq = tVar;
        this.jYr = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aV(K k) {
        com.facebook.common.references.a<V> aV = this.jYq.aV(k);
        if (aV == null) {
            this.jYr.cEh();
        } else {
            this.jYr.aS(k);
        }
        return aV;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jYr.cEi();
        return this.jYq.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jYq.b(predicate);
    }
}
