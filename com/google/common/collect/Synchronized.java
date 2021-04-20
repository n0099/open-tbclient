package com.google.common.collect;

import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.c.a1;
import d.g.c.c.g0;
import d.g.c.c.h0;
import d.g.c.c.i0;
import d.g.c.c.j0;
import d.g.c.c.k;
import d.g.c.c.s0;
import d.g.c.c.v;
import d.g.c.c.x0;
import d.g.c.c.y0;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Synchronized {

    /* loaded from: classes6.dex */
    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        public static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        public transient Collection<Collection<V>> asMapValues;

        public SynchronizedAsMap(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                }
                set = this.asMapEntrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.asMapValues == null) {
                    this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                }
                collection = this.asMapValues;
            }
            return collection;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> q;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                q = collection == null ? null : Synchronized.q(collection, this.mutex);
            }
            return q;
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        public static final long serialVersionUID = 0;

        /* loaded from: classes6.dex */
        public class a extends a1<Collection<V>, Collection<V>> {
            public a(Iterator it) {
                super(it);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: b */
            public Collection<V> a(Collection<V> collection) {
                return Synchronized.q(collection, SynchronizedAsMapValues.this.mutex);
            }
        }

        public SynchronizedAsMapValues(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new a(super.iterator());
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements k<K, V>, Serializable {
        public static final long serialVersionUID = 0;

        /* renamed from: e  reason: collision with root package name */
        public transient Set<V> f31043e;

        /* renamed from: f  reason: collision with root package name */
        public transient k<V, K> f31044f;

        @Override // d.g.c.c.k
        public V forcePut(K k, V v) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k, v);
            }
            return forcePut;
        }

        @Override // d.g.c.c.k
        public k<V, K> inverse() {
            k<V, K> kVar;
            synchronized (this.mutex) {
                if (this.f31044f == null) {
                    this.f31044f = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                }
                kVar = this.f31044f;
            }
            return kVar;
        }

        public SynchronizedBiMap(k<K, V> kVar, Object obj, k<V, K> kVar2) {
            super(kVar, obj);
            this.f31044f = kVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                if (this.f31043e == null) {
                    this.f31043e = Synchronized.n(delegate().values(), this.mutex);
                }
                set = this.f31043e;
            }
            return set;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public k<K, V> delegate() {
            return (k) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        public static final long serialVersionUID = 0;

        @Override // java.util.Collection
        public boolean add(E e2) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e2);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        public SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        public static final long serialVersionUID = 0;

        public SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v);
            }
            return value;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        public static final long serialVersionUID = 0;

        public SynchronizedList(List<E> list, Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i, E e2) {
            synchronized (this.mutex) {
                delegate().add(i, e2);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i) {
            E e2;
            synchronized (this.mutex) {
                e2 = delegate().get(i);
            }
            return e2;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i, E e2) {
            E e3;
            synchronized (this.mutex) {
                e3 = delegate().set(i, e2);
            }
            return e3;
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            List<E> h2;
            synchronized (this.mutex) {
                h2 = Synchronized.h(delegate().subList(i, i2), this.mutex);
            }
            return h2;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i) {
            return delegate().listIterator(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements g0<K, V> {
        public static final long serialVersionUID = 0;

        public SynchronizedListMultimap(g0<K, V> g0Var, Object obj) {
            super(g0Var, obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public List<V> get(K k) {
            List<V> h2;
            synchronized (this.mutex) {
                h2 = Synchronized.h(delegate().get((g0<K, V>) k), this.mutex);
            }
            return h2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((g0<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public g0<K, V> delegate() {
            return (g0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        public static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, V>> entrySet;
        public transient Set<K> keySet;
        public transient Collection<V> values;

        public SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public V get(Object obj) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj);
            }
            return v;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.n(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements h0<K, V> {
        public static final long serialVersionUID = 0;
        public transient Map<K, Collection<V>> asMap;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient i0<K> keys;
        public transient Collection<V> valuesCollection;

        public SynchronizedMultimap(h0<K, V> h0Var, Object obj) {
            super(h0Var, obj);
        }

        @Override // d.g.c.c.h0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.asMap == null) {
                    this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                }
                map = this.asMap;
            }
            return map;
        }

        @Override // d.g.c.c.h0
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // d.g.c.c.h0
        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // d.g.c.c.h0
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // d.g.c.c.h0
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // d.g.c.c.h0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.entries == null) {
                    this.entries = Synchronized.q(delegate().entries(), this.mutex);
                }
                collection = this.entries;
            }
            return collection;
        }

        @Override // d.g.c.c.h0
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public Collection<V> get(K k) {
            Collection<V> q;
            synchronized (this.mutex) {
                q = Synchronized.q(delegate().get(k), this.mutex);
            }
            return q;
        }

        @Override // d.g.c.c.h0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // d.g.c.c.h0
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // d.g.c.c.h0
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.r(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // d.g.c.c.h0
        public i0<K> keys() {
            i0<K> i0Var;
            synchronized (this.mutex) {
                if (this.keys == null) {
                    this.keys = Synchronized.j(delegate().keys(), this.mutex);
                }
                i0Var = this.keys;
            }
            return i0Var;
        }

        @Override // d.g.c.c.h0
        public boolean put(K k, V v) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // d.g.c.c.h0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k, iterable);
            }
            return putAll;
        }

        @Override // d.g.c.c.h0
        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k, iterable);
            }
            return replaceValues;
        }

        @Override // d.g.c.c.h0
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // d.g.c.c.h0
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.valuesCollection;
            }
            return collection;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public h0<K, V> delegate() {
            return (h0) super.delegate();
        }

        @Override // d.g.c.c.h0
        public boolean putAll(h0<? extends K, ? extends V> h0Var) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(h0Var);
            }
            return putAll;
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedObject implements Serializable {
        public static final long serialVersionUID = 0;
        public final Object delegate;
        public final Object mutex;

        public SynchronizedObject(Object obj, Object obj2) {
            n.p(obj);
            this.delegate = obj;
            this.mutex = obj2 == null ? this : obj2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        public static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements s0<K, V> {
        public static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, V>> entrySet;

        public SynchronizedSetMultimap(s0<K, V> s0Var, Object obj) {
            super(s0Var, obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entries(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> get(K k) {
            Set<V> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().get((s0<K, V>) k), this.mutex);
            }
            return n;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((s0<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public s0<K, V> delegate() {
            return (s0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements x0<K, V> {
        public static final long serialVersionUID = 0;

        public SynchronizedSortedSetMultimap(x0<K, V> x0Var, Object obj) {
            super(x0Var, obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // d.g.c.c.x0
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> get(K k) {
            SortedSet<V> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().get((x0<K, V>) k), this.mutex);
            }
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((x0<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public x0<K, V> delegate() {
            return (x0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements y0<R, C, V> {

        /* loaded from: classes6.dex */
        public class a implements g<Map<C, V>, Map<C, V>> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.a.g
            /* renamed from: a */
            public Map<C, V> apply(Map<C, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        /* loaded from: classes6.dex */
        public class b implements g<Map<R, V>, Map<R, V>> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.a.g
            /* renamed from: a */
            public Map<R, V> apply(Map<R, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        public SynchronizedTable(y0<R, C, V> y0Var, Object obj) {
            super(y0Var, obj);
        }

        @Override // d.g.c.c.y0
        public Set<y0.a<R, C, V>> cellSet() {
            Set<y0.a<R, C, V>> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().cellSet(), this.mutex);
            }
            return n;
        }

        @Override // d.g.c.c.y0
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // d.g.c.c.y0
        public Map<R, V> column(C c2) {
            Map<R, V> i;
            synchronized (this.mutex) {
                i = Synchronized.i(delegate().column(c2), this.mutex);
            }
            return i;
        }

        @Override // d.g.c.c.y0
        public Set<C> columnKeySet() {
            Set<C> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().columnKeySet(), this.mutex);
            }
            return n;
        }

        @Override // d.g.c.c.y0
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> i;
            synchronized (this.mutex) {
                i = Synchronized.i(Maps.D(delegate().columnMap(), new b()), this.mutex);
            }
            return i;
        }

        @Override // d.g.c.c.y0
        public boolean contains(Object obj, Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // d.g.c.c.y0
        public boolean containsColumn(Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // d.g.c.c.y0
        public boolean containsRow(Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // d.g.c.c.y0
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // d.g.c.c.y0
        public boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // d.g.c.c.y0
        public V get(Object obj, Object obj2) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj, obj2);
            }
            return v;
        }

        @Override // d.g.c.c.y0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // d.g.c.c.y0
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // d.g.c.c.y0
        public V put(R r, C c2, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r, c2, v);
            }
            return put;
        }

        @Override // d.g.c.c.y0
        public void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
            synchronized (this.mutex) {
                delegate().putAll(y0Var);
            }
        }

        @Override // d.g.c.c.y0
        public V remove(Object obj, Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // d.g.c.c.y0
        public Map<C, V> row(R r) {
            Map<C, V> i;
            synchronized (this.mutex) {
                i = Synchronized.i(delegate().row(r), this.mutex);
            }
            return i;
        }

        @Override // d.g.c.c.y0
        public Set<R> rowKeySet() {
            Set<R> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().rowKeySet(), this.mutex);
            }
            return n;
        }

        @Override // d.g.c.c.y0
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> i;
            synchronized (this.mutex) {
                i = Synchronized.i(Maps.D(delegate().rowMap(), new a()), this.mutex);
            }
            return i;
        }

        @Override // d.g.c.c.y0
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // d.g.c.c.y0
        public Collection<V> values() {
            Collection<V> g2;
            synchronized (this.mutex) {
                g2 = Synchronized.g(delegate().values(), this.mutex);
            }
            return g2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public y0<R, C, V> delegate() {
            return (y0) super.delegate();
        }
    }

    public static <E> Collection<E> g(Collection<E> collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    public static <E> List<E> h(List<E> list, Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    public static <K, V> Map<K, V> i(Map<K, V> map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    public static <E> i0<E> j(i0<E> i0Var, Object obj) {
        return ((i0Var instanceof SynchronizedMultiset) || (i0Var instanceof ImmutableMultiset)) ? i0Var : new SynchronizedMultiset(i0Var, obj);
    }

    public static <K, V> NavigableMap<K, V> k(NavigableMap<K, V> navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    public static <E> NavigableSet<E> l(NavigableSet<E> navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    public static <K, V> Map.Entry<K, V> m(Map.Entry<K, V> entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    public static <E> Set<E> n(Set<E> set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    public static <K, V> SortedMap<K, V> o(SortedMap<K, V> sortedMap, Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    public static <E> SortedSet<E> p(SortedSet<E> sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    public static <E> Collection<E> q(Collection<E> collection, Object obj) {
        if (collection instanceof SortedSet) {
            return p((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return n((Set) collection, obj);
        }
        if (collection instanceof List) {
            return h((List) collection, obj);
        }
        return g(collection, obj);
    }

    public static <E> Set<E> r(Set<E> set, Object obj) {
        if (set instanceof SortedSet) {
            return p((SortedSet) set, obj);
        }
        return n(set, obj);
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements i0<E> {
        public static final long serialVersionUID = 0;
        public transient Set<E> elementSet;
        public transient Set<i0.a<E>> entrySet;

        public SynchronizedMultiset(i0<E> i0Var, Object obj) {
            super(i0Var, obj);
        }

        @Override // d.g.c.c.i0
        public int add(E e2, int i) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e2, i);
            }
            return add;
        }

        @Override // d.g.c.c.i0
        public int count(Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // d.g.c.c.i0
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                if (this.elementSet == null) {
                    this.elementSet = Synchronized.r(delegate().elementSet(), this.mutex);
                }
                set = this.elementSet;
            }
            return set;
        }

        @Override // d.g.c.c.i0
        public Set<i0.a<E>> entrySet() {
            Set<i0.a<E>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.r(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Collection, d.g.c.c.i0
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, d.g.c.c.i0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // d.g.c.c.i0
        public int remove(Object obj, int i) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i);
            }
            return remove;
        }

        @Override // d.g.c.c.i0
        public int setCount(E e2, int i) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e2, i);
            }
            return count;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public i0<E> delegate() {
            return (i0) super.delegate();
        }

        @Override // d.g.c.c.i0
        public boolean setCount(E e2, int i, int i2) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e2, i, i2);
            }
            return count;
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        public static final long serialVersionUID = 0;

        public SynchronizedQueue(Queue<E> queue, Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e2) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e2);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        public static final long serialVersionUID = 0;

        public SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        public static final long serialVersionUID = 0;

        public SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().headMap(k), this.mutex);
            }
            return o;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().subMap(k, k2), this.mutex);
            }
            return o;
        }

        public SortedMap<K, V> tailMap(K k) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().tailMap(k), this.mutex);
            }
            return o;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        public static final long serialVersionUID = 0;

        /* loaded from: classes6.dex */
        public class a extends a1<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0360a extends v<K, Collection<V>> {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f31040e;

                public C0360a(Map.Entry entry) {
                    this.f31040e = entry;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.c.y
                /* renamed from: b */
                public Map.Entry<K, Collection<V>> delegate() {
                    return this.f31040e;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.c.v, java.util.Map.Entry
                /* renamed from: c */
                public Collection<V> getValue() {
                    return Synchronized.q((Collection) this.f31040e.getValue(), SynchronizedAsMapEntries.this.mutex);
                }
            }

            public a(Iterator it) {
                super(it);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: b */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                return new C0360a(entry);
            }
        }

        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean f2;
            synchronized (this.mutex) {
                f2 = Maps.f(delegate(), obj);
            }
            return f2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean b2;
            synchronized (this.mutex) {
                b2 = d.g.c.c.n.b(delegate(), collection);
            }
            return b2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean a2;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                a2 = Sets.a(delegate(), obj);
            }
            return a2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(super.iterator());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean v;
            synchronized (this.mutex) {
                v = Maps.v(delegate(), obj);
            }
            return v;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean r;
            synchronized (this.mutex) {
                r = Iterators.r(delegate().iterator(), collection);
            }
            return r;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean s;
            synchronized (this.mutex) {
                s = Iterators.s(delegate().iterator(), collection);
            }
            return s;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] f2;
            synchronized (this.mutex) {
                f2 = j0.f(delegate());
            }
            return f2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) j0.g(delegate(), tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        public static final long serialVersionUID = 0;

        public SynchronizedDeque(Deque<E> deque, Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e2) {
            synchronized (this.mutex) {
                delegate().addFirst(e2);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e2) {
            synchronized (this.mutex) {
                delegate().addLast(e2);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e2) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e2);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e2) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e2);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e2) {
            synchronized (this.mutex) {
                delegate().push(e2);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        public static final long serialVersionUID = 0;
        public transient NavigableSet<K> descendingKeySet;
        public transient NavigableMap<K, V> descendingMap;
        public transient NavigableSet<K> navigableKeySet;

        public SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().ceilingEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                if (this.descendingKeySet == null) {
                    NavigableSet<K> l = Synchronized.l(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = l;
                    return l;
                }
                return this.descendingKeySet;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                if (this.descendingMap == null) {
                    NavigableMap<K, V> k = Synchronized.k(delegate().descendingMap(), this.mutex);
                    this.descendingMap = k;
                    return k;
                }
                return this.descendingMap;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().firstEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().floorEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            NavigableMap<K, V> k2;
            synchronized (this.mutex) {
                k2 = Synchronized.k(delegate().headMap(k, z), this.mutex);
            }
            return k2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().higherEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().lastEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().lowerEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                if (this.navigableKeySet == null) {
                    NavigableSet<K> l = Synchronized.l(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = l;
                    return l;
                }
                return this.navigableKeySet;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().pollFirstEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().pollLastEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            NavigableMap<K, V> k3;
            synchronized (this.mutex) {
                k3 = Synchronized.k(delegate().subMap(k, z, k2, z2), this.mutex);
            }
            return k3;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            NavigableMap<K, V> k2;
            synchronized (this.mutex) {
                k2 = Synchronized.k(delegate().tailMap(k, z), this.mutex);
            }
            return k2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        public static final long serialVersionUID = 0;
        public transient NavigableSet<E> descendingSet;

        public SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e2);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                if (this.descendingSet == null) {
                    NavigableSet<E> l = Synchronized.l(delegate().descendingSet(), this.mutex);
                    this.descendingSet = l;
                    return l;
                }
                return this.descendingSet;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e2);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().headSet(e2, z), this.mutex);
            }
            return l;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e2);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e2);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().subSet(e2, z, e3, z2), this.mutex);
            }
            return l;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().tailSet(e2, z), this.mutex);
            }
            return l;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e2) {
            return headSet(e2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e2) {
            return tailSet(e2, true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e2, E e3) {
            return subSet(e2, true, e3, false);
        }
    }

    /* loaded from: classes6.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        public static final long serialVersionUID = 0;

        public SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e2) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().headSet(e2), this.mutex);
            }
            return p;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e2, E e3) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().subSet(e2, e3), this.mutex);
            }
            return p;
        }

        public SortedSet<E> tailSet(E e2) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().tailSet(e2), this.mutex);
            }
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }
}
