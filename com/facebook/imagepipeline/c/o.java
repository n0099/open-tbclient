package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> mRV;
    private final r mRW;

    public o(p<K, V> pVar, r rVar) {
        this.mRV = pVar;
        this.mRW = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bj(K k) {
        com.facebook.common.references.a<V> bj = this.mRV.bj(k);
        if (bj == null) {
            this.mRW.dCw();
        } else {
            this.mRW.bg(k);
        }
        return bj;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.mRW.dCx();
        return this.mRV.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.mRV.b(hVar);
    }
}
