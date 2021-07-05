package d.f.d.c;

import com.google.common.collect.BoundType;
import d.f.d.c.s0;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
/* loaded from: classes10.dex */
public interface h1<E> extends Object<E>, f1<E> {
    Comparator<? super E> comparator();

    h1<E> descendingMultiset();

    NavigableSet<E> elementSet();

    Set<s0.a<E>> entrySet();

    s0.a<E> firstEntry();

    h1<E> headMultiset(E e2, BoundType boundType);

    s0.a<E> lastEntry();

    s0.a<E> pollFirstEntry();

    s0.a<E> pollLastEntry();

    h1<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2);

    h1<E> tailMultiset(E e2, BoundType boundType);
}
