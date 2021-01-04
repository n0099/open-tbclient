package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pAm;
    private final r pAn;

    public o(p<K, V> pVar, r rVar) {
        this.pAm = pVar;
        this.pAn = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pAm.bu(k);
        if (bu == null) {
            this.pAn.ewC();
        } else {
            this.pAn.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pAn.ewD();
        return this.pAm.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.pAm.b(hVar);
    }
}
