package d.h.c.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public interface i0<E> extends Collection<E> {

    /* loaded from: classes6.dex */
    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e2, int i);

    @Override // java.util.Collection, d.h.c.c.i0
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // d.h.c.c.i0
    boolean equals(Object obj);

    @Override // d.h.c.c.i0
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable, d.h.c.c.i0
    Iterator<E> iterator();

    int remove(Object obj, int i);

    @Override // java.util.Collection, d.h.c.c.i0
    boolean remove(Object obj);

    int setCount(E e2, int i);

    boolean setCount(E e2, int i, int i2);

    @Override // java.util.Collection, d.h.c.c.i0
    int size();
}
