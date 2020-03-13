package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> lRw;
    private final r lRx;

    public o(p<K, V> pVar, r rVar) {
        this.lRw = pVar;
        this.lRx = rVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> bn(K k) {
        com.facebook.common.references.a<V> bn = this.lRw.bn(k);
        if (bn == null) {
            this.lRx.dnS();
        } else {
            this.lRx.bk(k);
        }
        return bn;
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.lRx.dnT();
        return this.lRw.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        return this.lRw.c(hVar);
    }

    @Override // com.facebook.imagepipeline.c.p
    public boolean d(com.facebook.common.internal.h<K> hVar) {
        return this.lRw.d(hVar);
    }
}
