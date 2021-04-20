package d.g.c.c;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public interface q0<R, C, V> extends y0<R, C, V> {
    @Override // d.g.c.c.y0
    SortedSet<R> rowKeySet();

    @Override // d.g.c.c.y0
    SortedMap<R, Map<C, V>> rowMap();
}
