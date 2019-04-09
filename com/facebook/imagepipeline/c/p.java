package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> jFC;
    private final v jFD;

    public p(t<K, V> tVar, v vVar) {
        this.jFC = tVar;
        this.jFD = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aT(K k) {
        com.facebook.common.references.a<V> aT = this.jFC.aT(k);
        if (aT == null) {
            this.jFD.cwj();
        } else {
            this.jFD.aQ(k);
        }
        return aT;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.jFD.cwk();
        return this.jFC.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.jFC.b(predicate);
    }
}
