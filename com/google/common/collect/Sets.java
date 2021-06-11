package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c0;
import d.g.c.c.i0;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public final class Sets {

    /* loaded from: classes6.dex */
    public static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.g(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            n.p(collection);
            return super.retainAll(collection);
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static <E> HashSet<E> c() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> d(int i2) {
        return new HashSet<>(Maps.e(i2));
    }

    public static <E> Set<E> e() {
        return Collections.newSetFromMap(Maps.r());
    }

    public static <E> LinkedHashSet<E> f() {
        return new LinkedHashSet<>();
    }

    public static boolean g(Set<?> set, Collection<?> collection) {
        n.p(collection);
        if (collection instanceof i0) {
            collection = ((i0) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return Iterators.r(set.iterator(), collection);
        }
        return h(set, collection.iterator());
    }

    public static boolean h(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static <E> NavigableSet<E> i(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    /* loaded from: classes6.dex */
    public static final class UnmodifiableNavigableSet<E> extends c0<E> implements NavigableSet<E>, Serializable {
        public static final long serialVersionUID = 0;
        public final NavigableSet<E> delegate;

        /* renamed from: e  reason: collision with root package name */
        public transient UnmodifiableNavigableSet<E> f31337e;
        public final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            n.p(navigableSet);
            this.delegate = navigableSet;
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.delegate.ceiling(e2);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.x(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.f31337e;
            if (unmodifiableNavigableSet == null) {
                UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
                this.f31337e = unmodifiableNavigableSet2;
                unmodifiableNavigableSet2.f31337e = this;
                return unmodifiableNavigableSet2;
            }
            return unmodifiableNavigableSet;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.delegate.floor(e2);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            return Sets.i(this.delegate.headSet(e2, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.delegate.higher(e2);
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.delegate.lower(e2);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            return Sets.i(this.delegate.subSet(e2, z, e3, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            return Sets.i(this.delegate.tailSet(e2, z));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.c0, d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }
}
