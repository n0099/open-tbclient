package d.g.c.c;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class c<K, V> implements h0<K, V> {
    public transient Map<K, Collection<V>> asMap;
    public transient Collection<Map.Entry<K, V>> entries;
    public transient Set<K> keySet;
    public transient i0<K> keys;
    public transient Collection<V> values;

    /* loaded from: classes6.dex */
    public class a extends Multimaps.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        public h0<K, V> b() {
            return c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return c.this.entryIterator();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        public b(c cVar) {
            super();
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

    /* renamed from: d.g.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1849c extends AbstractCollection<V> {
        public C1849c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return c.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c.this.size();
        }
    }

    @Override // d.g.c.c.h0
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map == null) {
            Map<K, Collection<V>> createAsMap = createAsMap();
            this.asMap = createAsMap;
            return createAsMap;
        }
        return map;
    }

    @Override // d.g.c.c.h0
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // d.g.c.c.h0
    public boolean containsValue(Object obj) {
        for (Collection<V> collection : asMap().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract i0<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // d.g.c.c.h0
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection == null) {
            Collection<Map.Entry<K, V>> createEntries = createEntries();
            this.entries = createEntries;
            return createEntries;
        }
        return collection;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // d.g.c.c.h0
    public boolean equals(Object obj) {
        return Multimaps.c(this, obj);
    }

    @Override // d.g.c.c.h0
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // d.g.c.c.h0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // d.g.c.c.h0
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return set;
    }

    @Override // d.g.c.c.h0
    public i0<K> keys() {
        i0<K> i0Var = this.keys;
        if (i0Var == null) {
            i0<K> createKeys = createKeys();
            this.keys = createKeys;
            return createKeys;
        }
        return i0Var;
    }

    @Override // d.g.c.c.h0
    public abstract boolean put(K k, V v);

    @Override // d.g.c.c.h0
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        d.g.c.a.n.p(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k), it);
    }

    @Override // d.g.c.c.h0
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // d.g.c.c.h0, d.g.c.c.g0
    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.L(entries().iterator());
    }

    @Override // d.g.c.c.h0
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return collection;
    }

    @Override // d.g.c.c.h0
    public boolean putAll(h0<? extends K, ? extends V> h0Var) {
        boolean z = false;
        for (Map.Entry<? extends K, ? extends V> entry : h0Var.entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }
}
