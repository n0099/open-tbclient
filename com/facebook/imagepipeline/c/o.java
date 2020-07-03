package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> mRS;
    private final r mRT;

    public o(p<K, V> pVar, r rVar) {
        this.mRS = pVar;
        this.mRT = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bj(K k) {
        com.facebook.common.references.a<V> bj = this.mRS.bj(k);
        if (bj == null) {
            this.mRT.dCs();
        } else {
            this.mRT.bg(k);
        }
        return bj;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.mRT.dCt();
        return this.mRS.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.mRS.b(hVar);
    }
}
