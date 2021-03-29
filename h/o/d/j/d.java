package h.o.d.j;

import h.o.d.k.i;
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
    public final AtomicLong f67954e;

    /* renamed from: f  reason: collision with root package name */
    public int f67955f;

    /* renamed from: g  reason: collision with root package name */
    public long f67956g;

    /* renamed from: h  reason: collision with root package name */
    public int f67957h;
    public AtomicReferenceArray<Object> i;
    public int j;
    public AtomicReferenceArray<Object> k;
    public final AtomicLong l;

    public d(int i) {
        int b2 = i.b(i);
        int i2 = b2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b2 + 1);
        this.i = atomicReferenceArray;
        this.f67957h = i2;
        a(b2);
        this.k = atomicReferenceArray;
        this.j = i2;
        this.f67956g = i2 - 1;
        this.f67954e = new AtomicLong();
        this.l = new AtomicLong();
    }

    public static int b(int i) {
        return i;
    }

    public static int c(long j, int i) {
        int i2 = ((int) j) & i;
        b(i2);
        return i2;
    }

    public static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public static void o(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    public final void a(int i) {
        this.f67955f = Math.min(i / 4, m);
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
        return this.f67954e.get();
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
        return this.f67954e.get();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.k = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j, i));
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.k = atomicReferenceArray;
        int c2 = c(j, i);
        T t = (T) g(atomicReferenceArray, c2);
        if (t == null) {
            return null;
        }
        o(atomicReferenceArray, c2, null);
        n(j + 1);
        return t;
    }

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long i = i();
        int i2 = this.f67957h;
        long j = 2 + i;
        if (g(atomicReferenceArray, c(j, i2)) == null) {
            int c2 = c(i, i2);
            o(atomicReferenceArray, c2 + 1, t2);
            o(atomicReferenceArray, c2, t);
            q(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.i = atomicReferenceArray2;
        int c3 = c(i, i2);
        o(atomicReferenceArray2, c3 + 1, t2);
        o(atomicReferenceArray2, c3, t);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, c3, n);
        q(j);
        return true;
    }

    public final void m(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.i = atomicReferenceArray2;
        this.f67956g = (j2 + j) - 1;
        o(atomicReferenceArray2, i, t);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, i, n);
        q(j + 1);
    }

    public final void n(long j) {
        this.l.lazySet(j);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long e2 = e();
        int i = this.f67957h;
        int c2 = c(e2, i);
        if (e2 < this.f67956g) {
            return r(atomicReferenceArray, t, e2, c2);
        }
        long j = this.f67955f + e2;
        if (g(atomicReferenceArray, c(j, i)) == null) {
            this.f67956g = j - 1;
            return r(atomicReferenceArray, t, e2, c2);
        } else if (g(atomicReferenceArray, c(1 + e2, i)) == null) {
            return r(atomicReferenceArray, t, e2, c2);
        } else {
            m(atomicReferenceArray, e2, c2, t, i);
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
        int i = this.j;
        T t = (T) g(atomicReferenceArray, c(d2, i));
        return t == n ? j(h(atomicReferenceArray), d2, i) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.k;
        long d2 = d();
        int i = this.j;
        int c2 = c(d2, i);
        T t = (T) g(atomicReferenceArray, c2);
        boolean z = t == n;
        if (t == null || z) {
            if (z) {
                return k(h(atomicReferenceArray), d2, i);
            }
            return null;
        }
        o(atomicReferenceArray, c2, null);
        n(d2 + 1);
        return t;
    }

    public final void q(long j) {
        this.f67954e.lazySet(j);
    }

    public final boolean r(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        o(atomicReferenceArray, i, t);
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
            long i = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i - f3);
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
