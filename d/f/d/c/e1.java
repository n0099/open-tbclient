package d.f.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public interface e1<K, V> extends q0<K, V> {
    @Override // d.f.d.c.q0
    Set<Map.Entry<K, V>> entries();

    @Override // d.f.d.c.q0, d.f.d.c.p0
    Set<V> get(K k);

    @Override // d.f.d.c.q0, d.f.d.c.p0
    Set<V> removeAll(Object obj);

    @Override // d.f.d.c.q0, d.f.d.c.p0
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
