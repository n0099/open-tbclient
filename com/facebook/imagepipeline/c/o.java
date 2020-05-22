package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> muJ;
    private final r muK;

    public o(p<K, V> pVar, r rVar) {
        this.muJ = pVar;
        this.muK = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bi(K k) {
        com.facebook.common.references.a<V> bi = this.muJ.bi(k);
        if (bi == null) {
            this.muK.dxC();
        } else {
            this.muK.bf(k);
        }
        return bi;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.muK.dxD();
        return this.muJ.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.muJ.b(hVar);
    }
}
