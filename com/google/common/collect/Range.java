package com.google.common.collect;

import com.baidu.android.common.others.IStringUtil;
import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.a.o;
import d.g.c.c.f0;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements o<C>, Serializable {
    public static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    public static final long serialVersionUID = 0;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* loaded from: classes6.dex */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        public static final long serialVersionUID = 0;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return d.g.c.c.o.f().d(range.lowerBound, range2.lowerBound).d(range.upperBound, range2.upperBound).e();
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30974a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f30974a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30974a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements g<Range, Cut> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f30975e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements g<Range, Cut> {

        /* renamed from: e  reason: collision with root package name */
        public static final c f30976e = new c();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    public Range(Cut<C> cut, Cut<C> cut2) {
        n.p(cut);
        this.lowerBound = cut;
        n.p(cut2);
        this.upperBound = cut2;
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        return create(Cut.belowValue(c2), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        return create(Cut.belowAll(), Cut.aboveValue(c2));
    }

    public static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        return create(Cut.belowValue(c2), Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        return create(Cut.belowValue(c2), Cut.belowValue(c3));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        int i = a.f30974a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return atLeast(c2);
            }
            throw new AssertionError();
        }
        return greaterThan(c2);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        n.p(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) cast.first(), (Comparable) cast.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        C next = it.next();
        n.p(next);
        C c2 = next;
        Comparable comparable = c2;
        while (it.hasNext()) {
            C next2 = it.next();
            n.p(next2);
            C c3 = next2;
            c2 = (Comparable) Ordering.natural().min(c2, c3);
            comparable = (Comparable) Ordering.natural().max(comparable, c3);
        }
        return closed(c2, comparable);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        return create(Cut.aboveValue(c2), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        return create(Cut.belowAll(), Cut.belowValue(c2));
    }

    public static <C extends Comparable<?>> g<Range<C>, Cut<C>> lowerBoundFn() {
        return b.f30975e;
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        return create(Cut.aboveValue(c2), Cut.belowValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        return create(Cut.aboveValue(c2), Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        n.p(boundType);
        n.p(boundType2);
        return create(boundType == BoundType.OPEN ? Cut.aboveValue(c2) : Cut.belowValue(c2), boundType2 == BoundType.OPEN ? Cut.belowValue(c3) : Cut.aboveValue(c3));
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        return closed(c2, c2);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        int i = a.f30974a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return atMost(c2);
            }
            throw new AssertionError();
        }
        return lessThan(c2);
    }

    public static <C extends Comparable<?>> g<Range<C>, Cut<C>> upperBoundFn() {
        return c.f30976e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.a.o
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        n.p(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public boolean contains(C c2) {
        n.p(c2);
        return this.lowerBound.isLessThan(c2) && !this.upperBound.isLessThan(c2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (f0.i(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) cast.first()) && contains((Comparable) cast.last());
            }
        }
        for (C c2 : iterable) {
            if (!contains(c2)) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    @Override // d.g.c.a.o
    public boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
        }
        return false;
    }

    public Range<C> gap(Range<C> range) {
        boolean z = this.lowerBound.compareTo((Cut) range.lowerBound) < 0;
        Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo < 0 || compareTo2 > 0) {
            if (compareTo > 0 || compareTo2 < 0) {
                return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
            }
            return range;
        }
        return this;
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo > 0 || compareTo2 < 0) {
            if (compareTo < 0 || compareTo2 > 0) {
                return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
            }
            return range;
        }
        return this;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    public static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append(IStringUtil.TOP_PATH);
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    @Deprecated
    public boolean apply(C c2) {
        return contains(c2);
    }
}
