package com.google.common.collect;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.a1;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.v0;
import d.g.c.c.x;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class Multisets {

    /* loaded from: classes6.dex */
    public static class ImmutableEntry<E> extends b<E> implements Serializable {
        public static final long serialVersionUID = 0;
        public final int count;
        public final E element;

        public ImmutableEntry(E e2, int i2) {
            this.element = e2;
            this.count = i2;
            m.b(i2, "count");
        }

        @Override // d.g.c.c.i0.a
        public final int getCount() {
            return this.count;
        }

        @Override // d.g.c.c.i0.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class UnmodifiableMultiset<E> extends x<E> implements Serializable {
        public static final long serialVersionUID = 0;
        public final i0<? extends E> delegate;
        public transient Set<E> elementSet;
        public transient Set<i0.a<E>> entrySet;

        public UnmodifiableMultiset(i0<? extends E> i0Var) {
            this.delegate = i0Var;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Queue
        public boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.r, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set == null) {
                Set<E> createElementSet = createElementSet();
                this.elementSet = createElementSet;
                return createElementSet;
            }
            return set;
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public Set<i0.a<E>> entrySet() {
            Set<i0.a<E>> set = this.entrySet;
            if (set == null) {
                Set<i0.a<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
                this.entrySet = unmodifiableSet;
                return unmodifiableSet;
            }
            return set;
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.x(this.delegate.iterator());
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public int setCount(E e2, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public int add(E e2, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public int remove(Object obj, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // d.g.c.c.x, d.g.c.c.i0
        public boolean setCount(E e2, int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: d.g.c.c.i0<? extends E>, d.g.c.c.i0<E> */
        @Override // d.g.c.c.x, d.g.c.c.r, d.g.c.c.y
        public i0<E> delegate() {
            return (i0<? extends E>) this.delegate;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends a1<i0.a<E>, E> {
        public a(Iterator it) {
            super(it);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v1, types: [E, java.lang.Object] */
        @Override // d.g.c.c.a1
        /* renamed from: b */
        public E a(i0.a<E> aVar) {
            return aVar.getElement();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<E> implements i0.a<E> {
        public boolean equals(Object obj) {
            if (obj instanceof i0.a) {
                i0.a aVar = (i0.a) obj;
                return getCount() == aVar.getCount() && k.a(getElement(), aVar.getElement());
            }
            return false;
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // d.g.c.c.i0.a
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c<E> extends Sets.a<E> {
        public abstract i0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return b().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().entrySet().size();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d<E> extends Sets.a<i0.a<E>> {
        public abstract i0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof i0.a) {
                i0.a aVar = (i0.a) obj;
                return aVar.getCount() > 0 && b().count(aVar.getElement()) == aVar.getCount();
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof i0.a) {
                i0.a aVar = (i0.a) obj;
                E e2 = (E) aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return b().setCount(e2, count, 0);
                }
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<E> implements Iterator<E> {

        /* renamed from: e  reason: collision with root package name */
        public final i0<E> f31271e;

        /* renamed from: f  reason: collision with root package name */
        public final Iterator<i0.a<E>> f31272f;

        /* renamed from: g  reason: collision with root package name */
        public i0.a<E> f31273g;

        /* renamed from: h  reason: collision with root package name */
        public int f31274h;

        /* renamed from: i  reason: collision with root package name */
        public int f31275i;
        public boolean j;

        public e(i0<E> i0Var, Iterator<i0.a<E>> it) {
            this.f31271e = i0Var;
            this.f31272f = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31274h > 0 || this.f31272f.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.f31274h == 0) {
                    i0.a<E> next = this.f31272f.next();
                    this.f31273g = next;
                    int count = next.getCount();
                    this.f31274h = count;
                    this.f31275i = count;
                }
                this.f31274h--;
                this.j = true;
                return this.f31273g.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.j);
            if (this.f31275i == 1) {
                this.f31272f.remove();
            } else {
                this.f31271e.remove(this.f31273g.getElement());
            }
            this.f31275i--;
            this.j = false;
        }
    }

    public static <E> boolean a(i0<E> i0Var, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(i0Var);
        return true;
    }

    public static <E> boolean b(i0<E> i0Var, i0<? extends E> i0Var2) {
        if (i0Var2 instanceof AbstractMapBasedMultiset) {
            return a(i0Var, (AbstractMapBasedMultiset) i0Var2);
        }
        if (i0Var2.isEmpty()) {
            return false;
        }
        for (i0.a<? extends E> aVar : i0Var2.entrySet()) {
            i0Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(i0<E> i0Var, Collection<? extends E> collection) {
        n.p(i0Var);
        n.p(collection);
        if (collection instanceof i0) {
            return b(i0Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(i0Var, collection.iterator());
    }

    public static <T> i0<T> d(Iterable<T> iterable) {
        return (i0) iterable;
    }

    public static <E> Iterator<E> e(Iterator<i0.a<E>> it) {
        return new a(it);
    }

    public static boolean f(i0<?> i0Var, Object obj) {
        if (obj == i0Var) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var2 = (i0) obj;
            if (i0Var.size() == i0Var2.size() && i0Var.entrySet().size() == i0Var2.entrySet().size()) {
                for (i0.a aVar : i0Var2.entrySet()) {
                    if (i0Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> i0.a<E> g(E e2, int i2) {
        return new ImmutableEntry(e2, i2);
    }

    public static int h(Iterable<?> iterable) {
        if (iterable instanceof i0) {
            return ((i0) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Iterator<E> i(i0<E> i0Var) {
        return new e(i0Var, i0Var.entrySet().iterator());
    }

    public static int j(i0<?> i0Var) {
        long j = 0;
        for (i0.a<?> aVar : i0Var.entrySet()) {
            j += aVar.getCount();
        }
        return Ints.j(j);
    }

    public static boolean k(i0<?> i0Var, Collection<?> collection) {
        if (collection instanceof i0) {
            collection = ((i0) collection).elementSet();
        }
        return i0Var.elementSet().removeAll(collection);
    }

    public static boolean l(i0<?> i0Var, Collection<?> collection) {
        n.p(collection);
        if (collection instanceof i0) {
            collection = ((i0) collection).elementSet();
        }
        return i0Var.elementSet().retainAll(collection);
    }

    public static <E> int m(i0<E> i0Var, E e2, int i2) {
        m.b(i2, "count");
        int count = i0Var.count(e2);
        int i3 = i2 - count;
        if (i3 > 0) {
            i0Var.add(e2, i3);
        } else if (i3 < 0) {
            i0Var.remove(e2, -i3);
        }
        return count;
    }

    public static <E> boolean n(i0<E> i0Var, E e2, int i2, int i3) {
        m.b(i2, "oldCount");
        m.b(i3, "newCount");
        if (i0Var.count(e2) == i2) {
            i0Var.setCount(e2, i3);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: d.g.c.c.i0<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> i0<E> o(i0<? extends E> i0Var) {
        if ((i0Var instanceof UnmodifiableMultiset) || (i0Var instanceof ImmutableMultiset)) {
            return i0Var;
        }
        n.p(i0Var);
        return new UnmodifiableMultiset(i0Var);
    }

    public static <E> v0<E> p(v0<E> v0Var) {
        n.p(v0Var);
        return new UnmodifiableSortedMultiset(v0Var);
    }
}
