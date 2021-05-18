package com.google.common.collect;

import com.baidu.mobstat.Config;
import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.c.f0;
import d.g.c.c.m;
import d.g.c.c.n0;
import d.g.c.c.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static final int LEFT_IS_GREATER = 1;
    public static final int RIGHT_IS_GREATER = -1;

    /* loaded from: classes6.dex */
    public static class IncomparableValueException extends ClassCastException {
        public static final long serialVersionUID = 0;
        public final Object value;

        public IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends Ordering<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f31280e = new AtomicInteger(0);

        /* renamed from: f  reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f31281f;

        public a() {
            MapMaker mapMaker = new MapMaker();
            n0.i(mapMaker);
            this.f31281f = mapMaker.i();
        }

        public final Integer a(Object obj) {
            Integer num = this.f31281f.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.f31280e.getAndIncrement());
                Integer putIfAbsent = this.f31281f.putIfAbsent(obj, valueOf);
                return putIfAbsent != null ? putIfAbsent : valueOf;
            }
            return num;
        }

        public int b(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b2 = b(obj);
            int b3 = b(obj2);
            if (b2 != b3) {
                return b2 < b3 ? -1 : 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Ordering<Object> f31282a = new a();
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f31282a;
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        n.p(comparator);
        return new CompoundOrdering(this, comparator);
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i2) {
        return reverse().leastOf(iterable, i2);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i2) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i2 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i2) {
                    array = Arrays.copyOf(array, i2);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i2);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.l());
    }

    public <F> Ordering<F> onResultOf(g<F, ? extends T> gVar) {
        return new ByFunctionOrdering(gVar, this);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] k = f0.k(iterable);
        Arrays.sort(k, this);
        return Lists.j(Arrays.asList(k));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.a(t, tArr));
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        n.p(ordering);
        return ordering;
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i2) {
        return reverse().leastOf(it, i2);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: E extends T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E extends T */
    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e2, E e3) {
        return compare(e2, e3) >= 0 ? e2 : e3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: E extends T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E extends T */
    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e2, E e3) {
        return compare(e2, e3) <= 0 ? e2 : e3;
    }

    public <E extends T> E max(E e2, E e3, E e4, E... eArr) {
        E e5 = (E) max(max(e2, e3), e4);
        for (E e6 : eArr) {
            e5 = (E) max(e5, e6);
        }
        return e5;
    }

    public <E extends T> E min(E e2, E e3, E e4, E... eArr) {
        E e5 = (E) min(min(e2, e3), e4);
        for (E e6 : eArr) {
            e5 = (E) min(e5, e6);
        }
        return e5;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i2) {
        n.p(it);
        m.b(i2, Config.APP_KEY);
        if (i2 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i2 >= 1073741823) {
            ArrayList k = Lists.k(it);
            Collections.sort(k, this);
            if (k.size() > i2) {
                k.subList(i2, k.size()).clear();
            }
            k.trimToSize();
            return Collections.unmodifiableList(k);
        }
        z0 a2 = z0.a(i2, this);
        a2.c(it);
        return a2.f();
    }
}
