package com.facebook.imagepipeline.c;
/* loaded from: classes18.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> oKU;
    private final r oKV;

    public o(p<K, V> pVar, r rVar) {
        this.oKU = pVar;
        this.oKV = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.oKU.bu(k);
        if (bu == null) {
            this.oKV.ejy();
        } else {
            this.oKV.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.oKV.ejz();
        return this.oKU.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.oKU.b(hVar);
    }
}
