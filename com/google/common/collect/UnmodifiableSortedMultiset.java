package com.google.common.collect;

import com.google.common.collect.Multisets;
import d.g.c.c.i0;
import d.g.c.c.v0;
import java.util.Comparator;
import java.util.NavigableSet;
/* loaded from: classes6.dex */
public final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements v0<E> {
    public static final long serialVersionUID = 0;

    /* renamed from: e  reason: collision with root package name */
    public transient UnmodifiableSortedMultiset<E> f31338e;

    public UnmodifiableSortedMultiset(v0<E> v0Var) {
        super(v0Var);
    }

    @Override // d.g.c.c.v0, d.g.c.c.t0
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // d.g.c.c.v0
    public v0<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.f31338e;
        if (unmodifiableSortedMultiset == null) {
            UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
            unmodifiableSortedMultiset2.f31338e = this;
            this.f31338e = unmodifiableSortedMultiset2;
            return unmodifiableSortedMultiset2;
        }
        return unmodifiableSortedMultiset;
    }

    @Override // d.g.c.c.v0
    public i0.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // d.g.c.c.v0
    public v0<E> headMultiset(E e2, BoundType boundType) {
        return Multisets.p(delegate().headMultiset(e2, boundType));
    }

    @Override // d.g.c.c.v0
    public i0.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // d.g.c.c.v0
    public i0.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.v0
    public i0.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.v0
    public v0<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        return Multisets.p(delegate().subMultiset(e2, boundType, e3, boundType2));
    }

    @Override // d.g.c.c.v0
    public v0<E> tailMultiset(E e2, BoundType boundType) {
        return Multisets.p(delegate().tailMultiset(e2, boundType));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return Sets.i(delegate().elementSet());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, d.g.c.c.x, d.g.c.c.i0
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, d.g.c.c.x, d.g.c.c.r, d.g.c.c.y
    public v0<E> delegate() {
        return (v0) super.delegate();
    }
}
