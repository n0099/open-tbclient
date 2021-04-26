package d.g.c.c;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes6.dex */
public abstract class s<K, V> extends u<K, V> implements ConcurrentMap<K, V> {
    @Override // d.g.c.c.u, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.g.c.c.u, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // d.g.c.c.u, d.g.c.c.y
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
