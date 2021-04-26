package d.g.c.c;

import com.google.common.collect.BoundType;
import d.g.c.c.i0;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
/* loaded from: classes6.dex */
public interface v0<E> extends Object<E>, t0<E> {
    Comparator<? super E> comparator();

    v0<E> descendingMultiset();

    NavigableSet<E> elementSet();

    Set<i0.a<E>> entrySet();

    i0.a<E> firstEntry();

    v0<E> headMultiset(E e2, BoundType boundType);

    i0.a<E> lastEntry();

    i0.a<E> pollFirstEntry();

    i0.a<E> pollLastEntry();

    v0<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2);

    v0<E> tailMultiset(E e2, BoundType boundType);
}
