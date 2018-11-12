package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> ieM;
    private final v ieN;

    public p(t<K, V> tVar, v vVar) {
        this.ieM = tVar;
        this.ieN = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aG(K k) {
        com.facebook.common.references.a<V> aG = this.ieM.aG(k);
        if (aG == null) {
            this.ieN.bTy();
        } else {
            this.ieN.aD(k);
        }
        return aG;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.ieN.bTz();
        return this.ieM.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.ieM.b(predicate);
    }
}
