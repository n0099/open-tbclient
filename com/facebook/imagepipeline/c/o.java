package com.facebook.imagepipeline.c;
/* loaded from: classes25.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> nEj;
    private final r nEk;

    public o(p<K, V> pVar, r rVar) {
        this.nEj = pVar;
        this.nEk = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bn(K k) {
        com.facebook.common.references.a<V> bn = this.nEj.bn(k);
        if (bn == null) {
            this.nEk.dVP();
        } else {
            this.nEk.bk(k);
        }
        return bn;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.nEk.dVQ();
        return this.nEj.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.nEj.b(hVar);
    }
}
