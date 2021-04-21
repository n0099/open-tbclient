package d.h.c.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k, V v);

    k<V, K> inverse();

    @Override // d.h.c.c.k
    Set<V> values();
}
