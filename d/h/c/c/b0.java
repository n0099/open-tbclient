package d.h.c.c;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
/* loaded from: classes6.dex */
public abstract class b0<K, V> extends u<K, V> implements SortedMap<K, V> {
    public final int c(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // d.h.c.c.u, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.h.c.c.u, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // d.h.c.c.u, d.h.c.c.y
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    public abstract SortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.u
    public boolean standardContainsKey(Object obj) {
        try {
            return c(tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public SortedMap<K, V> standardSubMap(K k, K k2) {
        d.h.c.a.n.e(c(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    public abstract SortedMap<K, V> subMap(K k, K k2);

    public abstract SortedMap<K, V> tailMap(K k);
}
