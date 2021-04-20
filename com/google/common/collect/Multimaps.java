package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.a.r;
import d.g.c.c.a1;
import d.g.c.c.d;
import d.g.c.c.g0;
import d.g.c.c.h0;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.s0;
import d.g.c.c.w;
import d.g.c.c.x0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Multimaps {

    /* loaded from: classes6.dex */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        public static final long serialVersionUID = 0;
        public transient r<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, r<? extends List<V>> rVar) {
            super(map);
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (r) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    /* loaded from: classes6.dex */
    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        public static final long serialVersionUID = 0;
        public transient r<? extends Collection<V>> factory;

        public CustomMultimap(Map<K, Collection<V>> map, r<? extends Collection<V>> rVar) {
            super(map);
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (r) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.i((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            if (collection instanceof List) {
                return Collections.unmodifiableList((List) collection);
            }
            return Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(k, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k, (SortedSet) collection, null);
            }
            if (collection instanceof Set) {
                return new AbstractMapBasedMultimap.n(k, (Set) collection);
            }
            return new AbstractMapBasedMultimap.k(k, collection, null);
        }
    }

    /* loaded from: classes6.dex */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        public static final long serialVersionUID = 0;
        public transient r<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> map, r<? extends Set<V>> rVar) {
            super(map);
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (r) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.i((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k, (SortedSet) collection, null);
            }
            return new AbstractMapBasedMultimap.n(k, (Set) collection);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    /* loaded from: classes6.dex */
    public static class MapMultimap<K, V> extends d.g.c.c.c<K, V> implements s0<K, V>, Serializable {
        public static final long serialVersionUID = 7845222491160860175L;
        public final Map<K, V> map;

        /* loaded from: classes6.dex */
        public class a extends Sets.a<V> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f30954e;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0353a implements Iterator<V> {

                /* renamed from: e  reason: collision with root package name */
                public int f30956e;

                public C0353a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f30956e == 0) {
                        a aVar = a.this;
                        if (MapMultimap.this.map.containsKey(aVar.f30954e)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (hasNext()) {
                        this.f30956e++;
                        a aVar = a.this;
                        return MapMultimap.this.map.get(aVar.f30954e);
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    m.e(this.f30956e == 1);
                    this.f30956e = -1;
                    a aVar = a.this;
                    MapMultimap.this.map.remove(aVar.f30954e);
                }
            }

            public a(Object obj) {
                this.f30954e = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new C0353a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapMultimap.this.map.containsKey(this.f30954e) ? 1 : 0;
            }
        }

        public MapMultimap(Map<K, V> map) {
            n.p(map);
            this.map = map;
        }

        @Override // d.g.c.c.h0
        public void clear() {
            this.map.clear();
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean containsEntry(Object obj, Object obj2) {
            return this.map.entrySet().contains(Maps.j(obj, obj2));
        }

        @Override // d.g.c.c.h0
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // d.g.c.c.c
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // d.g.c.c.c
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // d.g.c.c.c
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // d.g.c.c.c
        public i0<K> createKeys() {
            return new c(this);
        }

        @Override // d.g.c.c.c
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // d.g.c.c.c
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((MapMultimap<K, V>) obj);
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean remove(Object obj, Object obj2) {
            return this.map.entrySet().remove(Maps.j(obj, obj2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((MapMultimap<K, V>) obj, iterable);
        }

        @Override // d.g.c.c.h0
        public int size() {
            return this.map.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.c, d.g.c.c.h0
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // d.g.c.c.h0, d.g.c.c.g0
        public Set<V> get(K k) {
            return new a(k);
        }

        @Override // d.g.c.c.c, d.g.c.c.h0
        public boolean putAll(h0<? extends K, ? extends V> h0Var) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.h0, d.g.c.c.g0
        public Set<V> removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (this.map.containsKey(obj)) {
                hashSet.add(this.map.remove(obj));
                return hashSet;
            }
            return hashSet;
        }

        @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements g0<K, V> {
        public static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(g0<K, V> g0Var) {
            super(g0Var);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableListMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public List<V> get(K k) {
            return Collections.unmodifiableList(delegate().get((g0<K, V>) k));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public List<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.y
        public g0<K, V> delegate() {
            return (g0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableMultimap<K, V> extends w<K, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final h0<K, V> delegate;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient i0<K> keys;
        public transient Map<K, Collection<V>> map;
        public transient Collection<V> values;

        /* loaded from: classes6.dex */
        public class a implements g<Collection<V>, Collection<V>> {
            public a(UnmodifiableMultimap unmodifiableMultimap) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.a.g
            /* renamed from: a */
            public Collection<V> apply(Collection<V> collection) {
                return Multimaps.e(collection);
            }
        }

        public UnmodifiableMultimap(h0<K, V> h0Var) {
            n.p(h0Var);
            this.delegate = h0Var;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.map;
            if (map == null) {
                Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.D(this.delegate.asMap(), new a(this)));
                this.map = unmodifiableMap;
                return unmodifiableMap;
            }
            return map;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection == null) {
                Collection<Map.Entry<K, V>> d2 = Multimaps.d(this.delegate.entries());
                this.entries = d2;
                return d2;
            }
            return collection;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Collection<V> get(K k) {
            return Multimaps.e(this.delegate.get(k));
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set == null) {
                Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
                this.keySet = unmodifiableSet;
                return unmodifiableSet;
            }
            return set;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public i0<K> keys() {
            i0<K> i0Var = this.keys;
            if (i0Var == null) {
                i0<K> o = Multisets.o(this.delegate.keys());
                this.keys = o;
                return o;
            }
            return i0Var;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Collection<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection == null) {
                Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
                this.values = unmodifiableCollection;
                return unmodifiableCollection;
            }
            return collection;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.w, d.g.c.c.y
        public h0<K, V> delegate() {
            return this.delegate;
        }

        @Override // d.g.c.c.w, d.g.c.c.h0
        public boolean putAll(h0<? extends K, ? extends V> h0Var) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements s0<K, V> {
        public static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(s0<K, V> s0Var) {
            super(s0Var);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSetMultimap<K, V>) obj, iterable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0
        public Set<Map.Entry<K, V>> entries() {
            return Maps.H(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> get(K k) {
            return Collections.unmodifiableSet(delegate().get((s0<K, V>) k));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.y
        public s0<K, V> delegate() {
            return (s0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements x0<K, V> {
        public static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(x0<K, V> x0Var) {
            super(x0Var);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // d.g.c.c.x0
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> get(K k) {
            return Collections.unmodifiableSortedSet(delegate().get((x0<K, V>) k));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.h0, d.g.c.c.g0
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, d.g.c.c.w, d.g.c.c.y
        public x0<K, V> delegate() {
            return (x0) super.delegate();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<K, V> extends Maps.u<K, Collection<V>> {

        /* renamed from: h  reason: collision with root package name */
        public final h0<K, V> f30958h;

        /* renamed from: com.google.common.collect.Multimaps$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0354a extends Maps.j<K, Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0355a implements g<K, Collection<V>> {
                public C0355a() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.a.g
                /* renamed from: a */
                public Collection<V> apply(K k) {
                    return a.this.f30958h.get(k);
                }
            }

            public C0354a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> b() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.d(a.this.f30958h.keySet(), new C0355a());
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    a.this.g(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }
        }

        public a(h0<K, V> h0Var) {
            n.p(h0Var);
            this.f30958h = h0Var;
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0354a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f30958h.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f30958h.containsKey(obj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f30958h.get(obj);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f30958h.removeAll(obj);
            }
            return null;
        }

        public void g(Object obj) {
            this.f30958h.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f30958h.isEmpty();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f30958h.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30958h.keySet().size();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract h0<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return b().containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return b().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    /* loaded from: classes6.dex */
    public static class c<K, V> extends d<K> {

        /* renamed from: e  reason: collision with root package name */
        public final h0<K, V> f30961e;

        /* loaded from: classes6.dex */
        public class a extends a1<Map.Entry<K, Collection<V>>, i0.a<K>> {

            /* renamed from: com.google.common.collect.Multimaps$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0356a extends Multisets.b<K> {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f30962e;

                public C0356a(a aVar, Map.Entry entry) {
                    this.f30962e = entry;
                }

                @Override // d.g.c.c.i0.a
                public int getCount() {
                    return ((Collection) this.f30962e.getValue()).size();
                }

                @Override // d.g.c.c.i0.a
                public K getElement() {
                    return (K) this.f30962e.getKey();
                }
            }

            public a(c cVar, Iterator it) {
                super(it);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: b */
            public i0.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0356a(this, entry);
            }
        }

        public c(h0<K, V> h0Var) {
            this.f30961e = h0Var;
        }

        @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f30961e.clear();
        }

        @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
        public boolean contains(Object obj) {
            return this.f30961e.containsKey(obj);
        }

        @Override // d.g.c.c.i0
        public int count(Object obj) {
            Collection collection = (Collection) Maps.x(this.f30961e.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // d.g.c.c.d
        public int distinctElements() {
            return this.f30961e.asMap().size();
        }

        @Override // d.g.c.c.d
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // d.g.c.c.d, d.g.c.c.i0
        public Set<K> elementSet() {
            return this.f30961e.keySet();
        }

        @Override // d.g.c.c.d
        public Iterator<i0.a<K>> entryIterator() {
            return new a(this, this.f30961e.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.g.c.c.i0
        public Iterator<K> iterator() {
            return Maps.m(this.f30961e.entries().iterator());
        }

        @Override // d.g.c.c.d, d.g.c.c.i0
        public int remove(Object obj, int i) {
            m.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.x(this.f30961e.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
        public int size() {
            return this.f30961e.size();
        }
    }

    public static boolean c(h0<?, ?> h0Var, Object obj) {
        if (obj == h0Var) {
            return true;
        }
        if (obj instanceof h0) {
            return h0Var.asMap().equals(((h0) obj).asMap());
        }
        return false;
    }

    public static <K, V> Collection<Map.Entry<K, V>> d(Collection<Map.Entry<K, V>> collection) {
        if (collection instanceof Set) {
            return Maps.H((Set) collection);
        }
        return new Maps.r(Collections.unmodifiableCollection(collection));
    }

    public static <V> Collection<V> e(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    /* loaded from: classes6.dex */
    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        public static final long serialVersionUID = 0;
        public transient r<? extends SortedSet<V>> factory;
        public transient Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(Map<K, Collection<V>> map, r<? extends SortedSet<V>> rVar) {
            super(map);
            n.p(rVar);
            this.factory = rVar;
            this.valueComparator = rVar.get().comparator();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            r<? extends SortedSet<V>> rVar = (r) objectInputStream.readObject();
            this.factory = rVar;
            this.valueComparator = rVar.get().comparator();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, d.g.c.c.x0
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }
}
