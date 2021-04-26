package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables;
import d.g.c.a.j;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.f0;
import d.g.c.c.i;
import d.g.c.c.y0;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {

    /* loaded from: classes6.dex */
    public static final class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final int[] cellColumnIndices;
        public final int[] cellRowIndices;
        public final Object[] cellValues;
        public final Object[] columnKeys;
        public final Object[] rowKeys;

        public SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i2 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i2 < objArr2.length) {
                    aVar.h(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i2]], this.columnKeys[this.cellColumnIndices[i2]], objArr2[i2]));
                    i2++;
                } else {
                    return RegularImmutableTable.forOrderedComponents(aVar.j(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        public final List<y0.a<R, C, V>> f31899a = Lists.i();

        /* renamed from: b  reason: collision with root package name */
        public Comparator<? super R> f31900b;

        /* renamed from: c  reason: collision with root package name */
        public Comparator<? super C> f31901c;

        public ImmutableTable<R, C, V> a() {
            int size = this.f31899a.size();
            if (size != 0) {
                if (size != 1) {
                    return RegularImmutableTable.forCells(this.f31899a, this.f31900b, this.f31901c);
                }
                return new SingletonImmutableTable((y0.a) f0.h(this.f31899a));
            }
            return ImmutableTable.of();
        }

        public a<R, C, V> b(y0.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof Tables.ImmutableCell) {
                n.q(aVar.getRowKey(), "row");
                n.q(aVar.getColumnKey(), "column");
                n.q(aVar.getValue(), "value");
                this.f31899a.add(aVar);
            } else {
                c(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
            return this;
        }

        public a<R, C, V> c(R r, C c2, V v) {
            this.f31899a.add(ImmutableTable.cellOf(r, c2, v));
            return this;
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> y0.a<R, C, V> cellOf(R r, C c2, V v) {
        n.q(r, "rowKey");
        n.q(c2, "columnKey");
        n.q(v, "value");
        return Tables.c(r, c2, v);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(y0<? extends R, ? extends C, ? extends V> y0Var) {
        if (y0Var instanceof ImmutableTable) {
            return (ImmutableTable) y0Var;
        }
        return copyOf(y0Var.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((ImmutableTable<R, C, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.y0
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i
    public abstract ImmutableSet<y0.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i
    public abstract ImmutableCollection<V> createValues();

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public final V put(R r, C c2, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public final void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((ImmutableTable<R, C, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.y0
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // d.g.c.c.y0
    public abstract /* synthetic */ int size();

    @Override // d.g.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // d.g.c.c.i
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c2, V v) {
        return new SingletonImmutableTable(r, c2, v);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i
    public final c1<y0.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableSet<y0.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // d.g.c.c.y0
    public ImmutableMap<R, V> column(C c2) {
        n.q(c2, "columnKey");
        return (ImmutableMap) j.a((ImmutableMap) columnMap().get(c2), ImmutableMap.of());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // d.g.c.c.y0
    public ImmutableMap<C, V> row(R r) {
        n.q(r, "rowKey");
        return (ImmutableMap) j.a((ImmutableMap) rowMap().get(r), ImmutableMap.of());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends y0.a<? extends R, ? extends C, ? extends V>> iterable) {
        a builder = builder();
        for (y0.a<? extends R, ? extends C, ? extends V> aVar : iterable) {
            builder.b(aVar);
        }
        return builder.a();
    }
}
