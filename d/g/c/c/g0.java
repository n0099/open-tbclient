package d.g.c.c;

import java.util.List;
/* loaded from: classes6.dex */
public interface g0<K, V> extends h0<K, V> {
    @Override // 
    List<V> get(K k);

    @Override // 
    List<V> removeAll(Object obj);

    @Override // 
    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
