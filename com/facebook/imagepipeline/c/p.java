package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> kgF;
    private final v kgG;

    public p(t<K, V> tVar, v vVar) {
        this.kgF = tVar;
        this.kgG = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aV(K k) {
        com.facebook.common.references.a<V> aV = this.kgF.aV(k);
        if (aV == null) {
            this.kgG.cHE();
        } else {
            this.kgG.aS(k);
        }
        return aV;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.kgG.cHF();
        return this.kgF.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.kgF.b(predicate);
    }
}
