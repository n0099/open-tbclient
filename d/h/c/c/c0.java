package d.h.c.c;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class c0<E> extends a0<E> implements SortedSet<E> {
    public final int c(Object obj, Object obj2) {
        Comparator<? super E> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // d.h.c.c.a0, d.h.c.c.r, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.h.c.c.a0, d.h.c.c.r, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // d.h.c.c.a0, d.h.c.c.r, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Set delegate();

    @Override // d.h.c.c.a0, d.h.c.c.r, d.h.c.c.y
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e2) {
        return delegate().headSet(e2);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.r
    public boolean standardContains(Object obj) {
        try {
            return c(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.r
    public boolean standardRemove(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && c(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(E e2, E e3) {
        return tailSet(e2).headSet(e3);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e2, E e3) {
        return delegate().subSet(e2, e3);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e2) {
        return delegate().tailSet(e2);
    }
}
