package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pKg;
    private final r pKh;

    public o(p<K, V> pVar, r rVar) {
        this.pKg = pVar;
        this.pKh = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bw(K k) {
        com.facebook.common.references.a<V> bw = this.pKg.bw(k);
        if (bw == null) {
            this.pKh.evW();
        } else {
            this.pKh.bt(k);
        }
        return bw;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pKh.evX();
        return this.pKg.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.pKg.c(hVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.pKg.d(hVar);
    }
}
