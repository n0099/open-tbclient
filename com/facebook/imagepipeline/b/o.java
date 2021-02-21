package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pIb;
    private final r pIc;

    public o(p<K, V> pVar, r rVar) {
        this.pIb = pVar;
        this.pIc = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pIb.bu(k);
        if (bu == null) {
            this.pIc.evN();
        } else {
            this.pIc.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pIc.evO();
        return this.pIb.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.pIb.c(hVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.pIb.d(hVar);
    }
}
