package com.facebook.imagepipeline.b;
/* loaded from: classes3.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pxs;
    private final r pxt;

    public o(p<K, V> pVar, r rVar) {
        this.pxs = pVar;
        this.pxt = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pxs.bu(k);
        if (bu == null) {
            this.pxt.etn();
        } else {
            this.pxt.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pxt.eto();
        return this.pxs.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.pxs.b(hVar);
    }
}
