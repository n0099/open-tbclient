package d.g.c.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k, V v);

    k<V, K> inverse();

    @Override // d.g.c.c.k
    Set<V> values();
}
