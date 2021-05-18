package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.j0;
import d.g.c.c.m;
import d.g.c.c.n0;
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
        public Object[] f31083a;

        /* renamed from: b  reason: collision with root package name */
        public int f31084b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31085c;

        public a(int i2) {
            m.b(i2, "initialCapacity");
            this.f31083a = new Object[i2];
            this.f31084b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> b(E... eArr) {
            j0.b(eArr);
            g(this.f31084b + eArr.length);
            System.arraycopy(eArr, 0, this.f31083a, this.f31084b, eArr.length);
            this.f31084b += eArr.length;
            return this;
        }

        public a<E> f(E e2) {
            n.p(e2);
            g(this.f31084b + 1);
            Object[] objArr = this.f31083a;
            int i2 = this.f31084b;
            this.f31084b = i2 + 1;
            objArr[i2] = e2;
            return this;
        }

        public final void g(int i2) {
            Object[] objArr = this.f31083a;
            if (objArr.length < i2) {
                this.f31083a = Arrays.copyOf(objArr, b.e(objArr.length, i2));
                this.f31085c = false;
            } else if (this.f31085c) {
                this.f31083a = (Object[]) objArr.clone();
                this.f31085c = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<E> {
        public static int e(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
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

    public int copyIntoArray(Object[] objArr, int i2) {
        c1<E> it = iterator();
        while (it.hasNext()) {
            objArr[i2] = it.next();
            i2++;
        }
        return i2;
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
