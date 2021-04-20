package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.g.c.a.n;
import d.g.c.c.d;
import d.g.c.c.i0;
import d.g.c.c.k0;
import d.g.c.c.m;
import d.g.c.c.r0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public transient k0<E> backingMap;
    public transient long size;

    /* loaded from: classes6.dex */
    public class a extends AbstractMapBasedMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public E b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.i(i);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractMapBasedMultiset<E>.c<i0.a<E>> {
        public b() {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c */
        public i0.a<E> b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.g(i);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f30699e;

        /* renamed from: f  reason: collision with root package name */
        public int f30700f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f30701g;

        public c() {
            this.f30699e = AbstractMapBasedMultiset.this.backingMap.e();
            this.f30701g = AbstractMapBasedMultiset.this.backingMap.f66992d;
        }

        public final void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f66992d != this.f30701g) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f30699e >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T b2 = b(this.f30699e);
                int i = this.f30699e;
                this.f30700f = i;
                this.f30699e = AbstractMapBasedMultiset.this.backingMap.s(i);
                return b2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractMapBasedMultiset abstractMapBasedMultiset;
            a();
            m.e(this.f30700f != -1);
            AbstractMapBasedMultiset.this.size -= abstractMapBasedMultiset.backingMap.x(this.f30700f);
            this.f30699e = AbstractMapBasedMultiset.this.backingMap.t(this.f30699e, this.f30700f);
            this.f30700f = -1;
            this.f30701g = AbstractMapBasedMultiset.this.backingMap.f66992d;
        }
    }

    public AbstractMapBasedMultiset(int i) {
        init(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h2 = r0.h(objectInputStream);
        init(3);
        r0.g(this, objectInputStream, h2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        r0.k(this, objectOutputStream);
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public final int add(E e2, int i) {
        if (i == 0) {
            return count(e2);
        }
        n.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(e2);
        if (m == -1) {
            this.backingMap.u(e2, i);
            this.size += i;
            return 0;
        }
        int k = this.backingMap.k(m);
        long j = i;
        long j2 = k + j;
        n.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.B(m, (int) j2);
        this.size += j;
        return k;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: E, ? super E */
    public void addTo(i0<? super E> i0Var) {
        n.p(i0Var);
        int e2 = this.backingMap.e();
        while (e2 >= 0) {
            i0Var.add((E) this.backingMap.i(e2), this.backingMap.k(e2));
            e2 = this.backingMap.s(e2);
        }
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // d.g.c.c.i0
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // d.g.c.c.d
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // d.g.c.c.d
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // d.g.c.c.d
    public final Iterator<i0.a<E>> entryIterator() {
        return new b();
    }

    public abstract void init(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.g.c.c.i0
    public final Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public final int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        n.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(obj);
        if (m == -1) {
            return 0;
        }
        int k = this.backingMap.k(m);
        if (k > i) {
            this.backingMap.B(m, k - i);
        } else {
            this.backingMap.x(m);
            i = k;
        }
        this.size -= i;
        return k;
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public final int setCount(E e2, int i) {
        m.b(i, "count");
        k0<E> k0Var = this.backingMap;
        int v = i == 0 ? k0Var.v(e2) : k0Var.u(e2, i);
        this.size += i - v;
        return v;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public final int size() {
        return Ints.j(this.size);
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public final boolean setCount(E e2, int i, int i2) {
        m.b(i, "oldCount");
        m.b(i2, "newCount");
        int m = this.backingMap.m(e2);
        if (m == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(e2, i2);
                this.size += i2;
            }
            return true;
        } else if (this.backingMap.k(m) != i) {
            return false;
        } else {
            if (i2 == 0) {
                this.backingMap.x(m);
                this.size -= i;
            } else {
                this.backingMap.B(m, i2);
                this.size += i2 - i;
            }
            return true;
        }
    }
}
