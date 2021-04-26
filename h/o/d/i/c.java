package h.o.d.i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class c<E> extends a<E> {
    public static final Integer k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f67967g;

    /* renamed from: h  reason: collision with root package name */
    public long f67968h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f67969i;
    public final int j;

    public c(int i2) {
        super(i2);
        this.f67967g = new AtomicLong();
        this.f67969i = new AtomicLong();
        this.j = Math.min(i2 / 4, k.intValue());
    }

    public final long f() {
        return this.f67969i.get();
    }

    public final long g() {
        return this.f67967g.get();
    }

    public final void h(long j) {
        this.f67969i.lazySet(j);
    }

    public final void i(long j) {
        this.f67967g.lazySet(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return g() == f();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f67963e;
            int i2 = this.f67964f;
            long j = this.f67967g.get();
            int b2 = b(j, i2);
            if (j >= this.f67968h) {
                long j2 = this.j + j;
                if (d(atomicReferenceArray, b(j2, i2)) == null) {
                    this.f67968h = j2;
                } else if (d(atomicReferenceArray, b2) != null) {
                    return false;
                }
            }
            e(atomicReferenceArray, b2, e2);
            i(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        return c(a(this.f67969i.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.f67969i.get();
        int a2 = a(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f67963e;
        E d2 = d(atomicReferenceArray, a2);
        if (d2 == null) {
            return null;
        }
        e(atomicReferenceArray, a2, null);
        h(j + 1);
        return d2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long f2 = f();
        while (true) {
            long g2 = g();
            long f3 = f();
            if (f2 == f3) {
                return (int) (g2 - f3);
            }
            f2 = f3;
        }
    }
}
