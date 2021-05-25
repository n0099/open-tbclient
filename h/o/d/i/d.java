package h.o.d.i;

import h.o.d.j.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class d<T> implements Queue<T> {
    public static final int m = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object n = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f68693e;

    /* renamed from: f  reason: collision with root package name */
    public int f68694f;

    /* renamed from: g  reason: collision with root package name */
    public long f68695g;

    /* renamed from: h  reason: collision with root package name */
    public int f68696h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicReferenceArray<Object> f68697i;
    public int j;
    public AtomicReferenceArray<Object> k;
    public final AtomicLong l;

    public d(int i2) {
        int b2 = i.b(i2);
        int i3 = b2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b2 + 1);
        this.f68697i = atomicReferenceArray;
        this.f68696h = i3;
        a(b2);
        this.k = atomicReferenceArray;
        this.j = i3;
        this.f68695g = i3 - 1;
        this.f68693e = new AtomicLong();
        this.l = new AtomicLong();
    }

    public static int b(int i2) {
        return i2;
    }

    public static int c(long j, int i2) {
        int i3 = ((int) j) & i2;
        b(i3);
        return i3;
    }

    public static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public static void o(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    public final void a(int i2) {
        this.f68694f = Math.min(i2 / 4, m);
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final long d() {
        return this.l.get();
    }

    public final long e() {
        return this.f68693e.get();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    public final long f() {
        return this.l.get();
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        return (AtomicReferenceArray) g(atomicReferenceArray, length);
    }

    public final long i() {
        return this.f68693e.get();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.k = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j, i2));
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.k = atomicReferenceArray;
        int c2 = c(j, i2);
        T t = (T) g(atomicReferenceArray, c2);
        if (t == null) {
            return null;
        }
        o(atomicReferenceArray, c2, null);
        n(j + 1);
        return t;
    }

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f68697i;
        long i2 = i();
        int i3 = this.f68696h;
        long j = 2 + i2;
        if (g(atomicReferenceArray, c(j, i3)) == null) {
            int c2 = c(i2, i3);
            o(atomicReferenceArray, c2 + 1, t2);
            o(atomicReferenceArray, c2, t);
            q(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f68697i = atomicReferenceArray2;
        int c3 = c(i2, i3);
        o(atomicReferenceArray2, c3 + 1, t2);
        o(atomicReferenceArray2, c3, t);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, c3, n);
        q(j);
        return true;
    }

    public final void m(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f68697i = atomicReferenceArray2;
        this.f68695g = (j2 + j) - 1;
        o(atomicReferenceArray2, i2, t);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, i2, n);
        q(j + 1);
    }

    public final void n(long j) {
        this.l.lazySet(j);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f68697i;
        long e2 = e();
        int i2 = this.f68696h;
        int c2 = c(e2, i2);
        if (e2 < this.f68695g) {
            return r(atomicReferenceArray, t, e2, c2);
        }
        long j = this.f68694f + e2;
        if (g(atomicReferenceArray, c(j, i2)) == null) {
            this.f68695g = j - 1;
            return r(atomicReferenceArray, t, e2, c2);
        } else if (g(atomicReferenceArray, c(1 + e2, i2)) == null) {
            return r(atomicReferenceArray, t, e2, c2);
        } else {
            m(atomicReferenceArray, e2, c2, t, i2);
            return true;
        }
    }

    public final void p(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        o(atomicReferenceArray, length, atomicReferenceArray2);
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.k;
        long d2 = d();
        int i2 = this.j;
        T t = (T) g(atomicReferenceArray, c(d2, i2));
        return t == n ? j(h(atomicReferenceArray), d2, i2) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.k;
        long d2 = d();
        int i2 = this.j;
        int c2 = c(d2, i2);
        T t = (T) g(atomicReferenceArray, c2);
        boolean z = t == n;
        if (t == null || z) {
            if (z) {
                return k(h(atomicReferenceArray), d2, i2);
            }
            return null;
        }
        o(atomicReferenceArray, c2, null);
        n(d2 + 1);
        return t;
    }

    public final void q(long j) {
        this.f68693e.lazySet(j);
    }

    public final boolean r(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        o(atomicReferenceArray, i2, t);
        q(j + 1);
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long f2 = f();
        while (true) {
            long i2 = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i2 - f3);
            }
            f2 = f3;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
