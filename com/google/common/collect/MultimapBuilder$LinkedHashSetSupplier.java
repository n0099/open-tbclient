package com.google.common.collect;

import d.g.c.a.r;
import d.g.c.c.m;
import d.g.c.c.n0;
import java.io.Serializable;
import java.util.Set;
/* loaded from: classes6.dex */
public final class MultimapBuilder$LinkedHashSetSupplier<V> implements r<Set<V>>, Serializable {
    public final int expectedValuesPerKey;

    public MultimapBuilder$LinkedHashSetSupplier(int i2) {
        m.b(i2, "expectedValuesPerKey");
        this.expectedValuesPerKey = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.a.r
    public Set<V> get() {
        return n0.f(this.expectedValuesPerKey);
    }
}
