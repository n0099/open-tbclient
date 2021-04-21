package com.google.common.collect;

import d.h.c.c.c1;
import d.h.c.c.g;
import d.h.c.c.n;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    public static final long serialVersionUID = 0;
    public final Range<C> range;

    /* loaded from: classes6.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public final DiscreteDomain<C> domain;
        public final Range<C> range;

        public /* synthetic */ SerializedForm(Range range, DiscreteDomain discreteDomain, a aVar) {
            this(range, discreteDomain);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }

        public SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            this.range = range;
            this.domain = discreteDomain;
        }
    }

    /* loaded from: classes6.dex */
    public class a extends g<C> {

        /* renamed from: f  reason: collision with root package name */
        public final C f31072f;

        public a(Comparable comparable) {
            super(comparable);
            this.f31072f = (C) RegularContiguousSet.this.last();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.g
        /* renamed from: b */
        public C a(C c2) {
            if (RegularContiguousSet.a(c2, this.f31072f)) {
                return null;
            }
            return RegularContiguousSet.this.domain.next(c2);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends g<C> {

        /* renamed from: f  reason: collision with root package name */
        public final C f31074f;

        public b(Comparable comparable) {
            super(comparable);
            this.f31074f = (C) RegularContiguousSet.this.first();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.g
        /* renamed from: b */
        public C a(C c2) {
            if (RegularContiguousSet.a(c2, this.f31074f)) {
                return null;
            }
            return RegularContiguousSet.this.domain.previous(c2);
        }
    }

    public RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    public static boolean a(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    public final ContiguousSet<C> b(Range<C> range) {
        return this.range.isConnected(range) ? ContiguousSet.create(this.range.intersection(range), this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return n.b(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        if (this.domain.supportsFastOffset) {
            return new ImmutableAsList<C>() { // from class: com.google.common.collect.RegularContiguousSet.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.ImmutableAsList
                public ImmutableSortedSet<C> delegateCollection() {
                    return RegularContiguousSet.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.List
                public C get(int i) {
                    d.h.c.a.n.n(i, size());
                    RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                    return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), i);
                }
            };
        }
        return super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.distance(first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        d.h.c.a.n.p(contiguousSet);
        d.h.c.a.n.d(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long distance = this.domain.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public c1<C> descendingIterator() {
        return new b(last());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C c2, boolean z) {
        return b(Range.upTo(c2, BoundType.forBoolean(z)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<C> iterator() {
        return new a(first());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
        if (c2.compareTo(c3) == 0 && !z && !z2) {
            return new EmptyContiguousSet(this.domain);
        }
        return b(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C c2, boolean z) {
        return b(Range.downTo(c2, BoundType.forBoolean(z)));
    }
}
