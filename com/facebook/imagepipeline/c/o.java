package com.facebook.imagepipeline.c;
/* loaded from: classes10.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lQx;
    private final r lQy;

    public o(p<K, V> pVar, r rVar) {
        this.lQx = pVar;
        this.lQy = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bl(K k) {
        com.facebook.common.references.a<V> bl = this.lQx.bl(k);
        if (bl == null) {
            this.lQy.dmA();
        } else {
            this.lQy.bi(k);
        }
        return bl;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lQy.dmB();
        return this.lQx.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lQx.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lQx.d(hVar);
    }
}
