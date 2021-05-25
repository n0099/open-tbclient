package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import d.g.c.c.c;
import d.g.c.c.i0;
import d.g.c.c.s0;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends d.g.c.c.c<K, V> implements Serializable {
    public static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> map;
    public transient int totalSize;

    /* loaded from: classes6.dex */
    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public V a(K k, V v) {
            return v;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* renamed from: b */
        public Map.Entry<K, V> a(K k, V v) {
            return Maps.j(k, v);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends Maps.u<K, Collection<V>> {

        /* renamed from: h  reason: collision with root package name */
        public final transient Map<K, Collection<V>> f30892h;

        /* loaded from: classes6.dex */
        public class a extends Maps.j<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> b() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return d.g.c.c.n.d(c.this.f30892h.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f30895e;

            /* renamed from: f  reason: collision with root package name */
            public Collection<V> f30896f;

            public b() {
                this.f30895e = c.this.f30892h.entrySet().iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f30895e.next();
                this.f30896f = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30895e.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                d.g.c.c.m.e(this.f30896f != null);
                this.f30895e.remove();
                AbstractMapBasedMultimap.this.totalSize -= this.f30896f.size();
                this.f30896f.clear();
                this.f30896f = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.f30892h = map;
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f30892h == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.w(this.f30892h, obj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.x(this.f30892h, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f30892h.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.this.totalSize -= remove.size();
            remove.clear();
            return createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f30892h.equals(obj);
        }

        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.j(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f30892h.hashCode();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30892h.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f30892h.toString();
        }
    }

    /* loaded from: classes6.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f30898e;

        /* renamed from: f  reason: collision with root package name */
        public K f30899f = null;

        /* renamed from: g  reason: collision with root package name */
        public Collection<V> f30900g = null;

        /* renamed from: h  reason: collision with root package name */
        public Iterator<V> f30901h = Iterators.j();

        /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K, java.util.Collection<V>>> */
        public d() {
            this.f30898e = (Iterator<Map.Entry<K, V>>) AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30898e.hasNext() || this.f30901h.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f30901h.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f30898e.next();
                this.f30899f = next.getKey();
                Collection<V> value = next.getValue();
                this.f30900g = value;
                this.f30901h = value.iterator();
            }
            return a(this.f30899f, this.f30901h.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f30901h.remove();
            if (this.f30900g.isEmpty()) {
                this.f30898e.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends Maps.m<K, Collection<V>> {

        /* loaded from: classes6.dex */
        public class a implements Iterator<K> {

            /* renamed from: e  reason: collision with root package name */
            public Map.Entry<K, Collection<V>> f30904e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Iterator f30905f;

            public a(Iterator it) {
                this.f30905f = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30905f.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f30905f.next();
                this.f30904e = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                d.g.c.c.m.e(this.f30904e != null);
                Collection<V> value = this.f30904e.getValue();
                this.f30905f.remove();
                AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
                this.f30904e = null;
            }
        }

        public e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(b().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i2;
            Collection<V> remove = b().remove(obj);
            if (remove != null) {
                i2 = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.this.totalSize -= i2;
            } else {
                i2 = 0;
            }
            return i2 > 0;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return i().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return i().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return i().higherKey(k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: j */
        public NavigableSet<K> g() {
            return new g(i());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: l */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return i().lowerKey(k);
        }

        public Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (it.hasNext()) {
                Map.Entry<K, Collection<V>> next = it.next();
                Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
                createCollection.addAll(next.getValue());
                it.remove();
                return Maps.j(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new f(i().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new f(i().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new f(i().tailMap(k, z));
        }
    }

    /* loaded from: classes6.dex */
    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return c().ceilingKey(k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: d */
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(c().descendingMap());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* renamed from: e */
        public NavigableMap<K, Collection<V>> c() {
            return (NavigableMap) super.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f */
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return c().floorKey(k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: g */
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return c().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new g(c().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new g(c().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new g(c().tailMap(k, z));
        }
    }

    /* loaded from: classes6.dex */
    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public h(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, list, kVar);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {
        public SortedSet<K> j;

        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.u
        /* renamed from: g */
        public SortedSet<K> b() {
            return new j(i());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.j;
            if (sortedSet == null) {
                SortedSet<K> b2 = b();
                this.j = b2;
                return b2;
            }
            return sortedSet;
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new i(i().headMap(k));
        }

        public SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.f30892h;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new i(i().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new i(i().tailMap(k));
        }
    }

    /* loaded from: classes6.dex */
    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> c() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new j(c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new j(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new j(c().tailMap(k));
        }
    }

    /* loaded from: classes6.dex */
    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        public m(K k, NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return h().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(h().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return j(h().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return h().floor(v);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return j(h().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return h().higher(v);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* renamed from: i */
        public NavigableSet<V> h() {
            return (NavigableSet) super.h();
        }

        public final NavigableSet<V> j(NavigableSet<V> navigableSet) {
            return new m(this.f30909e, navigableSet, c() == null ? this : c());
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return h().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return j(h().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return j(h().tailSet(v, z));
        }
    }

    /* loaded from: classes6.dex */
    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        public n(K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean g2 = Sets.g((Set) this.f30910f, collection);
            if (g2) {
                int size2 = this.f30910f.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                g();
            }
            return g2;
        }
    }

    /* loaded from: classes6.dex */
    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        public o(K k, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            f();
            return h().first();
        }

        public SortedSet<V> h() {
            return (SortedSet) d();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            f();
            return new o(e(), h().headSet(v), c() == null ? this : c());
        }

        @Override // java.util.SortedSet
        public V last() {
            f();
            return h().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            f();
            return new o(e(), h().subSet(v, v2), c() == null ? this : c());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            f();
            return new o(e(), h().tailSet(v), c() == null ? this : c());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        d.g.c.a.n.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 - 1;
        return i2;
    }

    private Collection<V> getOrCreateCollection(K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k2);
            this.map.put(k2, createCollection);
            return createCollection;
        }
        return collection;
    }

    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.y(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // d.g.c.c.h0
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // d.g.c.c.h0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // d.g.c.c.c
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(K k2) {
        return createCollection();
    }

    @Override // d.g.c.c.c
    public Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof s0) {
            return new c.b(this);
        }
        return new c.a();
    }

    @Override // d.g.c.c.c
    public Set<K> createKeySet() {
        return new e(this.map);
    }

    @Override // d.g.c.c.c
    public i0<K> createKeys() {
        return new Multimaps.c(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new i((SortedMap) this.map);
        }
        return new c(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new j((SortedMap) this.map);
        }
        return new e(this.map);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Collection<V>, java.util.Collection<E> */
    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // d.g.c.c.c
    public Collection<V> createValues() {
        return new c.C1849c();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // d.g.c.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // d.g.c.c.h0, d.g.c.c.g0
    public Collection<V> get(K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            collection = createCollection(k2);
        }
        return wrapCollection(k2, collection);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public boolean put(K k2, V v) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k2);
            if (createCollection.add(v)) {
                this.totalSize++;
                this.map.put(k2, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(v)) {
            this.totalSize++;
            return true;
        } else {
            return false;
        }
    }

    @Override // d.g.c.c.h0, d.g.c.c.g0
    public Collection<V> removeAll(Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    public Collection<V> replaceValues(K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k2);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k2);
        Collection createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            d.g.c.a.n.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // d.g.c.c.h0
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // d.g.c.c.c
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(K k2, Collection<V> collection) {
        return new k(k2, collection, null);
    }

    public final List<V> wrapList(K k2, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k2, list, kVar) : new l(k2, list, kVar);
    }

    /* loaded from: classes6.dex */
    public class k extends AbstractCollection<V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30909e;

        /* renamed from: f  reason: collision with root package name */
        public Collection<V> f30910f;

        /* renamed from: g  reason: collision with root package name */
        public final AbstractMapBasedMultimap<K, V>.k f30911g;

        /* renamed from: h  reason: collision with root package name */
        public final Collection<V> f30912h;

        public k(K k, Collection<V> collection, AbstractMapBasedMultimap<K, V>.k kVar) {
            this.f30909e = k;
            this.f30910f = collection;
            this.f30911g = kVar;
            this.f30912h = kVar == null ? null : kVar.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            f();
            boolean isEmpty = this.f30910f.isEmpty();
            boolean add = this.f30910f.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    b();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f30910f.addAll(collection);
            if (addAll) {
                int size2 = this.f30910f.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        public void b() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f30911g;
            if (kVar == null) {
                AbstractMapBasedMultimap.this.map.put(this.f30909e, this.f30910f);
            } else {
                kVar.b();
            }
        }

        public AbstractMapBasedMultimap<K, V>.k c() {
            return this.f30911g;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f30910f.clear();
            AbstractMapBasedMultimap.this.totalSize -= size;
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.f30910f.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            f();
            return this.f30910f.containsAll(collection);
        }

        public Collection<V> d() {
            return this.f30910f;
        }

        public K e() {
            return this.f30909e;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f30910f.equals(obj);
        }

        public void f() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.k kVar = this.f30911g;
            if (kVar != null) {
                kVar.f();
                if (this.f30911g.d() != this.f30912h) {
                    throw new ConcurrentModificationException();
                }
            } else if (!this.f30910f.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f30909e)) == null) {
            } else {
                this.f30910f = collection;
            }
        }

        public void g() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f30911g;
            if (kVar != null) {
                kVar.g();
            } else if (this.f30910f.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f30909e);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f30910f.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean remove = this.f30910f.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                g();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f30910f.removeAll(collection);
            if (removeAll) {
                int size2 = this.f30910f.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                g();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            d.g.c.a.n.p(collection);
            int size = size();
            boolean retainAll = this.f30910f.retainAll(collection);
            if (retainAll) {
                int size2 = this.f30910f.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                g();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f30910f.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f30910f.toString();
        }

        /* loaded from: classes6.dex */
        public class a implements Iterator<V> {

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<V> f30914e;

            /* renamed from: f  reason: collision with root package name */
            public final Collection<V> f30915f;

            public a() {
                this.f30915f = k.this.f30910f;
                this.f30914e = AbstractMapBasedMultimap.iteratorOrListIterator(k.this.f30910f);
            }

            public Iterator<V> a() {
                b();
                return this.f30914e;
            }

            public void b() {
                k.this.f();
                if (k.this.f30910f != this.f30915f) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f30914e.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f30914e.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f30914e.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.g();
            }

            public a(Iterator<V> it) {
                this.f30915f = k.this.f30910f;
                this.f30914e = it;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        /* loaded from: classes6.dex */
        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    l.this.b();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            public a(int i2) {
                super(l.this.h().listIterator(i2));
            }
        }

        public l(K k, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, list, kVar);
        }

        @Override // java.util.List
        public void add(int i2, V v) {
            f();
            boolean isEmpty = d().isEmpty();
            h().add(i2, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = h().addAll(i2, collection);
            if (addAll) {
                int size2 = d().size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i2) {
            f();
            return h().get(i2);
        }

        public List<V> h() {
            return (List) d();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i2) {
            f();
            V remove = h().remove(i2);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            g();
            return remove;
        }

        @Override // java.util.List
        public V set(int i2, V v) {
            f();
            return h().set(i2, v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.AbstractMapBasedMultimap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i2, int i3) {
            f();
            return AbstractMapBasedMultimap.this.wrapList(e(), h().subList(i2, i3), c() == null ? this : c());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i2) {
            f();
            return new a(i2);
        }
    }
}
