package d.f.d.c;

import java.util.List;
/* loaded from: classes8.dex */
public interface p0<K, V> extends q0<K, V> {
    @Override // 
    List<V> get(K k);

    @Override // 
    List<V> removeAll(Object obj);

    @Override // 
    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
