package com.google.common.collect;

import com.google.common.collect.Maps;
import d.h.c.a.n;
import d.h.c.a.r;
import d.h.c.c.q0;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements q0<R, C, V> {
    public static final long serialVersionUID = 0;

    /* loaded from: classes6.dex */
    public class b extends StandardTable<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.u
        /* renamed from: f */
        public SortedSet<R> b() {
            return new Maps.o(this);
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: g */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            n.p(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(r), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            n.p(r);
            n.p(r2);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(r, r2), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            n.p(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(r), StandardRowSortedTable.this.factory).rowMap();
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, r<? extends Map<C, V>> rVar) {
        super(sortedMap, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardTable, d.h.c.c.i, d.h.c.c.y0
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardTable, d.h.c.c.y0
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
