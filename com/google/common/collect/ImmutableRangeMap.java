package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.o0;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements o0<K, V>, Serializable {
    public static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    public static final long serialVersionUID = 0;
    public final transient ImmutableList<Range<K>> ranges;
    public final transient ImmutableList<V> values;

    /* loaded from: classes6.dex */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            a aVar = new a();
            c1<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                aVar.b(next.getKey(), next.getValue());
            }
            return aVar.a();
        }

        public Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<K extends Comparable<?>, V> {

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<Range<K>, V>> f30822a = Lists.i();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f30822a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f30822a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f30822a.size());
            for (int i = 0; i < this.f30822a.size(); i++) {
                Range<K> key = this.f30822a.get(i).getKey();
                if (i > 0) {
                    Range<K> key2 = this.f30822a.get(i - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                aVar.h(key);
                aVar2.h(this.f30822a.get(i).getValue());
            }
            return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
        }

        public a<K, V> b(Range<K> range, V v) {
            n.p(range);
            n.p(v);
            n.k(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f30822a.add(Maps.j(range, v));
            return this;
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(o0<K, ? extends V> o0Var) {
        if (o0Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) o0Var;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = o0Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            aVar.h(entry.getKey());
            aVar2.h(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof o0) {
            return asMapOfRanges().equals(((o0) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k) {
        int a2 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 != -1 && this.ranges.get(a2).contains(k)) {
            return this.values.get(a2);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k) {
        int a2 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a2);
        if (range.contains(k)) {
            return Maps.j(range, this.values.get(a2));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(o0<K, V> o0Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.create(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: asDescendingMapOfRanges */
    public ImmutableMap<Range<K>, V> m35asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.o0
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> m36subRangeMap(final Range<K> range) {
        n.p(range);
        if (range.isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        final int a2 = SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int a3 = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (a2 >= a3) {
            return of();
        }
        final int i = a3 - a2;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.List
            public Range<K> get(int i2) {
                n.n(i2, i);
                return (i2 == 0 || i2 == i + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i2 + a2)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i2 + a2);
            }
        }, this.values.subList(a2, a3)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap
            public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                return super.m35asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, d.g.c.c.o0
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.ImmutableRangeMap
            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range2) {
                if (range.isConnected(range2)) {
                    return this.m36subRangeMap((Range) range2.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }
}
