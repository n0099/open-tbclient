package d.f.d.c;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes8.dex */
public interface c1<R, C, V> extends k1<R, C, V> {
    @Override // d.f.d.c.k1
    SortedSet<R> rowKeySet();

    @Override // d.f.d.c.k1
    SortedMap<R, Map<C, V>> rowMap();
}
