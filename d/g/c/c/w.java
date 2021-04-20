package d.g.c.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class w<K, V> extends y implements h0<K, V> {
    public abstract Map<K, Collection<V>> asMap();

    public abstract void clear();

    @Override // d.g.c.c.h0
    public boolean containsEntry(Object obj, Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    @Override // d.g.c.c.h0
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // d.g.c.c.h0
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // d.g.c.c.y
    public abstract h0<K, V> delegate();

    @Override // d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    public abstract Collection<Map.Entry<K, V>> entries();

    @Override // d.g.c.c.h0
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public abstract Collection<V> get(K k);

    @Override // d.g.c.c.h0
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // d.g.c.c.h0
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public abstract Set<K> keySet();

    public abstract i0<K> keys();

    public abstract boolean put(K k, V v);

    public abstract boolean putAll(h0<? extends K, ? extends V> h0Var);

    public abstract boolean putAll(K k, Iterable<? extends V> iterable);

    public abstract boolean remove(Object obj, Object obj2);

    public abstract Collection<V> removeAll(Object obj);

    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    @Override // d.g.c.c.h0
    public int size() {
        return delegate().size();
    }

    public abstract Collection<V> values();
}
