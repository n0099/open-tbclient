package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import d.h.c.a.k;
import d.h.c.a.n;
import d.h.c.c.i;
import d.h.c.c.y0;
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
    public class a extends d.h.c.c.a<y0.a<R, C, V>> {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.a
        /* renamed from: b */
        public y0.a<R, C, V> a(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Tables.b<R, C, V> {

        /* renamed from: e  reason: collision with root package name */
        public final int f30799e;

        /* renamed from: f  reason: collision with root package name */
        public final int f30800f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f30801g;

        public b(int i) {
            this.f30801g = i;
            this.f30799e = this.f30801g / ArrayTable.this.columnList.size();
            this.f30800f = this.f30801g % ArrayTable.this.columnList.size();
        }

        @Override // d.h.c.c.y0.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f30800f);
        }

        @Override // d.h.c.c.y0.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f30799e);
        }

        @Override // d.h.c.c.y0.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f30799e, this.f30800f);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d.h.c.c.a<V> {
        public c(int i) {
            super(i);
        }

        @Override // d.h.c.c.a
        public V a(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d<K, V> extends Maps.l<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableMap<K, Integer> f30804e;

        /* loaded from: classes6.dex */
        public class a extends d.h.c.c.b<K, V> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f30805e;

            public a(int i) {
                this.f30805e = i;
            }

            @Override // d.h.c.c.b, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.c(this.f30805e);
            }

            @Override // d.h.c.c.b, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.e(this.f30805e);
            }

            @Override // d.h.c.c.b, java.util.Map.Entry
            public V setValue(V v) {
                return (V) d.this.f(this.f30805e, v);
            }
        }

        /* loaded from: classes6.dex */
        public class b extends d.h.c.c.a<Map.Entry<K, V>> {
            public b(int i) {
                super(i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.h.c.c.a
            /* renamed from: b */
            public Map.Entry<K, V> a(int i) {
                return d.this.b(i);
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> b(int i) {
            n.n(i, size());
            return new a(i);
        }

        public K c(int i) {
            return this.f30804e.keySet().asList().get(i);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f30804e.containsKey(obj);
        }

        public abstract String d();

        public abstract V e(int i);

        public abstract V f(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f30804e.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f30804e.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f30804e.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.f30804e.get(k);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + " " + k + " not in " + this.f30804e.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30804e.size();
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f30804e = immutableMap;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends d<R, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f30808f;

        public e(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f30808f = i;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(i, this.f30808f);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(i, this.f30808f, v);
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
        public /* bridge */ /* synthetic */ Object f(int i, Object obj) {
            i(i, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<R, V> e(int i) {
            return new e(i);
        }

        public Map<R, V> h(C c2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> i(int i, Map<R, V> map) {
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
        public final int f30811f;

        public g(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f30811f = i;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(this.f30811f, i);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(this.f30811f, i, v);
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
        public /* bridge */ /* synthetic */ Object f(int i, Object obj) {
            i(i, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<C, V> e(int i) {
            return new g(i);
        }

        public Map<C, V> h(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> i(int i, Map<C, V> map) {
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
    public y0.a<R, C, V> getCell(int i) {
        return new b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public V at(int i, int i2) {
        n.n(i, this.rowList.size());
        n.n(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // d.h.c.c.i
    public Iterator<y0.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public Set<y0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // d.h.c.c.y0
    public Map<R, V> column(C c2) {
        n.p(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // d.h.c.c.y0
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar == null) {
            ArrayTable<R, C, V>.f fVar2 = new f(this, null);
            this.columnMap = fVar2;
            return fVar2;
        }
        return fVar;
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
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

    @Override // d.h.c.c.i, d.h.c.c.y0
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

    @Override // d.h.c.c.i, d.h.c.c.y0
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public V put(R r, C c2, V v) {
        n.p(r);
        n.p(c2);
        Integer num = this.rowKeyToIndex.get(r);
        n.l(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        n.l(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
        super.putAll(y0Var);
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // d.h.c.c.y0
    public Map<C, V> row(R r) {
        n.p(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // d.h.c.c.y0
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar == null) {
            ArrayTable<R, C, V>.h hVar2 = new h(this, null);
            this.rowMap = hVar2;
            return hVar2;
        }
        return hVar;
    }

    public V set(int i, int i2, V v) {
        n.n(i, this.rowList.size());
        n.n(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    @Override // d.h.c.c.y0
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Override // d.h.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // d.h.c.c.i, d.h.c.c.y0
    public Collection<V> values() {
        return super.values();
    }

    @Override // d.h.c.c.i
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(y0<R, C, V> y0Var) {
        return y0Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) y0Var) : new ArrayTable<>(y0Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.i, d.h.c.c.y0
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.i, d.h.c.c.y0
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: d.h.c.c.y0<R, C, V> */
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
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }
}
