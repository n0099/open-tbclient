package com.facebook.imagepipeline.c;
/* loaded from: classes4.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> nae;
    private final r naf;

    public o(p<K, V> pVar, r rVar) {
        this.nae = pVar;
        this.naf = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bj(K k) {
        com.facebook.common.references.a<V> bj = this.nae.bj(k);
        if (bj == null) {
            this.naf.dFJ();
        } else {
            this.naf.bg(k);
        }
        return bj;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.naf.dFK();
        return this.nae.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.nae.b(hVar);
    }
}
