package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.h.c.a.n;
import d.h.c.c.i0;
import d.h.c.c.v0;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient long[] f31098e;
    public final transient RegularImmutableSortedSet<E> elementSet;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31099f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f31100g;

    /* renamed from: h  reason: collision with root package name */
    public static final long[] f31097h = {0};
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.f31098e = f31097h;
        this.f31099f = 0;
        this.f31100g = 0;
    }

    public final int a(int i) {
        long[] jArr = this.f31098e;
        int i2 = this.f31099f;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.h.c.c.i0
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return a(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public i0.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public i0.a<E> getEntry(int i) {
        return Multisets.g(this.elementSet.asList().get(i), a(i));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        n.v(i, i2, this.f31100g);
        if (i == i2) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i == 0 && i2 == this.f31100g) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i, i2), this.f31098e, this.f31099f + i, i2 - i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public /* bridge */ /* synthetic */ v0 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f31099f > 0 || this.f31100g < this.f31098e.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public i0.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f31100g - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public int size() {
        long[] jArr = this.f31098e;
        int i = this.f31099f;
        return Ints.j(jArr[this.f31100g + i] - jArr[i]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public /* bridge */ /* synthetic */ v0 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        n.p(boundType);
        return getSubMultiset(0, regularImmutableSortedSet.headIndex(e2, boundType == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.h.c.c.v0
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        n.p(boundType);
        return getSubMultiset(regularImmutableSortedSet.tailIndex(e2, boundType == BoundType.CLOSED), this.f31100g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, d.h.c.c.i0
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i, int i2) {
        this.elementSet = regularImmutableSortedSet;
        this.f31098e = jArr;
        this.f31099f = i;
        this.f31100g = i2;
    }
}
