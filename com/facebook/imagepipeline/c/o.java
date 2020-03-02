package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lRl;
    private final r lRm;

    public o(p<K, V> pVar, r rVar) {
        this.lRl = pVar;
        this.lRm = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bn(K k) {
        com.facebook.common.references.a<V> bn = this.lRl.bn(k);
        if (bn == null) {
            this.lRm.dnR();
        } else {
            this.lRm.bk(k);
        }
        return bn;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lRm.dnS();
        return this.lRl.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lRl.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lRl.d(hVar);
    }
}
