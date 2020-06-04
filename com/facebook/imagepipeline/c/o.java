package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> mvT;
    private final r mvU;

    public o(p<K, V> pVar, r rVar) {
        this.mvT = pVar;
        this.mvU = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bi(K k) {
        com.facebook.common.references.a<V> bi = this.mvT.bi(k);
        if (bi == null) {
            this.mvU.dxQ();
        } else {
            this.mvU.bf(k);
        }
        return bi;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.mvU.dxR();
        return this.mvT.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.mvT.b(hVar);
    }
}
