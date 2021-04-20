package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes6.dex */
public final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    public static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <S> Ordering<S> reverse() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        return Lists.j(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
