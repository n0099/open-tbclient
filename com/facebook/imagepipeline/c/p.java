package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jYp;
    private final v jYq;

    public p(t<K, V> tVar, v vVar) {
        this.jYp = tVar;
        this.jYq = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aV(K k) {
        com.facebook.common.references.a<V> aV = this.jYp.aV(k);
        if (aV == null) {
            this.jYq.cEf();
        } else {
            this.jYq.aS(k);
        }
        return aV;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jYq.cEg();
        return this.jYp.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jYp.b(predicate);
    }
}
