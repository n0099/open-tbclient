package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pHB;
    private final r pHC;

    public o(p<K, V> pVar, r rVar) {
        this.pHB = pVar;
        this.pHC = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pHB.bu(k);
        if (bu == null) {
            this.pHC.evF();
        } else {
            this.pHC.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pHC.evG();
        return this.pHB.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.pHB.c(hVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.pHB.d(hVar);
    }
}
