package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> kho;
    private final v khp;

    public p(t<K, V> tVar, v vVar) {
        this.kho = tVar;
        this.khp = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aQ(K k) {
        com.facebook.common.references.a<V> aQ = this.kho.aQ(k);
        if (aQ == null) {
            this.khp.cFp();
        } else {
            this.khp.aN(k);
        }
        return aQ;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.khp.cFq();
        return this.kho.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.kho.b(predicate);
    }
}
