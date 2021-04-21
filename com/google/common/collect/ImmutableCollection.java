package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import d.h.c.a.n;
import d.h.c.c.c1;
import d.h.c.c.j0;
import d.h.c.c.m;
import d.h.c.c.n0;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] EMPTY_ARRAY = new Object[0];

    /* loaded from: classes6.dex */
    public static abstract class a<E> extends b<E> {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f30879a;

        /* renamed from: b  reason: collision with root package name */
        public int f30880b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30881c;

        public a(int i) {
            m.b(i, "initialCapacity");
            this.f30879a = new Object[i];
            this.f30880b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> b(E... eArr) {
            j0.b(eArr);
            g(this.f30880b + eArr.length);
            System.arraycopy(eArr, 0, this.f30879a, this.f30880b, eArr.length);
            this.f30880b += eArr.length;
            return this;
        }

        public a<E> f(E e2) {
            n.p(e2);
            g(this.f30880b + 1);
            Object[] objArr = this.f30879a;
            int i = this.f30880b;
            this.f30880b = i + 1;
            objArr[i] = e2;
            return this;
        }

        public final void g(int i) {
            Object[] objArr = this.f30879a;
            if (objArr.length < i) {
                this.f30879a = Arrays.copyOf(objArr, b.e(objArr.length, i));
                this.f30881c = false;
            } else if (this.f30881c) {
                this.f30879a = (Object[]) objArr.clone();
                this.f30881c = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<E> {
        public static int e(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i3;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public abstract b<E> a(E e2);

        public b<E> b(E... eArr) {
            for (E e2 : eArr) {
                a(e2);
            }
            return this;
        }

        public b<E> c(Iterable<? extends E> iterable) {
            for (E e2 : iterable) {
                a(e2);
            }
            return this;
        }

        public b<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int copyIntoArray(Object[] objArr, int i) {
        c1<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract c1<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        n.p(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) n0.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) j0.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
