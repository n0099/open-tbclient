package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.c.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* loaded from: classes6.dex */
    public final class CellSet extends IndexedImmutableSet<y0.a<R, C, V>> {
        public CellSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof y0.a) {
                y0.a aVar = (y0.a) obj;
                Object obj2 = RegularImmutableTable.this.get(aVar.getRowKey(), aVar.getColumnKey());
                return obj2 != null && obj2.equals(aVar.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableTable.this.size();
        }

        public /* synthetic */ CellSet(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.IndexedImmutableSet
        public y0.a<R, C, V> get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }
    }

    /* loaded from: classes6.dex */
    public final class Values extends ImmutableList<V> {
        public Values() {
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) RegularImmutableTable.this.getValue(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }

        public /* synthetic */ Values(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Comparator<y0.a<R, C, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Comparator f31101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Comparator f31102f;

        public a(Comparator comparator, Comparator comparator2) {
            this.f31101e = comparator;
            this.f31102f = comparator2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(y0.a<R, C, V> aVar, y0.a<R, C, V> aVar2) {
            Comparator comparator = this.f31101e;
            int compare = comparator == null ? 0 : comparator.compare(aVar.getRowKey(), aVar2.getRowKey());
            if (compare != 0) {
                return compare;
            }
            Comparator comparator2 = this.f31102f;
            if (comparator2 == null) {
                return 0;
            }
            return comparator2.compare(aVar.getColumnKey(), aVar2.getColumnKey());
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> a(Iterable<y0.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        ImmutableSet copyOf;
        ImmutableSet copyOf2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf3 = ImmutableList.copyOf(iterable);
        for (y0.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.getRowKey());
            linkedHashSet2.add(aVar.getColumnKey());
        }
        if (comparator == null) {
            copyOf = ImmutableSet.copyOf((Collection) linkedHashSet);
        } else {
            copyOf = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            copyOf2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
        } else {
            copyOf2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return forOrderedComponents(copyOf3, copyOf, copyOf2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<y0.a<R, C, V>> list, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        n.p(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new a(comparator, comparator2));
        }
        return a(list, comparator, comparator2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<y0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public final void checkNoDuplicate(R r, C c2, V v, V v2) {
        n.m(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c2, v2, v);
    }

    public abstract y0.a<R, C, V> getCell(int i);

    public abstract V getValue(int i);

    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public abstract /* synthetic */ int size();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.i
    public final ImmutableSet<y0.a<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet(this, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.i
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values(this, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<y0.a<R, C, V>> iterable) {
        return a(iterable, null, null);
    }
}
