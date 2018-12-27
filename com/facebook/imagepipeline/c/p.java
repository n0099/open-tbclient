package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
/* loaded from: classes2.dex */
public class p<K, V> implements t<K, V> {
    private final t<K, V> ipi;
    private final v ipj;

    public p(t<K, V> tVar, v vVar) {
        this.ipi = tVar;
        this.ipj = vVar;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> aH(K k) {
        com.facebook.common.references.a<V> aH = this.ipi.aH(k);
        if (aH == null) {
            this.ipj.bWu();
        } else {
            this.ipj.aE(k);
        }
        return aH;
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        this.ipj.bWv();
        return this.ipi.a(k, aVar);
    }

    @Override // com.facebook.imagepipeline.c.t
    public boolean b(Predicate<K> predicate) {
        return this.ipi.b(predicate);
    }
}
