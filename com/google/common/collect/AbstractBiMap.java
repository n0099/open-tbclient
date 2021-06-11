package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.a0;
import d.g.c.c.k;
import d.g.c.c.m;
import d.g.c.c.u;
import d.g.c.c.v;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class AbstractBiMap<K, V> extends u<K, V> implements k<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient Map<K, V> delegate;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient AbstractBiMap<V, K> inverse;
    public transient Set<K> keySet;
    public transient Set<V> valueSet;

    /* loaded from: classes6.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        public static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, d.g.c.c.y
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map, d.g.c.c.k
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public Map.Entry<K, V> f30970e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterator f30971f;

        public a(Iterator it) {
            this.f30971f = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f30971f.next();
            this.f30970e = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30971f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f30970e != null);
            V value = this.f30970e.getValue();
            this.f30971f.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.f30970e = null;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends v<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final Map.Entry<K, V> f30973e;

        public b(Map.Entry<K, V> entry) {
            this.f30973e = entry;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.y
        /* renamed from: b */
        public Map.Entry<K, V> delegate() {
            return this.f30973e;
        }

        @Override // d.g.c.c.v, java.util.Map.Entry
        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            n.x(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (d.g.c.a.k.a(v, getValue())) {
                return v;
            }
            n.k(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.f30973e.setValue(v);
            n.x(d.g.c.a.k.a(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends a0<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f30975e;

        public c() {
            this.f30975e = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.f(delegate(), obj);
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (this.f30975e.contains(obj)) {
                Map.Entry entry = (Map.Entry) obj;
                AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
                this.f30975e.remove(entry);
                return true;
            }
            return false;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<Map.Entry<K, V>> delegate() {
            return this.f30975e;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends a0<K> {
        public d() {
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.m(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                AbstractBiMap.this.removeFromBothMaps(obj);
                return true;
            }
            return false;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends a0<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Set<V> f30978e;

        public e() {
            this.f30978e = AbstractBiMap.this.inverse.keySet();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.L(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // d.g.c.c.y
        public String toString() {
            return standardToString();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<V> delegate() {
            return this.f30978e;
        }
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && d.g.c.a.k.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            n.k(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    public K checkKey(K k) {
        return k;
    }

    public V checkValue(V v) {
        return v;
    }

    @Override // d.g.c.c.u, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // d.g.c.c.u, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // d.g.c.c.u, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            c cVar = new c(this, null);
            this.entrySet = cVar;
            return cVar;
        }
        return set;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator());
    }

    @Override // d.g.c.c.k
    public V forcePut(K k, V v) {
        return putInBothMaps(k, v, true);
    }

    @Override // d.g.c.c.k
    public k<V, K> inverse() {
        return this.inverse;
    }

    @Override // d.g.c.c.u, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            d dVar = new d(this, null);
            this.keySet = dVar;
            return dVar;
        }
        return set;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // d.g.c.c.u, java.util.Map
    public V put(K k, V v) {
        return putInBothMaps(k, v, false);
    }

    @Override // d.g.c.c.u, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // d.g.c.c.u, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        n.w(this.delegate == null);
        n.w(this.inverse == null);
        n.d(map.isEmpty());
        n.d(map2.isEmpty());
        n.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.u, d.g.c.c.y
    public Map<K, V> delegate() {
        return this.delegate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.u, java.util.Map, d.g.c.c.k
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            e eVar = new e(this, null);
            this.valueSet = eVar;
            return eVar;
        }
        return set;
    }

    public AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
