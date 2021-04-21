package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.h.c.a.g;
import d.h.c.a.k;
import d.h.c.a.n;
import d.h.c.c.b1;
import d.h.c.c.m;
import d.h.c.f.c;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class Lists {

    /* loaded from: classes6.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;

        public OnePlusArrayList(E e2, E[] eArr) {
            this.first = e2;
            n.p(eArr);
            this.rest = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            n.n(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return c.e(this.rest.length, 1);
        }
    }

    /* loaded from: classes6.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        public final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.List
        public Character get(int i) {
            n.n(i, size());
            return Character.valueOf(this.string.charAt(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i, int i2) {
            n.v(i, i2, size());
            return Lists.b(this.string.substring(i, i2));
        }
    }

    /* loaded from: classes6.dex */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final g<? super F, ? extends T> function;

        /* loaded from: classes6.dex */
        public class a extends b1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // d.h.c.c.a1
            public T a(F f2) {
                return TransformingRandomAccessList.this.function.apply(f2);
            }
        }

        public TransformingRandomAccessList(List<F> list, g<? super F, ? extends T> gVar) {
            n.p(list);
            this.fromList = list;
            n.p(gVar);
            this.function = gVar;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: F, ? super F */
        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.function.apply((F) this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: F, ? super F */
        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply((F) this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        public static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final g<? super F, ? extends T> function;

        /* loaded from: classes6.dex */
        public class a extends b1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // d.h.c.c.a1
            public T a(F f2) {
                return TransformingSequentialList.this.function.apply(f2);
            }
        }

        public TransformingSequentialList(List<F> list, g<? super F, ? extends T> gVar) {
            n.p(list);
            this.fromList = list;
            n.p(gVar);
            this.function = gVar;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;
        public final E second;

        public TwoPlusArrayList(E e2, E e3, E[] eArr) {
            this.first = e2;
            this.second = e3;
            n.p(eArr);
            this.rest = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i != 0) {
                if (i != 1) {
                    n.n(i, size());
                    return this.rest[i - 2];
                }
                return this.second;
            }
            return this.first;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return c.e(this.rest.length, 2);
        }
    }

    public static <E> List<E> a(E e2, E[] eArr) {
        return new OnePlusArrayList(e2, eArr);
    }

    public static ImmutableList<Character> b(String str) {
        n.p(str);
        return new StringAsImmutableList(str);
    }

    public static int c(int i) {
        m.b(i, "arraySize");
        return Ints.j(i + 5 + (i / 10));
    }

    public static boolean d(List<?> list, Object obj) {
        n.p(list);
        if (obj == list) {
            return true;
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                for (int i = 0; i < size; i++) {
                    if (!k.a(list.get(i), list2.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return Iterators.g(list.iterator(), list2.iterator());
        }
        return false;
    }

    public static int e(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (k.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int f(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int g(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return h(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (k.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int h(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> i() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> j(Iterable<? extends E> iterable) {
        n.p(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(d.h.c.c.n.a(iterable));
        }
        return k(iterable.iterator());
    }

    public static <E> ArrayList<E> k(Iterator<? extends E> it) {
        ArrayList<E> i = i();
        Iterators.a(i, it);
        return i;
    }

    public static <E> ArrayList<E> l(int i) {
        m.b(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <E> ArrayList<E> m(int i) {
        return new ArrayList<>(c(i));
    }

    public static <F, T> List<T> n(List<F> list, g<? super F, ? extends T> gVar) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, gVar) : new TransformingSequentialList(list, gVar);
    }
}
