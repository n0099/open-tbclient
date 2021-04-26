package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import d.g.c.c.c1;
import d.g.c.c.y0;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    public final int[] cellColumnInRowIndices;
    public final int[] cellRowIndices;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.google.common.collect.SparseImmutableTable<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<y0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap k = Maps.k(immutableSet);
        LinkedHashMap s = Maps.s();
        c1<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            s.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap s2 = Maps.s();
        c1<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            s2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            y0.a<R, C, V> aVar = immutableList.get(i2);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            V value = aVar.getValue();
            iArr[i2] = ((Integer) k.get(rowKey)).intValue();
            Map map = (Map) s.get(rowKey);
            iArr2[i2] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) s2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(s.size());
        for (Map.Entry entry : s.entrySet()) {
            bVar.c(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(s2.size());
        for (Map.Entry entry2 : s2.entrySet()) {
            bVar2.c(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.a();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap k = Maps.k(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        c1<y0.a<R, C, V>> it = cellSet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) k.get(it.next().getColumnKey())).intValue();
            i2++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public y0.a<R, C, V> getCell(int i2) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i2]);
        Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.cellColumnInRowIndices[i2]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i2) {
        int i3 = this.cellRowIndices[i2];
        return this.rowMap.values().asList().get(i3).values().asList().get(this.cellColumnInRowIndices[i2]);
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
