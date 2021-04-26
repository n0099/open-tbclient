package com.google.common.collect;

import com.google.common.collect.Maps;
import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.a.r;
import d.g.c.c.f0;
import d.g.c.c.y0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    public static final long serialVersionUID = 0;
    public final Comparator<? super C> columnComparator;

    /* loaded from: classes6.dex */
    public static class Factory<C, V> implements r<TreeMap<C, V>>, Serializable {
        public static final long serialVersionUID = 0;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements g<Map<C, V>, Iterator<C>> {
        public a(TreeBasedTable treeBasedTable) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractIterator<C> {

        /* renamed from: g  reason: collision with root package name */
        public C f32115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Iterator f32116h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Comparator f32117i;

        public b(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f32116h = it;
            this.f32117i = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            boolean z;
            while (this.f32116h.hasNext()) {
                C c2 = (C) this.f32116h.next();
                C c3 = this.f32115g;
                if (c3 == null || this.f32117i.compare(c2, c3) != 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    this.f32115g = c2;
                    return c2;
                }
            }
            this.f32115g = null;
            return b();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        /* renamed from: h  reason: collision with root package name */
        public final C f32118h;

        /* renamed from: i  reason: collision with root package name */
        public final C f32119i;
        public transient SortedMap<C, V> j;

        public c(TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.g
        public void d() {
            if (k() == null || !this.j.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f32096e);
            this.j = null;
            this.f32097f = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: f */
        public SortedMap<C, V> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (b() != null) {
                return b().firstKey();
            }
            throw new NoSuchElementException();
        }

        public int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: h */
        public SortedMap<C, V> c() {
            SortedMap<C, V> k = k();
            if (k != null) {
                C c2 = this.f32118h;
                if (c2 != null) {
                    k = k.tailMap(c2);
                }
                C c3 = this.f32119i;
                return c3 != null ? k.headMap(c3) : k;
            }
            return null;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c2) {
            n.p(c2);
            n.d(j(c2));
            return new c(this.f32096e, this.f32118h, c2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: i */
        public SortedSet<C> keySet() {
            return new Maps.o(this);
        }

        public boolean j(Object obj) {
            C c2;
            C c3;
            return obj != null && ((c2 = this.f32118h) == null || g(c2, obj) <= 0) && ((c3 = this.f32119i) == null || g(c3, obj) > 0);
        }

        public SortedMap<C, V> k() {
            SortedMap<C, V> sortedMap = this.j;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f32096e))) {
                this.j = (SortedMap) TreeBasedTable.this.backingMap.get(this.f32096e);
            }
            return this.j;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (b() != null) {
                return b().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            n.p(c2);
            n.d(j(c2));
            return (V) super.put(c2, v);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c2, C c3) {
            boolean z;
            n.p(c2);
            if (j(c2)) {
                n.p(c3);
                if (j(c3)) {
                    z = true;
                    n.d(z);
                    return new c(this.f32096e, c2, c3);
                }
            }
            z = false;
            n.d(z);
            return new c(this.f32096e, c2, c3);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c2) {
            n.p(c2);
            n.d(j(c2));
            return new c(this.f32096e, c2, this.f32119i);
        }

        public c(R r, C c2, C c3) {
            super(r);
            this.f32118h = c2;
            this.f32119i = c3;
            n.d(c2 == null || c3 == null || g(c2, c3) <= 0);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new b(this, Iterators.o(f0.n(this.backingMap.values(), new a(this)), columnComparator), columnComparator);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ void putAll(y0 y0Var) {
        super.putAll(y0Var);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // d.g.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        n.p(comparator);
        n.p(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public SortedMap<C, V> row(R r) {
        return new c(this, r);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, d.g.c.c.y0
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
