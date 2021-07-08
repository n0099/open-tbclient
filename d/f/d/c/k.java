package d.f.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k, V v);

    k<V, K> inverse();

    @Override // d.f.d.c.k
    Set<V> values();
}
