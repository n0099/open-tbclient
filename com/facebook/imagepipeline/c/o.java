package com.facebook.imagepipeline.c;
/* loaded from: classes10.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lQC;
    private final r lQD;

    public o(p<K, V> pVar, r rVar) {
        this.lQC = pVar;
        this.lQD = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bl(K k) {
        com.facebook.common.references.a<V> bl = this.lQC.bl(k);
        if (bl == null) {
            this.lQD.dmC();
        } else {
            this.lQD.bi(k);
        }
        return bl;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lQD.dmD();
        return this.lQC.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lQC.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lQC.d(hVar);
    }
}
