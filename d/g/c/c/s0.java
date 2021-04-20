package d.g.c.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface s0<K, V> extends h0<K, V> {
    @Override // d.g.c.c.h0
    Set<Map.Entry<K, V>> entries();

    @Override // d.g.c.c.h0, d.g.c.c.g0
    Set<V> get(K k);

    @Override // d.g.c.c.h0, d.g.c.c.g0
    Set<V> removeAll(Object obj);

    @Override // d.g.c.c.h0, d.g.c.c.g0
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
