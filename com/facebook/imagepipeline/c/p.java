package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jFB;
    private final v jFC;

    public p(t<K, V> tVar, v vVar) {
        this.jFB = tVar;
        this.jFC = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aT(K k) {
        com.facebook.common.references.a<V> aT = this.jFB.aT(k);
        if (aT == null) {
            this.jFC.cwj();
        } else {
            this.jFC.aQ(k);
        }
        return aT;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jFC.cwk();
        return this.jFB.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jFB.b(predicate);
    }
}
