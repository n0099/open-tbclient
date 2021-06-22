package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import d.g.c.c.c1;
import d.g.c.c.y0;
import java.lang.reflect.Array;
import java.util.Map;
/* loaded from: classes6.dex */
public final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public final int[] cellColumnIndices;
    public final int[] cellRowIndices;
    public final int[] columnCounts;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final int[] rowCounts;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    public final V[][] values;

    /* loaded from: classes6.dex */
    public final class Column extends ImmutableArrayMap<R, V> {
        public final int columnIndex;

        public Column(int i2) {
            super(DenseImmutableTable.this.columnCounts[i2]);
            this.columnIndex = i2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i2) {
            return (V) DenseImmutableTable.this.values[i2][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    /* loaded from: classes6.dex */
    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        public ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int i2) {
            return new Column(i2);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        public final int size;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<K, V>> {

            /* renamed from: g  reason: collision with root package name */
            public int f31167g = -1;

            /* renamed from: h  reason: collision with root package name */
            public final int f31168h;

            public a() {
                this.f31168h = ImmutableArrayMap.this.keyToIndex().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<K, V> a() {
                int i2 = this.f31167g;
                while (true) {
                    this.f31167g = i2 + 1;
                    int i3 = this.f31167g;
                    if (i3 < this.f31168h) {
                        Object value = ImmutableArrayMap.this.getValue(i3);
                        if (value != null) {
                            return Maps.j(ImmutableArrayMap.this.getKey(this.f31167g), value);
                        }
                        i2 = this.f31167g;
                    } else {
                        return b();
                    }
                }
            }
        }

        public ImmutableArrayMap(int i2) {
            this.size = i2;
        }

        public final boolean a() {
            return this.size == keyToIndex().size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return a() ? keyToIndex().keySet() : super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public c1<Map.Entry<K, V>> entryIterator() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object obj) {
            Integer num = keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public K getKey(int i2) {
            return keyToIndex().keySet().asList().get(i2);
        }

        public abstract V getValue(int i2);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes6.dex */
    public final class Row extends ImmutableArrayMap<C, V> {
        public final int rowIndex;

        public Row(int i2) {
            super(DenseImmutableTable.this.rowCounts[i2]);
            this.rowIndex = i2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i2) {
            return (V) DenseImmutableTable.this.values[this.rowIndex][i2];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* loaded from: classes6.dex */
    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        public RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int i2) {
            return new Row(i2);
        }
    }

    public DenseImmutableTable(ImmutableList<y0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableSet.size(), immutableSet2.size()));
        this.rowKeyToIndex = Maps.k(immutableSet);
        this.columnKeyToIndex = Maps.k(immutableSet2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            y0.a<R, C, V> aVar = immutableList.get(i2);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            int intValue = this.rowKeyToIndex.get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], aVar.getValue());
            this.values[intValue][intValue2] = aVar.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i2] = intValue;
            iArr2[i2] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, d.g.c.c.i, d.g.c.c.y0
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public y0.a<R, C, V> getCell(int i2) {
        int i3 = this.cellRowIndices[i2];
        int i4 = this.cellColumnIndices[i2];
        return ImmutableTable.cellOf(rowKeySet().asList().get(i3), columnKeySet().asList().get(i4), this.values[i3][i4]);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i2) {
        return this.values[this.cellRowIndices[i2]][this.cellColumnIndices[i2]];
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, d.g.c.c.y0
    public int size() {
        return this.cellRowIndices.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.g.c.c.y0
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.g.c.c.y0
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }
}
