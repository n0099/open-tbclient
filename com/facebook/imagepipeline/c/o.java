package com.facebook.imagepipeline.c;
/* loaded from: classes8.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> nul;
    private final r nun;

    public o(p<K, V> pVar, r rVar) {
        this.nul = pVar;
        this.nun = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bl(K k) {
        com.facebook.common.references.a<V> bl = this.nul.bl(k);
        if (bl == null) {
            this.nun.dRR();
        } else {
            this.nun.bi(k);
        }
        return bl;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.nun.dRS();
        return this.nul.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.nul.b(hVar);
    }
}
