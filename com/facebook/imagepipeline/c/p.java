package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> kgx;
    private final v kgy;

    public p(t<K, V> tVar, v vVar) {
        this.kgx = tVar;
        this.kgy = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aQ(K k) {
        com.facebook.common.references.a<V> aQ = this.kgx.aQ(k);
        if (aQ == null) {
            this.kgy.cFn();
        } else {
            this.kgy.aN(k);
        }
        return aQ;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.kgy.cFo();
        return this.kgx.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.kgx.b(predicate);
    }
}
