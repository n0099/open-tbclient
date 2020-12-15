package com.facebook.imagepipeline.b;
/* loaded from: classes15.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pkI;
    private final r pkJ;

    public o(p<K, V> pVar, r rVar) {
        this.pkI = pVar;
        this.pkJ = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pkI.bu(k);
        if (bu == null) {
            this.pkJ.esV();
        } else {
            this.pkJ.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pkJ.esW();
        return this.pkI.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.pkI.b(hVar);
    }
}
