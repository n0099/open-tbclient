package com.google.common.collect;

import d.h.c.a.r;
import d.h.c.c.m;
import d.h.c.c.n0;
import java.io.Serializable;
import java.util.Set;
/* loaded from: classes6.dex */
public final class MultimapBuilder$HashSetSupplier<V> implements r<Set<V>>, Serializable {
    public final int expectedValuesPerKey;

    public MultimapBuilder$HashSetSupplier(int i) {
        m.b(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.r
    public Set<V> get() {
        return n0.d(this.expectedValuesPerKey);
    }
}
