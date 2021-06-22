package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.i;
import d.g.c.c.y0;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final V[][] array;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableList<C> columnList;
    public transient ArrayTable<R, C, V>.f columnMap;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableList<R> rowList;
    public transient ArrayTable<R, C, V>.h rowMap;

    /* loaded from: classes6.dex */
    public class a extends d.g.c.c.a<y0.a<R, C, V>> {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a
        /* renamed from: b */
        public y0.a<R, C, V> a(int i2) {
            return ArrayTable.this.getCell(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Tables.b<R, C, V> {

        /* renamed from: e  reason: collision with root package name */
        public final int f31114e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31115f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f31116g;

        public b(int i2) {
            this.f31116g = i2;
            this.f31114e = this.f31116g / ArrayTable.this.columnList.size();
            this.f31115f = this.f31116g % ArrayTable.this.columnList.size();
        }

        @Override // d.g.c.c.y0.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f31115f);
        }

        @Override // d.g.c.c.y0.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f31114e);
        }

        @Override // d.g.c.c.y0.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f31114e, this.f31115f);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d.g.c.c.a<V> {
        public c(int i2) {
            super(i2);
        }

        @Override // d.g.c.c.a
        public V a(int i2) {
            return (V) ArrayTable.this.getValue(i2);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d<K, V> extends Maps.l<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableMap<K, Integer> f31119e;

        /* loaded from: classes6.dex */
        public class a extends d.g.c.c.b<K, V> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f31120e;

            public a(int i2) {
                this.f31120e = i2;
            }

            @Override // d.g.c.c.b, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.c(this.f31120e);
            }

            @Override // d.g.c.c.b, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.e(this.f31120e);
            }

            @Override // d.g.c.c.b, java.util.Map.Entry
            public V setValue(V v) {
                return (V) d.this.f(this.f31120e, v);
            }
        }

        /* loaded from: classes6.dex */
        public class b extends d.g.c.c.a<Map.Entry<K, V>> {
            public b(int i2) {
                super(i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a
            /* renamed from: b */
            public Map.Entry<K, V> a(int i2) {
                return d.this.b(i2);
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> b(int i2) {
            n.n(i2, size());
            return new a(i2);
        }

        public K c(int i2) {
            return this.f31119e.keySet().asList().get(i2);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f31119e.containsKey(obj);
        }

        public abstract String d();

        public abstract V e(int i2);

        public abstract V f(int i2, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f31119e.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f31119e.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f31119e.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.f31119e.get(k);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + " " + k + " not in " + this.f31119e.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f31119e.size();
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f31119e = immutableMap;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends d<R, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f31123f;

        public e(int i2) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f31123f = i2;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i2) {
            return (V) ArrayTable.this.at(i2, this.f31123f);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i2, V v) {
            return (V) ArrayTable.this.set(i2, this.f31123f, v);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends d<C, Map<R, V>> {
        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public /* bridge */ /* synthetic */ Object f(int i2, Object obj) {
            i(i2, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<R, V> e(int i2) {
            return new e(i2);
        }

        public Map<R, V> h(C c2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> i(int i2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            h(obj, (Map) obj2);
            throw null;
        }

        public f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* loaded from: classes6.dex */
    public class g extends d<C, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f31126f;

        public g(int i2) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f31126f = i2;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i2) {
            return (V) ArrayTable.this.at(this.f31126f, i2);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i2, V v) {
            return (V) ArrayTable.this.set(this.f31126f, i2, v);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends d<R, Map<C, V>> {
        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public /* bridge */ /* synthetic */ Object f(int i2, Object obj) {
            i(i2, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<C, V> e(int i2) {
            return new g(i2);
        }

        public Map<C, V> h(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> i(int i2, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            h(obj, (Map) obj2);
            throw null;
        }

        public h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    public ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        n.d(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.k(this.rowList);
        this.columnKeyToIndex = Maps.k(this.columnList);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, this.rowList.size(), this.columnList.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public y0.a<R, C, V> getCell(int i2) {
        return new b(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i2) {
        return at(i2 / this.columnList.size(), i2 % this.columnList.size());
    }

    public V at(int i2, int i3) {
        n.n(i2, this.rowList.size());
        n.n(i3, this.columnList.size());
        return this.array[i2][i3];
    }

    @Override // d.g.c.c.i
    public Iterator<y0.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Set<y0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.y0
    public Map<R, V> column(C c2) {
        n.p(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // d.g.c.c.y0
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar == null) {
            ArrayTable<R, C, V>.f fVar2 = new f(this, null);
            this.columnMap = fVar2;
            return fVar2;
        }
        return fVar;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsValue(Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V v : vArr2) {
                if (k.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public V put(R r, C c2, V v) {
        n.p(r);
        n.p(c2);
        Integer num = this.rowKeyToIndex.get(r);
        n.l(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        n.l(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
        super.putAll(y0Var);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.y0
    public Map<C, V> row(R r) {
        n.p(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // d.g.c.c.y0
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar == null) {
            ArrayTable<R, C, V>.h hVar2 = new h(this, null);
            this.rowMap = hVar2;
            return hVar2;
        }
        return hVar;
    }

    public V set(int i2, int i3, V v) {
        n.n(i2, this.rowList.size());
        n.n(i3, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i2][i3];
        vArr[i2][i3] = v;
        return v2;
    }

    @Override // d.g.c.c.y0
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i2 = 0; i2 < this.rowList.size(); i2++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
        return vArr;
    }

    @Override // d.g.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Collection<V> values() {
        return super.values();
    }

    @Override // d.g.c.c.i
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(y0<R, C, V> y0Var) {
        return y0Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) y0Var) : new ArrayTable<>(y0Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i, d.g.c.c.y0
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: d.g.c.c.y0<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayTable(y0<R, C, V> y0Var) {
        this(y0Var.rowKeySet(), y0Var.columnKeySet());
        putAll(y0Var);
    }

    public ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), this.columnList.size()));
        this.array = vArr;
        for (int i2 = 0; i2 < this.rowList.size(); i2++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
    }
}
