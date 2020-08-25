package com.facebook.imagepipeline.c;
/* loaded from: classes8.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> ntT;
    private final r ntU;

    public o(p<K, V> pVar, r rVar) {
        this.ntT = pVar;
        this.ntU = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bl(K k) {
        com.facebook.common.references.a<V> bl = this.ntT.bl(k);
        if (bl == null) {
            this.ntU.dRI();
        } else {
            this.ntU.bi(k);
        }
        return bl;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.ntU.dRJ();
        return this.ntT.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.ntT.b(hVar);
    }
}
