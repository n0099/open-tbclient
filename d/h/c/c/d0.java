package d.h.c.c;

import d.h.c.c.y0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class d0<R, C, V> extends y implements y0<R, C, V> {
    public Set<y0.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public abstract void clear();

    public Map<R, V> column(C c2) {
        return delegate().column(c2);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // d.h.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // d.h.c.c.y0
    public boolean containsColumn(Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // d.h.c.c.y0
    public boolean containsRow(Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // d.h.c.c.y0
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // d.h.c.c.y
    public abstract y0<R, C, V> delegate();

    @Override // d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.h.c.c.y0
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // d.h.c.c.y0
    public V get(Object obj, Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // d.h.c.c.y0
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // d.h.c.c.y0
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public abstract V put(R r, C c2, V v);

    public abstract void putAll(y0<? extends R, ? extends C, ? extends V> y0Var);

    public abstract V remove(Object obj, Object obj2);

    public Map<C, V> row(R r) {
        return delegate().row(r);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // d.h.c.c.y0
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
