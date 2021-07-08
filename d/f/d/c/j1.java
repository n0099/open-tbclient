package d.f.d.c;

import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes8.dex */
public interface j1<K, V> extends e1<K, V> {
    @Override // d.f.d.c.e1, d.f.d.c.q0, d.f.d.c.p0
    SortedSet<V> get(K k);

    @Override // d.f.d.c.e1, d.f.d.c.q0, d.f.d.c.p0
    SortedSet<V> removeAll(Object obj);

    @Override // d.f.d.c.e1, d.f.d.c.q0, d.f.d.c.p0
    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
