package d.h.c.c;

import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public interface x0<K, V> extends s0<K, V> {
    @Override // d.h.c.c.s0, d.h.c.c.h0, d.h.c.c.g0
    SortedSet<V> get(K k);

    @Override // d.h.c.c.s0, d.h.c.c.h0, d.h.c.c.g0
    SortedSet<V> removeAll(Object obj);

    @Override // d.h.c.c.s0, d.h.c.c.h0, d.h.c.c.g0
    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
