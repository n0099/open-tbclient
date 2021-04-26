package d.g.c.b;

import com.google.common.collect.ImmutableMap;
import d.g.c.c.y;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public abstract class e<K, V> extends y implements c<K, V> {
    @Override // d.g.c.b.c
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // d.g.c.b.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // d.g.c.c.y
    public abstract c<K, V> delegate();

    @Override // d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.g.c.b.c
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k, callable);
    }

    @Override // d.g.c.b.c
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        return delegate().getAllPresent(iterable);
    }

    @Override // d.g.c.b.c
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // d.g.c.b.c
    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    @Override // d.g.c.b.c
    public void invalidateAll(Iterable<?> iterable) {
        delegate().invalidateAll(iterable);
    }

    @Override // d.g.c.b.c
    public void put(K k, V v) {
        delegate().put(k, v);
    }

    @Override // d.g.c.b.c
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // d.g.c.b.c
    public long size() {
        return delegate().size();
    }

    @Override // d.g.c.b.c
    public d stats() {
        return delegate().stats();
    }

    @Override // d.g.c.b.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
