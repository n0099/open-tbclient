package com.google.common.collect;

import d.h.c.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterable iterable) {
        return max((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterable iterable) {
        return min((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        n.p(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterator it) {
        return max((Iterator<Comparable>) it);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterator it) {
        return min((Iterator<Comparable>) it);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e2, E e3) {
        return (E) NaturalOrdering.INSTANCE.min(e2, e3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e2, E e3) {
        return (E) NaturalOrdering.INSTANCE.max(e2, e3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e2, E e3, E e4, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e2, e3, e4, eArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e2, E e3, E e4, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e2, e3, e4, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
