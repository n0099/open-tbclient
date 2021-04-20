package com.google.common.collect;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.common.base.Converter;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import d.g.c.c.a1;
import d.g.c.c.b0;
import d.g.c.c.c1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Maps {

    /* loaded from: classes6.dex */
    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        public static final long serialVersionUID = 0;
        public final d.g.c.c.k<A, B> bimap;

        public BiMapConverter(d.g.c.c.k<A, B> kVar) {
            d.g.c.a.n.p(kVar);
            this.bimap = kVar;
        }

        public static <X, Y> Y a(d.g.c.c.k<X, Y> kVar, X x) {
            Y y = kVar.get(x);
            d.g.c.a.n.k(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b2) {
            return (A) a(this.bimap.inverse(), b2);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a2) {
            return (B) a(this.bimap, a2);
        }

        @Override // com.google.common.base.Converter, d.g.c.a.g
        public boolean equals(Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public enum EntryFunction implements d.g.c.a.g<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.Maps.EntryFunction, d.g.c.a.g
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.Maps.EntryFunction, d.g.c.a.g
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        @Override // d.g.c.a.g
        public abstract /* synthetic */ T apply(F f2);

        /* synthetic */ EntryFunction(c cVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableBiMap<K, V> extends d.g.c.c.u<K, V> implements d.g.c.c.k<K, V>, Serializable {
        public static final long serialVersionUID = 0;
        public final d.g.c.c.k<? extends K, ? extends V> delegate;
        public d.g.c.c.k<V, K> inverse;
        public final Map<K, V> unmodifiableMap;
        public transient Set<V> values;

        public UnmodifiableBiMap(d.g.c.c.k<? extends K, ? extends V> kVar, d.g.c.c.k<V, K> kVar2) {
            this.unmodifiableMap = Collections.unmodifiableMap(kVar);
            this.delegate = kVar;
            this.inverse = kVar2;
        }

        @Override // d.g.c.c.k
        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.k
        public d.g.c.c.k<V, K> inverse() {
            d.g.c.c.k<V, K> kVar = this.inverse;
            if (kVar == null) {
                UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
                this.inverse = unmodifiableBiMap;
                return unmodifiableBiMap;
            }
            return kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.u, d.g.c.c.y
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.u, java.util.Map, d.g.c.c.k
        public Set<V> values() {
            Set<V> set = this.values;
            if (set == null) {
                Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
                this.values = unmodifiableSet;
                return unmodifiableSet;
            }
            return set;
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableNavigableMap<K, V> extends b0<K, V> implements NavigableMap<K, V>, Serializable {
        public final NavigableMap<K, ? extends V> delegate;

        /* renamed from: e  reason: collision with root package name */
        public transient UnmodifiableNavigableMap<K, V> f30933e;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return Maps.J(this.delegate.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return this.delegate.ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.i(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.f30933e;
            if (unmodifiableNavigableMap == null) {
                UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
                this.f30933e = unmodifiableNavigableMap2;
                return unmodifiableNavigableMap2;
            }
            return unmodifiableNavigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.J(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return Maps.J(this.delegate.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return this.delegate.floorKey(k);
        }

        @Override // d.g.c.c.b0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return Maps.J(this.delegate.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return this.delegate.higherKey(k);
        }

        @Override // d.g.c.c.u, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.J(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return Maps.J(this.delegate.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return this.delegate.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.i(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.b0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // d.g.c.c.b0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.I(this.delegate.headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.I(this.delegate.subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.I(this.delegate.tailMap(k, z));
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.f30933e = unmodifiableNavigableMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.b0, d.g.c.c.u, d.g.c.c.y
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends d.g.c.c.b<K, V2> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f30934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f30935f;

        public a(Map.Entry entry, k kVar) {
            this.f30934e = entry;
            this.f30935f = kVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f30934e.getKey();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, V2] */
        @Override // d.g.c.c.b, java.util.Map.Entry
        public V2 getValue() {
            return this.f30935f.a(this.f30934e.getKey(), this.f30934e.getValue());
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d.g.c.a.g<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f30936e;

        public b(k kVar) {
            this.f30936e = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.C(this.f30936e, entry);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a1<Map.Entry<K, V>, K> {
        public c(Iterator it) {
            super(it);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, K] */
        @Override // d.g.c.c.a1
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a1<Map.Entry<K, V>, V> {
        public d(Iterator it) {
            super(it);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v1, types: [V, java.lang.Object] */
        @Override // d.g.c.c.a1
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a1<K, Map.Entry<K, V>> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g.c.a.g f30937f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Iterator it, d.g.c.a.g gVar) {
            super(it);
            this.f30937f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a1
        /* renamed from: b */
        public Map.Entry<K, V> a(K k) {
            return Maps.j(k, this.f30937f.apply(k));
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f30938e;

        public f(Map.Entry entry) {
            this.f30938e = entry;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f30938e.getKey();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            return this.f30938e.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends c1<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterator f30939e;

        public g(Iterator it) {
            this.f30939e = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return Maps.F((Map.Entry) this.f30939e.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30939e.hasNext();
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements k<K, V1, V2> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.g.c.a.g f30940a;

        public h(d.g.c.a.g gVar) {
            this.f30940a = gVar;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, V2] */
        @Override // com.google.common.collect.Maps.k
        public V2 a(K k, V1 v1) {
            return this.f30940a.apply(v1);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class i<K, V> extends d.g.c.c.u<K, V> implements NavigableMap<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public transient Comparator<? super K> f30941e;

        /* renamed from: f  reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f30942f;

        /* renamed from: g  reason: collision with root package name */
        public transient NavigableSet<K> f30943g;

        /* loaded from: classes6.dex */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, V> b() {
                return i.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return i.this.c();
            }
        }

        public static <T> Ordering<T> e(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        public Set<Map.Entry<K, V>> b() {
            return new a();
        }

        public abstract Iterator<Map.Entry<K, V>> c();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return d().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f30941e;
            if (comparator == null) {
                Comparator<? super K> comparator2 = d().comparator();
                if (comparator2 == null) {
                    comparator2 = Ordering.natural();
                }
                Ordering e2 = e(comparator2);
                this.f30941e = e2;
                return e2;
            }
            return comparator;
        }

        public abstract NavigableMap<K, V> d();

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return d().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return d();
        }

        @Override // d.g.c.c.u, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f30942f;
            if (set == null) {
                Set<Map.Entry<K, V>> b2 = b();
                this.f30942f = b2;
                return b2;
            }
            return set;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return d().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return d().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return d().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return d().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().lowerKey(k);
        }

        @Override // d.g.c.c.u, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return d().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return d().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f30943g;
            if (navigableSet == null) {
                n nVar = new n(this);
                this.f30943g = nVar;
                return nVar;
            }
            return navigableSet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return d().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return d().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return d().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return d().headMap(k, z).descendingMap();
        }

        @Override // d.g.c.c.y
        public String toString() {
            return standardToString();
        }

        @Override // d.g.c.c.u, java.util.Map, d.g.c.c.k
        public Collection<V> values() {
            return new t(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.u, d.g.c.c.y
        public final Map<K, V> delegate() {
            return d();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class j<K, V> extends Sets.a<Map.Entry<K, V>> {
        public abstract Map<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object x = Maps.x(b(), key);
                if (d.g.c.a.k.a(x, entry.getValue())) {
                    return x != null || b().containsKey(key);
                }
                return false;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return b().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                d.g.c.a.n.p(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                return Sets.h(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                d.g.c.a.n.p(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet d2 = Sets.d(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        d2.add(((Map.Entry) obj).getKey());
                    }
                }
                return b().keySet().retainAll(d2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* loaded from: classes6.dex */
    public interface k<K, V1, V2> {
        V2 a(K k, V1 v1);
    }

    /* loaded from: classes6.dex */
    public static abstract class l<K, V> extends AbstractMap<K, V> {

        /* loaded from: classes6.dex */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, V> b() {
                return l.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return l.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* loaded from: classes6.dex */
    public static class m<K, V> extends Sets.a<K> {

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V> f30946e;

        public m(Map<K, V> map) {
            d.g.c.a.n.p(map);
            this.f30946e = map;
        }

        public Map<K, V> b() {
            return this.f30946e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.m(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                b().remove(obj);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* loaded from: classes6.dex */
    public static class n<K, V> extends o<K, V> implements NavigableSet<K> {
        public n(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return c().ceilingKey(k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.o
        /* renamed from: d */
        public NavigableMap<K, V> c() {
            return (NavigableMap) this.f30946e;
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return c().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return c().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return c().headMap(k, z).navigableKeySet();
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
            return (K) Maps.n(c().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.n(c().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return c().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return c().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    /* loaded from: classes6.dex */
    public static class o<K, V> extends m<K, V> implements SortedSet<K> {
        public o(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.m
        /* renamed from: c */
        public SortedMap<K, V> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new o(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new o(b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new o(b().tailMap(k));
        }
    }

    /* loaded from: classes6.dex */
    public static class p<K, V1, V2> extends l<K, V2> {

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V1> f30947e;

        /* renamed from: f  reason: collision with root package name */
        public final k<? super K, ? super V1, V2> f30948f;

        public p(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
            d.g.c.a.n.p(map);
            this.f30947e = map;
            d.g.c.a.n.p(kVar);
            this.f30948f = kVar;
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.w(this.f30947e.entrySet().iterator(), Maps.b(this.f30948f));
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f30947e.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f30947e.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.f30947e.get(obj);
            if (v1 != null || this.f30947e.containsKey(obj)) {
                return this.f30948f.a(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f30947e.keySet();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: V1, ? super V1 */
        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f30947e.containsKey(obj)) {
                return this.f30948f.a(obj, (V1) this.f30947e.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30947e.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new t(this);
        }
    }

    /* loaded from: classes6.dex */
    public static class q<K, V1, V2> extends p<K, V1, V2> implements SortedMap<K, V2> {
        public q(SortedMap<K, V1> sortedMap, k<? super K, ? super V1, V2> kVar) {
            super(sortedMap, kVar);
        }

        public SortedMap<K, V1> b() {
            return (SortedMap) this.f30947e;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return b().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K k) {
            return Maps.B(b().headMap(k), this.f30948f);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return b().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.B(b().subMap(k, k2), this.f30948f);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K k) {
            return Maps.B(b().tailMap(k), this.f30948f);
        }
    }

    /* loaded from: classes6.dex */
    public static class r<K, V> extends d.g.c.c.r<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f30949e;

        public r(Collection<Map.Entry<K, V>> collection) {
            this.f30949e = collection;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.G(this.f30949e.iterator());
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.r, d.g.c.c.y
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f30949e;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* loaded from: classes6.dex */
    public static class s<K, V> extends r<K, V> implements Set<Map.Entry<K, V>> {
        public s(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* loaded from: classes6.dex */
    public static class t<K, V> extends AbstractCollection<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V> f30950e;

        public t(Map<K, V> map) {
            d.g.c.a.n.p(map);
            this.f30950e = map;
        }

        public final Map<K, V> b() {
            return this.f30950e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return b().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.L(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (d.g.c.a.k.a(obj, entry.getValue())) {
                        b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                d.g.c.a.n.p(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet c2 = Sets.c();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c2.add(entry.getKey());
                    }
                }
                return b().keySet().removeAll(c2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                d.g.c.a.n.p(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet c2 = Sets.c();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c2.add(entry.getKey());
                    }
                }
                return b().keySet().retainAll(c2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class u<K, V> extends AbstractMap<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f30951e;

        /* renamed from: f  reason: collision with root package name */
        public transient Set<K> f30952f;

        /* renamed from: g  reason: collision with root package name */
        public transient Collection<V> f30953g;

        public abstract Set<Map.Entry<K, V>> a();

        public Set<K> b() {
            return new m(this);
        }

        public Collection<V> c() {
            return new t(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f30951e;
            if (set == null) {
                Set<Map.Entry<K, V>> a2 = a();
                this.f30951e = a2;
                return a2;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f30952f;
            if (set == null) {
                Set<K> b2 = b();
                this.f30952f = b2;
                return b2;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f30953g;
            if (collection == null) {
                Collection<V> c2 = c();
                this.f30953g = c2;
                return c2;
            }
            return collection;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
        return new p(map, kVar);
    }

    public static <K, V1, V2> SortedMap<K, V2> B(SortedMap<K, V1> sortedMap, k<? super K, ? super V1, V2> kVar) {
        return new q(sortedMap, kVar);
    }

    public static <V2, K, V1> Map.Entry<K, V2> C(k<? super K, ? super V1, V2> kVar, Map.Entry<K, V1> entry) {
        d.g.c.a.n.p(kVar);
        d.g.c.a.n.p(entry);
        return new a(entry, kVar);
    }

    public static <K, V1, V2> Map<K, V2> D(Map<K, V1> map, d.g.c.a.g<? super V1, V2> gVar) {
        return A(map, c(gVar));
    }

    public static <K, V1, V2> SortedMap<K, V2> E(SortedMap<K, V1> sortedMap, d.g.c.a.g<? super V1, V2> gVar) {
        return B(sortedMap, c(gVar));
    }

    public static <K, V> Map.Entry<K, V> F(Map.Entry<? extends K, ? extends V> entry) {
        d.g.c.a.n.p(entry);
        return new f(entry);
    }

    public static <K, V> c1<Map.Entry<K, V>> G(Iterator<Map.Entry<K, V>> it) {
        return new g(it);
    }

    public static <K, V> Set<Map.Entry<K, V>> H(Set<Map.Entry<K, V>> set) {
        return new s(Collections.unmodifiableSet(set));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.NavigableMap<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> NavigableMap<K, V> I(NavigableMap<K, ? extends V> navigableMap) {
        d.g.c.a.n.p(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    public static <K, V> Map.Entry<K, V> J(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return F(entry);
    }

    public static <V> d.g.c.a.g<Map.Entry<?, V>, V> K() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> L(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    public static <V> V M(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> d.g.c.a.o<Map.Entry<?, V>> N(d.g.c.a.o<? super V> oVar) {
        return Predicates.c(oVar, K());
    }

    public static <K, V1, V2> d.g.c.a.g<Map.Entry<K, V1>, Map.Entry<K, V2>> b(k<? super K, ? super V1, V2> kVar) {
        d.g.c.a.n.p(kVar);
        return new b(kVar);
    }

    public static <K, V1, V2> k<K, V1, V2> c(d.g.c.a.g<? super V1, V2> gVar) {
        d.g.c.a.n.p(gVar);
        return new h(gVar);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, d.g.c.a.g<? super K, V> gVar) {
        return new e(set.iterator(), gVar);
    }

    public static int e(int i2) {
        if (i2 < 3) {
            d.g.c.c.m.b(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> boolean f(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(F((Map.Entry) obj));
        }
        return false;
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        return Iterators.f(m(map.entrySet().iterator()), obj);
    }

    public static boolean h(Map<?, ?> map, Object obj) {
        return Iterators.f(L(map.entrySet().iterator()), obj);
    }

    public static boolean i(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> j(K k2, V v) {
        return new ImmutableEntry(k2, v);
    }

    public static <E> ImmutableMap<E, Integer> k(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i2 = 0;
        for (E e2 : collection) {
            bVar.c(e2, Integer.valueOf(i2));
            i2++;
        }
        return bVar.a();
    }

    public static <K> d.g.c.a.g<Map.Entry<K, ?>, K> l() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> m(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    public static <K> K n(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> d.g.c.a.o<Map.Entry<K, ?>> o(d.g.c.a.o<? super K> oVar) {
        return Predicates.c(oVar, l());
    }

    public static <K, V> HashMap<K, V> p() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> q(int i2) {
        return new HashMap<>(e(i2));
    }

    public static <K, V> IdentityHashMap<K, V> r() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> t(int i2) {
        return new LinkedHashMap<>(e(i2));
    }

    public static <K, V> void u(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> boolean v(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(F((Map.Entry) obj));
        }
        return false;
    }

    public static boolean w(Map<?, ?> map, Object obj) {
        d.g.c.a.n.p(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V x(Map<?, V> map, Object obj) {
        d.g.c.a.n.p(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V y(Map<?, V> map, Object obj) {
        d.g.c.a.n.p(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String z(Map<?, ?> map) {
        StringBuilder c2 = d.g.c.c.n.c(map.size());
        c2.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                c2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            z = false;
            c2.append(entry.getKey());
            c2.append(com.alipay.sdk.encrypt.a.f1922h);
            c2.append(entry.getValue());
        }
        c2.append('}');
        return c2.toString();
    }
}
