package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jGp;
    private final v jGq;

    public p(t<K, V> tVar, v vVar) {
        this.jGp = tVar;
        this.jGq = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aX(K k) {
        com.facebook.common.references.a<V> aX = this.jGp.aX(k);
        if (aX == null) {
            this.jGq.cwn();
        } else {
            this.jGq.aU(k);
        }
        return aX;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jGq.cwo();
        return this.jGp.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jGp.b(predicate);
    }
}
