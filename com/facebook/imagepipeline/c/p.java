package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> ilW;
    private final v ilX;

    public p(t<K, V> tVar, v vVar) {
        this.ilW = tVar;
        this.ilX = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.ilW.aH(k);
        if (aH == null) {
            this.ilX.bVE();
        } else {
            this.ilX.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.ilX.bVF();
        return this.ilW.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.ilW.b(predicate);
    }
}
