package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.g.c.a.n;
import d.g.c.c.i0;
import d.g.c.c.v0;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient long[] f31430e;
    public final transient RegularImmutableSortedSet<E> elementSet;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31431f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f31432g;

    /* renamed from: h  reason: collision with root package name */
    public static final long[] f31429h = {0};
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.f31430e = f31429h;
        this.f31431f = 0;
        this.f31432g = 0;
    }

    public final int a(int i2) {
        long[] jArr = this.f31430e;
        int i3 = this.f31431f;
        return (int) (jArr[(i3 + i2) + 1] - jArr[i3 + i2]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return a(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public i0.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public i0.a<E> getEntry(int i2) {
        return Multisets.g(this.elementSet.asList().get(i2), a(i2));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i2, int i3) {
        n.v(i2, i3, this.f31432g);
        if (i2 == i3) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i2 == 0 && i3 == this.f31432g) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i2, i3), this.f31430e, this.f31431f + i2, i3 - i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f31431f > 0 || this.f31432g < this.f31430e.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public i0.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f31432g - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public int size() {
        long[] jArr = this.f31430e;
        int i2 = this.f31431f;
        return Ints.j(jArr[this.f31432g + i2] - jArr[i2]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        n.p(boundType);
        return getSubMultiset(0, regularImmutableSortedSet.headIndex(e2, boundType == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        n.p(boundType);
        return getSubMultiset(regularImmutableSortedSet.tailIndex(e2, boundType == BoundType.CLOSED), this.f31432g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i2, int i3) {
        this.elementSet = regularImmutableSortedSet;
        this.f31430e = jArr;
        this.f31431f = i2;
        this.f31432g = i3;
    }
}
