package com.facebook.imagepipeline.c;
/* loaded from: classes4.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> nac;
    private final r nad;

    public o(p<K, V> pVar, r rVar) {
        this.nac = pVar;
        this.nad = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bj(K k) {
        com.facebook.common.references.a<V> bj = this.nac.bj(k);
        if (bj == null) {
            this.nad.dFI();
        } else {
            this.nad.bg(k);
        }
        return bj;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.nad.dFJ();
        return this.nac.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.nac.b(hVar);
    }
}
