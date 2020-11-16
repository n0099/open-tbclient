package com.facebook.imagepipeline.c;
/* loaded from: classes15.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> oVQ;
    private final r oVR;

    public o(p<K, V> pVar, r rVar) {
        this.oVQ = pVar;
        this.oVR = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bv(K k) {
        com.facebook.common.references.a<V> bv = this.oVQ.bv(k);
        if (bv == null) {
            this.oVR.enm();
        } else {
            this.oVR.bs(k);
        }
        return bv;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.oVR.enn();
        return this.oVQ.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.oVQ.b(hVar);
    }
}
