package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;
/* loaded from: classes6.dex */
public abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    @Deprecated
    public static <E> ImmutableSortedMultiset.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public abstract /* synthetic */ int count(Object obj);

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
