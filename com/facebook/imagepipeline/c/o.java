package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lRj;
    private final r lRk;

    public o(p<K, V> pVar, r rVar) {
        this.lRj = pVar;
        this.lRk = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bn(K k) {
        com.facebook.common.references.a<V> bn = this.lRj.bn(k);
        if (bn == null) {
            this.lRk.dnP();
        } else {
            this.lRk.bk(k);
        }
        return bn;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lRk.dnQ();
        return this.lRj.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lRj.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lRj.d(hVar);
    }
}
