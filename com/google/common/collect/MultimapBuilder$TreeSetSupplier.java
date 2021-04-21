package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.a.r;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public final class MultimapBuilder$TreeSetSupplier<V> implements r<SortedSet<V>>, Serializable {
    public final Comparator<? super V> comparator;

    public MultimapBuilder$TreeSetSupplier(Comparator<? super V> comparator) {
        n.p(comparator);
        this.comparator = comparator;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.r
    public SortedSet<V> get() {
        return new TreeSet(this.comparator);
    }
}
