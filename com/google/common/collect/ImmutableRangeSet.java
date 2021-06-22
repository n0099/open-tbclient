package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.f;
import d.g.c.c.f0;
import d.g.c.c.m0;
import d.g.c.c.p0;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class ImmutableRangeSet<C extends Comparable> extends f<C> implements Serializable {
    public transient ImmutableRangeSet<C> complement;
    public final transient ImmutableList<Range<C>> ranges;
    public static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    public static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* loaded from: classes6.dex */
    public final class AsSet extends ImmutableSortedSet<C> {
        public final DiscreteDomain<C> domain;

        /* renamed from: e  reason: collision with root package name */
        public transient Integer f31240e;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<C> {

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Range<C>> f31241g;

            /* renamed from: h  reason: collision with root package name */
            public Iterator<C> f31242h = Iterators.h();

            public a() {
                this.f31241g = ImmutableRangeSet.this.ranges.iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public C a() {
                while (!this.f31242h.hasNext()) {
                    if (this.f31241g.hasNext()) {
                        this.f31242h = ContiguousSet.create(this.f31241g.next(), AsSet.this.domain).iterator();
                    } else {
                        return (C) b();
                    }
                }
                return this.f31242h.next();
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<C> {

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Range<C>> f31244g;

            /* renamed from: h  reason: collision with root package name */
            public Iterator<C> f31245h = Iterators.h();

            public b() {
                this.f31244g = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public C a() {
                while (!this.f31245h.hasNext()) {
                    if (this.f31244g.hasNext()) {
                        this.f31245h = ContiguousSet.create(this.f31244g.next(), AsSet.this.domain).descendingIterator();
                    } else {
                        return (C) b();
                    }
                }
                return this.f31245h.next();
            }
        }

        public AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
            return headSetImpl((AsSet) ((Comparable) obj), z);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.google.common.collect.Range */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (contains(obj)) {
                Comparable comparable = (Comparable) obj;
                long j = 0;
                c1 it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    Range range = (Range) it.next();
                    if (range.contains(comparable)) {
                        return Ints.j(j + ContiguousSet.create(range, this.domain).indexOf(comparable));
                    }
                    j += ContiguousSet.create(range, this.domain).size();
                }
                throw new AssertionError("impossible");
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.f31240e;
            if (num == null) {
                long j = 0;
                c1 it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    j += ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.j(j));
                this.f31240e = num;
            }
            return num.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.m38subRangeSet((Range) range).asSet(this.domain);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
            return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
            return tailSetImpl((AsSet) ((Comparable) obj), z);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public c1<C> descendingIterator() {
            return new b();
        }

        public ImmutableSortedSet<C> headSetImpl(C c2, boolean z) {
            return subSet(Range.upTo(c2, BoundType.forBoolean(z)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<C> iterator() {
            return new a();
        }

        public ImmutableSortedSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
            if (!z && !z2 && Range.compareOrThrow(c2, c3) == 0) {
                return ImmutableSortedSet.of();
            }
            return subSet(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
        }

        public ImmutableSortedSet<C> tailSetImpl(C c2, boolean z) {
            return subSet(Range.downTo(c2, BoundType.forBoolean(z)));
        }
    }

    /* loaded from: classes6.dex */
    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        public final DiscreteDomain<C> domain;
        public final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* loaded from: classes6.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        public final boolean positiveBoundedAbove;
        public final boolean positiveBoundedBelow;
        public final int size;

        public ComplementRanges() {
            this.positiveBoundedBelow = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) f0.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = this.positiveBoundedBelow ? size + 1 : size;
            this.size = this.positiveBoundedAbove ? size + 1 : size;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.List
        public Range<C> get(int i2) {
            Cut<C> cut;
            Cut<C> cut2;
            n.n(i2, this.size);
            if (!this.positiveBoundedBelow) {
                cut = ((Range) ImmutableRangeSet.this.ranges.get(i2)).upperBound;
            } else {
                cut = i2 == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i2 - 1)).upperBound;
            }
            if (!this.positiveBoundedAbove || i2 != this.size - 1) {
                cut2 = ((Range) ImmutableRangeSet.this.ranges.get(i2 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            } else {
                cut2 = Cut.aboveAll();
            }
            return Range.create(cut, cut2);
        }
    }

    /* loaded from: classes6.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    /* loaded from: classes6.dex */
    public static class a<C extends Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final List<Range<C>> f31247a = Lists.i();

        public a<C> a(Range<C> range) {
            n.k(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f31247a.add(range);
            return this;
        }

        public a<C> b(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                a(range);
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.a aVar = new ImmutableList.a(this.f31247a.size());
            Collections.sort(this.f31247a, Range.rangeLexOrdering());
            m0 p = Iterators.p(this.f31247a.iterator());
            while (p.hasNext()) {
                Range range = (Range) p.next();
                while (p.hasNext()) {
                    Range<C> range2 = (Range) p.peek();
                    if (range.isConnected(range2)) {
                        n.l(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) p.next());
                    }
                }
                aVar.h(range);
            }
            ImmutableList j = aVar.j();
            if (j.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (j.size() == 1 && ((Range) f0.h(j)).equals(Range.all())) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet<>(j);
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(p0<C> p0Var) {
        n.p(p0Var);
        if (p0Var.isEmpty()) {
            return of();
        }
        if (p0Var.encloses(Range.all())) {
            return all();
        }
        if (p0Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) p0Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) p0Var.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        int size;
        if (!this.ranges.isEmpty() && !range.isEmpty()) {
            if (range.encloses(span())) {
                return this.ranges;
            }
            final int a2 = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
            if (range.hasUpperBound()) {
                size = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            } else {
                size = this.ranges.size();
            }
            final int i2 = size - a2;
            if (i2 == 0) {
                return ImmutableList.of();
            }
            return (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.List
                public Range<C> get(int i3) {
                    n.n(i3, i2);
                    return (i3 == 0 || i3 == i2 + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i3 + a2)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(i3 + a2);
                }
            };
        }
        return ImmutableList.of();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // d.g.c.c.f
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.f
    @Deprecated
    public void addAll(p0<C> p0Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        n.p(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(p0<C> p0Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(p0Var);
        return copyOf(create);
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    public boolean encloses(Range<C> range) {
        int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b2 != -1 && this.ranges.get(b2).encloses(range);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(p0 p0Var) {
        return super.enclosesAll(p0Var);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(p0<C> p0Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(p0Var.complement());
        return copyOf(create);
    }

    @Override // d.g.c.c.f
    public boolean intersects(Range<C> range) {
        int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b2 >= this.ranges.size() || !this.ranges.get(b2).isConnected(range) || this.ranges.get(b2).intersection(range).isEmpty()) {
            if (b2 > 0) {
                int i2 = b2 - 1;
                if (this.ranges.get(i2).isConnected(range) && !this.ranges.get(i2).intersection(range).isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // d.g.c.c.f
    public Range<C> rangeContaining(C c2) {
        int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c2), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b2 != -1) {
            Range<C> range = this.ranges.get(b2);
            if (range.contains(c2)) {
                return range;
            }
            return null;
        }
        return null;
    }

    @Override // d.g.c.c.f
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    @Deprecated
    public void removeAll(p0<C> p0Var) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            Cut<C> cut = this.ranges.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.create(cut, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(p0<C> p0Var) {
        return unionOf(f0.c(asRanges(), p0Var.asRanges()));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        n.p(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // d.g.c.c.f
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: asDescendingSetOfRanges */
    public ImmutableSet<Range<C>> m37asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.p0
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.p0
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        } else if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        } else {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        }
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // d.g.c.c.f
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: subRangeSet */
    public ImmutableRangeSet<C> m38subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        a aVar = new a();
        aVar.b(iterable);
        return aVar.c();
    }
}
