package d.g.c.c;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class u0 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? Ordering.natural() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        d.g.c.a.n.p(comparator);
        d.g.c.a.n.p(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof t0)) {
            return false;
        } else {
            comparator2 = ((t0) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
