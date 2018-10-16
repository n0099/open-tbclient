package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> icY;
    private final v icZ;

    public p(t<K, V> tVar, v vVar) {
        this.icY = tVar;
        this.icZ = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.icY.aH(k);
        if (aH == null) {
            this.icZ.bUd();
        } else {
            this.icZ.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.icZ.bUe();
        return this.icY.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.icY.b(predicate);
    }
}
