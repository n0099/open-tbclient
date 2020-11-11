package com.facebook.imagepipeline.c;
/* loaded from: classes18.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> oUn;
    private final r oUo;

    public o(p<K, V> pVar, r rVar) {
        this.oUn = pVar;
        this.oUo = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.oUn.bu(k);
        if (bu == null) {
            this.oUo.eno();
        } else {
            this.oUo.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.oUo.enp();
        return this.oUn.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.oUn.b(hVar);
    }
}
