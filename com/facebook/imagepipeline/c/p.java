package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> kjd;
    private final v kje;

    public p(t<K, V> tVar, v vVar) {
        this.kjd = tVar;
        this.kje = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aV(K k) {
        com.facebook.common.references.a<V> aV = this.kjd.aV(k);
        if (aV == null) {
            this.kje.cIs();
        } else {
            this.kje.aS(k);
        }
        return aV;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.kje.cIt();
        return this.kjd.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.kjd.b(predicate);
    }
}
