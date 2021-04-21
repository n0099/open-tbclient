package com.google.common.collect;

import d.h.c.a.r;
import d.h.c.c.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class MultimapBuilder$ArrayListSupplier<V> implements r<List<V>>, Serializable {
    public final int expectedValuesPerKey;

    public MultimapBuilder$ArrayListSupplier(int i) {
        m.b(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.r
    public List<V> get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
