package com.google.common.collect;

import d.g.c.c.c1;
import d.g.c.c.h0;
import d.g.c.c.i0;
import d.g.c.c.j;
import d.g.c.c.m;
import d.g.c.c.n0;
import d.g.c.c.r0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class ImmutableMultimap<K, V> extends j<K, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    public final transient int size;

    /* loaded from: classes6.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        public static final long serialVersionUID = 0;
        public final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    /* loaded from: classes6.dex */
    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public i0.a<K> getEntry(int i) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i);
            return Multisets.g(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    /* loaded from: classes6.dex */
    public static final class KeysSerializedForm implements Serializable {
        public final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        public static final long serialVersionUID = 0;

        /* renamed from: e  reason: collision with root package name */
        public final transient ImmutableMultimap<K, V> f30803e;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f30803e = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f30803e.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            c1<? extends ImmutableCollection<V>> it = this.f30803e.map.values().iterator();
            while (it.hasNext()) {
                i = it.next().copyIntoArray(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f30803e.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<V> iterator() {
            return this.f30803e.valueIterator();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends c1<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f30804e;

        /* renamed from: f  reason: collision with root package name */
        public K f30805f = null;

        /* renamed from: g  reason: collision with root package name */
        public Iterator<V> f30806g = Iterators.h();

        public a() {
            this.f30804e = ImmutableMultimap.this.map.entrySet().iterator();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (!this.f30806g.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f30804e.next();
                this.f30805f = next.getKey();
                this.f30806g = next.getValue().iterator();
            }
            return Maps.j(this.f30805f, this.f30806g.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30806g.hasNext() || this.f30804e.hasNext();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c1<V> {

        /* renamed from: e  reason: collision with root package name */
        public Iterator<? extends ImmutableCollection<V>> f30808e;

        /* renamed from: f  reason: collision with root package name */
        public Iterator<V> f30809f = Iterators.h();

        public b() {
            this.f30808e = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30809f.hasNext() || this.f30808e.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f30809f.hasNext()) {
                this.f30809f = this.f30808e.next().iterator();
            }
            return this.f30809f.next();
        }
    }

    /* loaded from: classes6.dex */
    public static class c<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public Map<K, Collection<V>> f30811a = n0.h();

        /* renamed from: b  reason: collision with root package name */
        public Comparator<? super K> f30812b;

        /* renamed from: c  reason: collision with root package name */
        public Comparator<? super V> f30813c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f30811a.entrySet();
            Comparator<? super K> comparator = this.f30812b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.f30813c);
        }

        public Collection<V> b() {
            return new ArrayList();
        }

        public c<K, V> c(K k, V v) {
            m.a(k, v);
            Collection<V> collection = this.f30811a.get(k);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f30811a;
                Collection<V> b2 = b();
                map.put(k, b2);
                collection = b2;
            }
            collection.add(v);
            return this;
        }

        public c<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public c<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                d(entry);
            }
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final r0.b<ImmutableMultimap> f30814a = r0.a(ImmutableMultimap.class, "map");

        /* renamed from: b  reason: collision with root package name */
        public static final r0.b<ImmutableMultimap> f30815b = r0.a(ImmutableMultimap.class, "size");
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var) {
        if (h0Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) h0Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((h0) h0Var);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // d.g.c.c.h0
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // d.g.c.c.h0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // d.g.c.c.c
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // d.g.c.c.c
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // d.g.c.c.h0, d.g.c.c.g0
    public abstract ImmutableCollection<V> get(K k);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // d.g.c.c.h0
    public int size() {
        return this.size;
    }

    @Override // d.g.c.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.collect.ImmutableMap<K, ? extends com.google.common.collect.ImmutableCollection<V>>, com.google.common.collect.ImmutableMap<K, java.util.Collection<V>> */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public ImmutableMap<K, Collection<V>> asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.map;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public c1<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    @Deprecated
    public boolean putAll(h0<? extends K, ? extends V> h0Var) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public c1<V> valueIterator() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }
}
