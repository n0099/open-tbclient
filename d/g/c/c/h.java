package d.g.c.c;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import d.g.c.c.i0;
import d.g.c.c.w0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
/* loaded from: classes6.dex */
public abstract class h<E> extends d<E> implements v0<E> {
    public final Comparator<? super E> comparator;
    public transient v0<E> descendingMultiset;

    /* loaded from: classes6.dex */
    public class a extends p<E> {
        public a() {
        }

        @Override // d.g.c.c.p
        public Iterator<i0.a<E>> c() {
            return h.this.descendingEntryIterator();
        }

        @Override // d.g.c.c.p
        public v0<E> d() {
            return h.this;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return h.this.descendingIterator();
        }
    }

    public h() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public v0<E> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator<i0.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public v0<E> descendingMultiset() {
        v0<E> v0Var = this.descendingMultiset;
        if (v0Var == null) {
            v0<E> createDescendingMultiset = createDescendingMultiset();
            this.descendingMultiset = createDescendingMultiset;
            return createDescendingMultiset;
        }
        return v0Var;
    }

    public i0.a<E> firstEntry() {
        Iterator<i0.a<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public i0.a<E> lastEntry() {
        Iterator<i0.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public i0.a<E> pollFirstEntry() {
        Iterator<i0.a<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            i0.a<E> next = entryIterator.next();
            i0.a<E> g2 = Multisets.g(next.getElement(), next.getCount());
            entryIterator.remove();
            return g2;
        }
        return null;
    }

    public i0.a<E> pollLastEntry() {
        Iterator<i0.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            i0.a<E> next = descendingEntryIterator.next();
            i0.a<E> g2 = Multisets.g(next.getElement(), next.getCount());
            descendingEntryIterator.remove();
            return g2;
        }
        return null;
    }

    public v0<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        d.g.c.a.n.p(boundType);
        d.g.c.a.n.p(boundType2);
        return tailMultiset(e2, boundType).headMultiset(e3, boundType2);
    }

    public h(Comparator<? super E> comparator) {
        d.g.c.a.n.p(comparator);
        this.comparator = comparator;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.d
    public NavigableSet<E> createElementSet() {
        return new w0.b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.d, d.g.c.c.i0
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
