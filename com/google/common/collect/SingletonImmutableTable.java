package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import d.h.c.a.n;
import d.h.c.c.y0;
import java.util.Map;
/* loaded from: classes6.dex */
public class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    public final C singleColumnKey;
    public final R singleRowKey;
    public final V singleValue;

    public SingletonImmutableTable(R r, C c2, V v) {
        n.p(r);
        this.singleRowKey = r;
        n.p(c2);
        this.singleColumnKey = c2;
        n.p(v);
        this.singleValue = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((SingletonImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public ImmutableMap<R, V> column(C c2) {
        n.p(c2);
        if (containsColumn(c2)) {
            return ImmutableMap.of(this.singleRowKey, (Object) this.singleValue);
        }
        return ImmutableMap.of();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, (Object) this.singleValue));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.i
    public ImmutableSet<y0.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.i
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, d.h.c.c.y0
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, (Object) this.singleValue));
    }

    public SingletonImmutableTable(y0.a<R, C, V> aVar) {
        this(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
    }
}
