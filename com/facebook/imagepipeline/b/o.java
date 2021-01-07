package com.facebook.imagepipeline.b;
/* loaded from: classes3.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pBT;
    private final r pBU;

    public o(p<K, V> pVar, r rVar) {
        this.pBT = pVar;
        this.pBU = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pBT.bu(k);
        if (bu == null) {
            this.pBU.exf();
        } else {
            this.pBU.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pBU.exg();
        return this.pBT.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.pBT.b(hVar);
    }
}
