package d.g.c.c;

import com.google.common.collect.Range;
import java.lang.Comparable;
import java.util.Set;
/* loaded from: classes6.dex */
public interface p0<C extends Comparable> {
    Set<Range<C>> asRanges();

    p0<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(p0<C> p0Var);
}
