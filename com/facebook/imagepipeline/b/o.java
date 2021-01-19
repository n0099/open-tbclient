package com.facebook.imagepipeline.b;
/* loaded from: classes3.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> pxt;
    private final r pxu;

    public o(p<K, V> pVar, r rVar) {
        this.pxt = pVar;
        this.pxu = rVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> bu(K k) {
        com.facebook.common.references.a<V> bu = this.pxt.bu(k);
        if (bu == null) {
            this.pxu.etn();
        } else {
            this.pxu.br(k);
        }
        return bu;
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.pxu.eto();
        return this.pxt.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.b.p
    public boolean b(com.facebook.common.internal.h<K> hVar) {
        return this.pxt.b(hVar);
    }
}
