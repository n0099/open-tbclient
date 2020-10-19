package com.facebook.imagepipeline.c;
/* loaded from: classes18.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> nTC;
    private final r nTD;

    public o(p<K, V> pVar, r rVar) {
        this.nTC = pVar;
        this.nTD = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bq(K k) {
        com.facebook.common.references.a<V> bq = this.nTC.bq(k);
        if (bq == null) {
            this.nTD.dZA();
        } else {
            this.nTD.bn(k);
        }
        return bq;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.nTD.dZB();
        return this.nTC.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.nTC.b(hVar);
    }
}
