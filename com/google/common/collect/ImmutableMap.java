package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import d.g.c.c.c1;
import d.g.c.c.m;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
/* loaded from: classes6.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    public static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    public transient ImmutableSet<Map.Entry<K, V>> entrySet;
    public transient ImmutableSet<K> keySet;
    public transient ImmutableSetMultimap<K, V> multimapView;
    public transient ImmutableCollection<V> values;

    /* loaded from: classes6.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public c1<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract c1<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, d.g.c.c.k
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes6.dex */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* loaded from: classes6.dex */
        public class a extends c1<Map.Entry<K, ImmutableSet<V>>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Iterator f30792e;

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0352a extends d.g.c.c.b<K, ImmutableSet<V>> {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f30793e;

                public C0352a(a aVar, Map.Entry entry) {
                    this.f30793e = entry;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.c.b, java.util.Map.Entry
                /* renamed from: a */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f30793e.getValue());
                }

                @Override // d.g.c.c.b, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f30793e.getKey();
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.f30792e = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0352a(this, (Map.Entry) this.f30792e.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30792e.hasNext();
            }
        }

        public MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public c1<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    /* loaded from: classes6.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final Object[] keys;
        public final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            c1<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        public Object createMap(b<Object, Object> bVar) {
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i < objArr.length) {
                    bVar.c(objArr[i], this.values[i]);
                    i++;
                } else {
                    return bVar.a();
                }
            }
        }

        public Object readResolve() {
            return createMap(new b<>(this.keys.length));
        }
    }

    /* loaded from: classes6.dex */
    public class a extends c1<K> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c1 f30794e;

        public a(ImmutableMap immutableMap, c1 c1Var) {
            this.f30794e = c1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30794e.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f30794e.next()).getKey();
        }
    }

    /* loaded from: classes6.dex */
    public static class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public Comparator<? super V> f30795a;

        /* renamed from: b  reason: collision with root package name */
        public Object[] f30796b;

        /* renamed from: c  reason: collision with root package name */
        public int f30797c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30798d;

        public b() {
            this(4);
        }

        public ImmutableMap<K, V> a() {
            g();
            this.f30798d = true;
            return RegularImmutableMap.create(this.f30797c, this.f30796b);
        }

        public final void b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f30796b;
            if (i2 > objArr.length) {
                this.f30796b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i2));
                this.f30798d = false;
            }
        }

        public b<K, V> c(K k, V v) {
            b(this.f30797c + 1);
            m.a(k, v);
            Object[] objArr = this.f30796b;
            int i = this.f30797c;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f30797c = i + 1;
            return this;
        }

        public b<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                b(this.f30797c + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                d(entry);
            }
            return this;
        }

        public b<K, V> f(Map<? extends K, ? extends V> map) {
            return e(map.entrySet());
        }

        public void g() {
            int i;
            if (this.f30795a != null) {
                if (this.f30798d) {
                    this.f30796b = Arrays.copyOf(this.f30796b, this.f30797c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f30797c];
                int i2 = 0;
                while (true) {
                    i = this.f30797c;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = this.f30796b;
                    int i3 = i2 * 2;
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(objArr[i3], objArr[i3 + 1]);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, Ordering.from(this.f30795a).onResultOf(Maps.K()));
                for (int i4 = 0; i4 < this.f30797c; i4++) {
                    int i5 = i4 * 2;
                    this.f30796b[i5] = entryArr[i4].getKey();
                    this.f30796b[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        public b(int i) {
            this.f30796b = new Object[i * 2];
            this.f30797c = 0;
            this.f30798d = false;
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i) {
        m.b(i, "expectedSize");
        return new b<>(i);
    }

    public static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        m.a(k, v);
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
            this.multimapView = immutableSetMultimap2;
            return immutableSetMultimap2;
        }
        return immutableSetMultimap;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.i(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public c1<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.z(this);
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        m.a(k, v);
        return RegularImmutableMap.create(1, new Object[]{k, v});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet == null) {
            ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return immutableSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet == null) {
            ImmutableSet<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return immutableSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection == null) {
            ImmutableCollection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return immutableCollection;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        m.a(k, v);
        m.a(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k, v, k2, v2});
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.e(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        m.a(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        m.a(k4, v4);
        m.a(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }
}
