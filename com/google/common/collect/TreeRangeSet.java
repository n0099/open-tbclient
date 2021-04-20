package com.google.common.collect;

import d.g.c.a.j;
import d.g.c.a.n;
import d.g.c.c.f;
import d.g.c.c.m0;
import d.g.c.c.p0;
import d.g.c.c.r;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient p0<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes6.dex */
    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.p0
        public p0<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public boolean contains(C c2) {
            return !TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* loaded from: classes6.dex */
    public final class SubRangeSet extends TreeRangeSet<C> {
        public final Range<C> restriction;

        public SubRangeSet(Range<C> range) {
            super(new e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public void add(Range<C> range) {
            n.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public boolean contains(C c2) {
            return this.restriction.contains(c2) && TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f, d.g.c.c.p0
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public Range<C> rangeContaining(C c2) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c2) && (rangeContaining = TreeRangeSet.this.rangeContaining(c2)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.g.c.c.f
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public p0<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends r<Range<C>> implements Set<Range<C>> {

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Range<C>> f31069e;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f31069e = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.r, d.g.c.c.y
        public Collection<Range<C>> delegate() {
            return this.f31069e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<C extends Comparable<?>> extends d.g.c.c.e<Cut<C>, Range<C>> {

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f31070e;

        /* renamed from: f  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f31071f;

        /* renamed from: g  reason: collision with root package name */
        public final Range<Cut<C>> f31072g;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f31073g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f31074h;
            public final /* synthetic */ m0 i;

            public a(Cut cut, m0 m0Var) {
                this.f31074h = cut;
                this.i = m0Var;
                this.f31073g = this.f31074h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range create;
                if (!c.this.f31072g.upperBound.isLessThan(this.f31073g) && this.f31073g != Cut.aboveAll()) {
                    if (this.i.hasNext()) {
                        Range range = (Range) this.i.next();
                        create = Range.create(this.f31073g, range.lowerBound);
                        this.f31073g = range.upperBound;
                    } else {
                        create = Range.create(this.f31073g, Cut.aboveAll());
                        this.f31073g = Cut.aboveAll();
                    }
                    return Maps.j(create.lowerBound, create);
                }
                return (Map.Entry) b();
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f31075g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f31076h;
            public final /* synthetic */ m0 i;

            public b(Cut cut, m0 m0Var) {
                this.f31076h = cut;
                this.i = m0Var;
                this.f31075g = this.f31076h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.f31075g == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (!this.i.hasNext()) {
                    if (c.this.f31072g.lowerBound.isLessThan(Cut.belowAll())) {
                        Range create = Range.create(Cut.belowAll(), this.f31075g);
                        this.f31075g = Cut.belowAll();
                        return Maps.j(Cut.belowAll(), create);
                    }
                } else {
                    Range range = (Range) this.i.next();
                    Range create2 = Range.create(range.upperBound, this.f31075g);
                    this.f31075g = range.lowerBound;
                    if (c.this.f31072g.lowerBound.isLessThan(create2.lowerBound)) {
                        return Maps.j(create2.lowerBound, create2);
                    }
                }
                return (Map.Entry) b();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            Cut cut;
            if (this.f31072g.hasLowerBound()) {
                values = this.f31071f.tailMap(this.f31072g.lowerEndpoint(), this.f31072g.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.f31071f.values();
            }
            m0 p = Iterators.p(values.iterator());
            if (this.f31072g.contains(Cut.belowAll()) && (!p.hasNext() || ((Range) p.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (p.hasNext()) {
                cut = ((Range) p.next()).upperBound;
            } else {
                return Iterators.h();
            }
            return new a(cut, p);
        }

        @Override // d.g.c.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Cut<C> aboveAll;
            Cut<C> higherKey;
            if (this.f31072g.hasUpperBound()) {
                aboveAll = this.f31072g.upperEndpoint();
            } else {
                aboveAll = Cut.aboveAll();
            }
            m0 p = Iterators.p(this.f31071f.headMap(aboveAll, this.f31072g.hasUpperBound() && this.f31072g.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (p.hasNext()) {
                if (((Range) p.peek()).upperBound == Cut.aboveAll()) {
                    higherKey = ((Range) p.next()).lowerBound;
                } else {
                    higherKey = this.f31070e.higherKey(((Range) p.peek()).upperBound);
                }
            } else if (this.f31072g.contains(Cut.belowAll()) && !this.f31070e.containsKey(Cut.belowAll())) {
                higherKey = this.f31070e.higherKey(Cut.belowAll());
            } else {
                return Iterators.h();
            }
            return new b((Cut) j.a(higherKey, Cut.aboveAll()), p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.f31072g.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f31070e, range.intersection(this.f31072g));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.u(a());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f31070e = navigableMap;
            this.f31071f = new d(navigableMap);
            this.f31072g = range;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<C extends Comparable<?>> extends d.g.c.c.e<Cut<C>, Range<C>> {

        /* renamed from: e  reason: collision with root package name */
        public final Range<Cut<C>> f31083e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<C> f31084f;

        /* renamed from: g  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f31085g;

        /* renamed from: h  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f31086h;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f31087g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f31088h;

            public a(Iterator it, Cut cut) {
                this.f31087g = it;
                this.f31088h = cut;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f31087g.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f31087g.next();
                if (!this.f31088h.isLessThan(range.lowerBound)) {
                    Range intersection = range.intersection(e.this.f31084f);
                    return Maps.j(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f31089g;

            public b(Iterator it) {
                this.f31089g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f31089g.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f31089g.next();
                if (e.this.f31084f.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                    Range intersection = range.intersection(e.this.f31084f);
                    if (e.this.f31083e.contains(intersection.lowerBound)) {
                        return Maps.j(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) b();
            }
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.f31084f.isEmpty()) {
                return Iterators.h();
            }
            if (this.f31083e.upperBound.isLessThan(this.f31084f.lowerBound)) {
                return Iterators.h();
            }
            if (this.f31083e.lowerBound.isLessThan(this.f31084f.lowerBound)) {
                it = this.f31086h.tailMap(this.f31084f.lowerBound, false).values().iterator();
            } else {
                it = this.f31085g.tailMap(this.f31083e.lowerBound.endpoint(), this.f31083e.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new a(it, (Cut) Ordering.natural().min(this.f31083e.upperBound, Cut.belowValue(this.f31084f.upperBound)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.g.c.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            if (this.f31084f.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f31083e.upperBound, Cut.belowValue(this.f31084f.upperBound));
            return new b(this.f31085g.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f31083e.contains(cut) && cut.compareTo(this.f31084f.lowerBound) >= 0 && cut.compareTo(this.f31084f.upperBound) < 0) {
                        if (cut.equals(this.f31084f.lowerBound)) {
                            Range range = (Range) Maps.M(this.f31085g.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f31084f.lowerBound) > 0) {
                                return range.intersection(this.f31084f);
                            }
                        } else {
                            Range range2 = (Range) this.f31085g.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f31084f);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!range.isConnected(this.f31083e)) {
                return ImmutableSortedMap.of();
            }
            return new e(this.f31083e.intersection(range), this.f31084f, this.f31085g);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.u(a());
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            n.p(range);
            this.f31083e = range;
            n.p(range2);
            this.f31084f = range2;
            n.p(navigableMap);
            this.f31085g = navigableMap;
            this.f31086h = new d(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        n.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // d.g.c.c.f
    public void add(Range<C> range) {
        n.p(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ void addAll(p0 p0Var) {
        super.addAll(p0Var);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set == null) {
            b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
            this.asDescendingSetOfRanges = bVar;
            return bVar;
        }
        return set;
    }

    @Override // d.g.c.c.p0
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set == null) {
            b bVar = new b(this, this.rangesByLowerBound.values());
            this.asRanges = bVar;
            return bVar;
        }
        return set;
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // d.g.c.c.p0
    public p0<C> complement() {
        p0<C> p0Var = this.complement;
        if (p0Var == null) {
            Complement complement = new Complement();
            this.complement = complement;
            return complement;
        }
        return p0Var;
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    public boolean encloses(Range<C> range) {
        n.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(p0 p0Var) {
        return super.enclosesAll(p0Var);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // d.g.c.c.f
    public boolean intersects(Range<C> range) {
        n.p(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry == null || !ceilingEntry.getValue().isConnected(range) || ceilingEntry.getValue().intersection(range).isEmpty()) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
        }
        return true;
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // d.g.c.c.f
    public Range<C> rangeContaining(C c2) {
        n.p(c2);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c2));
        if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // d.g.c.c.f
    public void remove(Range<C> range) {
        n.p(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // d.g.c.c.f, d.g.c.c.p0
    public /* bridge */ /* synthetic */ void removeAll(p0 p0Var) {
        super.removeAll(p0Var);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    public p0<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }

    public TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(p0<C> p0Var) {
        TreeRangeSet<C> create = create();
        create.addAll(p0Var);
        return create;
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // d.g.c.c.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* loaded from: classes6.dex */
    public static final class d<C extends Comparable<?>> extends d.g.c.c.e<Cut<C>, Range<C>> {

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f31077e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<Cut<C>> f31078f;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f31079g;

            public a(Iterator it) {
                this.f31079g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f31079g.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f31079g.next();
                if (d.this.f31078f.upperBound.isLessThan(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return Maps.j(range.upperBound, range);
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ m0 f31081g;

            public b(m0 m0Var) {
                this.f31081g = m0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f31081g.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f31081g.next();
                if (d.this.f31078f.lowerBound.isLessThan(range.upperBound)) {
                    return Maps.j(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f31077e = navigableMap;
            this.f31078f = Range.all();
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.f31078f.hasLowerBound()) {
                it = this.f31077e.values().iterator();
            } else {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f31077e.lowerEntry(this.f31078f.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.f31077e.values().iterator();
                } else if (this.f31078f.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                    it = this.f31077e.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f31077e.tailMap(this.f31078f.lowerEndpoint(), true).values().iterator();
                }
            }
            return new a(it);
        }

        @Override // d.g.c.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Collection<Range<C>> values;
            if (this.f31078f.hasUpperBound()) {
                values = this.f31077e.headMap(this.f31078f.upperEndpoint(), false).descendingMap().values();
            } else {
                values = this.f31077e.descendingMap().values();
            }
            m0 p = Iterators.p(values.iterator());
            if (p.hasNext() && this.f31078f.upperBound.isLessThan(((Range) p.peek()).upperBound)) {
                p.next();
            }
            return new b(p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Range<C> get(Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f31078f.contains(cut) && (lowerEntry = this.f31077e.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (range.isConnected(this.f31078f)) {
                return new d(this.f31077e, range.intersection(this.f31078f));
            }
            return ImmutableSortedMap.of();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f31078f.equals(Range.all())) {
                return this.f31077e.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f31078f.equals(Range.all())) {
                return this.f31077e.size();
            }
            return Iterators.u(a());
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f31077e = navigableMap;
            this.f31078f = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
