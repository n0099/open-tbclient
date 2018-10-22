package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> icZ;
    private final v ida;

    public p(t<K, V> tVar, v vVar) {
        this.icZ = tVar;
        this.ida = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.icZ.aH(k);
        if (aH == null) {
            this.ida.bUd();
        } else {
            this.ida.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.ida.bUe();
        return this.icZ.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.icZ.b(predicate);
    }
}
