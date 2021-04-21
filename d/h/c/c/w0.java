package d.h.c.c;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets;
import d.h.c.c.i0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class w0 {

    /* loaded from: classes6.dex */
    public static class a<E> extends Multisets.c<E> implements SortedSet<E> {

        /* renamed from: e  reason: collision with root package name */
        public final v0<E> f67161e;

        public a(v0<E> v0Var) {
            this.f67161e = v0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multisets.c
        /* renamed from: c */
        public final v0<E> b() {
            return this.f67161e;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) w0.d(b().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e2) {
            return b().headMultiset(e2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.e(b().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) w0.d(b().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e2, E e3) {
            return b().subMultiset(e2, BoundType.CLOSED, e3, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e2) {
            return b().tailMultiset(e2, BoundType.CLOSED).elementSet();
        }
    }

    /* loaded from: classes6.dex */
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public b(v0<E> v0Var) {
            super(v0Var);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return (E) w0.c(b().tailMultiset(e2, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(b().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return (E) w0.c(b().headMultiset(e2, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            return new b(b().headMultiset(e2, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return (E) w0.c(b().tailMultiset(e2, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return (E) w0.c(b().headMultiset(e2, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) w0.c(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) w0.c(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            return new b(b().subMultiset(e2, BoundType.forBoolean(z), e3, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            return new b(b().tailMultiset(e2, BoundType.forBoolean(z)));
        }
    }

    public static <E> E c(i0.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getElement();
    }

    public static <E> E d(i0.a<E> aVar) {
        if (aVar != null) {
            return aVar.getElement();
        }
        throw new NoSuchElementException();
    }
}
