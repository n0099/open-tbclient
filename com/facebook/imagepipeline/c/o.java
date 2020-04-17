package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> maO;
    private final r maP;

    public o(p<K, V> pVar, r rVar) {
        this.maO = pVar;
        this.maP = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bd(K k) {
        com.facebook.common.references.a<V> bd = this.maO.bd(k);
        if (bd == null) {
            this.maP.dqm();
        } else {
            this.maP.ba(k);
        }
        return bd;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.maP.dqn();
        return this.maO.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.maO.b(hVar);
    }
}
