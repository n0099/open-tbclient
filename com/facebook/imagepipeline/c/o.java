package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> maS;
    private final r maT;

    public o(p<K, V> pVar, r rVar) {
        this.maS = pVar;
        this.maT = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> be(K k) {
        com.facebook.common.references.a<V> be = this.maS.be(k);
        if (be == null) {
            this.maT.dqk();
        } else {
            this.maT.bb(k);
        }
        return be;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.maT.dql();
        return this.maS.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.maS.b(hVar);
    }
}
