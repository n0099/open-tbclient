package com.facebook.imagepipeline.c;
/* loaded from: classes9.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lML;
    private final r lMM;

    public o(p<K, V> pVar, r rVar) {
        this.lML = pVar;
        this.lMM = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bk(K k) {
        com.facebook.common.references.a<V> bk = this.lML.bk(k);
        if (bk == null) {
            this.lMM.dlv();
        } else {
            this.lMM.bh(k);
        }
        return bk;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lMM.dlw();
        return this.lML.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lML.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lML.d(hVar);
    }
}
