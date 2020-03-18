package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lTc;
    private final r lTd;

    public o(p<K, V> pVar, r rVar) {
        this.lTc = pVar;
        this.lTd = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bn(K k) {
        com.facebook.common.references.a<V> bn = this.lTc.bn(k);
        if (bn == null) {
            this.lTd.dop();
        } else {
            this.lTd.bk(k);
        }
        return bn;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lTd.doq();
        return this.lTc.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lTc.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lTc.d(hVar);
    }
}
