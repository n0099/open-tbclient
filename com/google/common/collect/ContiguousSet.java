package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import d.h.c.a.n;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    public final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i, int i2) {
        return create(Range.closed(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Integer> closedOpen(int i, int i2) {
        return create(Range.closedOpen(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        n.p(range);
        n.p(discreteDomain);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
        } catch (NoSuchElementException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> headSetImpl(C c2, boolean z);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    public abstract ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> tailSetImpl(C c2, boolean z);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public static ContiguousSet<Long> closed(long j, long j2) {
        return create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        return create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public ContiguousSet<C> headSet(C c2) {
        n.p(c2);
        return headSetImpl((ContiguousSet<C>) c2, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c2, C c3) {
        n.p(c2);
        n.p(c3);
        n.d(comparator().compare(c2, c3) <= 0);
        return subSetImpl((boolean) c2, true, (boolean) c3, false);
    }

    public ContiguousSet<C> tailSet(C c2) {
        n.p(c2);
        return tailSetImpl((ContiguousSet<C>) c2, true);
    }

    public ContiguousSet<C> headSet(C c2, boolean z) {
        n.p(c2);
        return headSetImpl((ContiguousSet<C>) c2, z);
    }

    public ContiguousSet<C> tailSet(C c2, boolean z) {
        n.p(c2);
        return tailSetImpl((ContiguousSet<C>) c2, z);
    }

    public ContiguousSet<C> subSet(C c2, boolean z, C c3, boolean z2) {
        n.p(c2);
        n.p(c3);
        n.d(comparator().compare(c2, c3) <= 0);
        return subSetImpl((boolean) c2, z, (boolean) c3, z2);
    }
}
