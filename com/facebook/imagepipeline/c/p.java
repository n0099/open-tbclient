package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jYt;
    private final v jYu;

    public p(t<K, V> tVar, v vVar) {
        this.jYt = tVar;
        this.jYu = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aV(K k) {
        com.facebook.common.references.a<V> aV = this.jYt.aV(k);
        if (aV == null) {
            this.jYu.cEg();
        } else {
            this.jYu.aS(k);
        }
        return aV;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jYu.cEh();
        return this.jYt.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jYt.b(predicate);
    }
}
