package com.google.common.collect;

import d.g.c.a.g;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.d0;
import d.g.c.c.q0;
import d.g.c.c.y0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Tables {

    /* renamed from: a  reason: collision with root package name */
    public static final g<? extends Map<?, ?>, ? extends Map<?, ?>> f31047a = new a();

    /* loaded from: classes6.dex */
    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final C columnKey;
        public final R rowKey;
        public final V value;

        public ImmutableCell(R r, C c2, V v) {
            this.rowKey = r;
            this.columnKey = c2;
            this.value = v;
        }

        @Override // d.g.c.c.y0.a
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // d.g.c.c.y0.a
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // d.g.c.c.y0.a
        public V getValue() {
            return this.value;
        }
    }

    /* loaded from: classes6.dex */
    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements q0<R, C, V> {
        public static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(q0<R, ? extends C, ? extends V> q0Var) {
            super(q0Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, d.g.c.c.d0, d.g.c.c.y0
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, d.g.c.c.d0, d.g.c.c.y0
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.E(delegate().rowMap(), Tables.d()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, d.g.c.c.d0, d.g.c.c.y
        public q0<R, C, V> delegate() {
            return (q0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableTable<R, C, V> extends d0<R, C, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final y0<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(y0<? extends R, ? extends C, ? extends V> y0Var) {
            n.p(y0Var);
            this.delegate = y0Var;
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Set<y0.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Map<R, V> column(C c2) {
            return Collections.unmodifiableMap(super.column(c2));
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.D(super.columnMap(), Tables.d()));
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public V put(R r, C c2, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public V remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Map<C, V> row(R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.D(super.rowMap(), Tables.d()));
        }

        @Override // d.g.c.c.d0, d.g.c.c.y0
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: d.g.c.c.y0<? extends R, ? extends C, ? extends V>, d.g.c.c.y0<R, C, V> */
        @Override // d.g.c.c.d0, d.g.c.c.y
        public y0<R, C, V> delegate() {
            return (y0<? extends R, ? extends C, ? extends V>) this.delegate;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements g<Map<Object, Object>, Map<Object, Object>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<R, C, V> implements y0.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof y0.a) {
                y0.a aVar = (y0.a) obj;
                return k.a(getRowKey(), aVar.getRowKey()) && k.a(getColumnKey(), aVar.getColumnKey()) && k.a(getValue(), aVar.getValue());
            }
            return false;
        }

        public int hashCode() {
            return k.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static boolean b(y0<?, ?, ?> y0Var, Object obj) {
        if (obj == y0Var) {
            return true;
        }
        if (obj instanceof y0) {
            return y0Var.cellSet().equals(((y0) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> y0.a<R, C, V> c(R r, C c2, V v) {
        return new ImmutableCell(r, c2, v);
    }

    public static <K, V> g<Map<K, V>, Map<K, V>> d() {
        return (g<Map<K, V>, Map<K, V>>) f31047a;
    }
}
