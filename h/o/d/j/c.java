package h.o.d.j;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class c<E> extends a<E> {
    public static final Integer k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f67952g;

    /* renamed from: h  reason: collision with root package name */
    public long f67953h;
    public final AtomicLong i;
    public final int j;

    public c(int i) {
        super(i);
        this.f67952g = new AtomicLong();
        this.i = new AtomicLong();
        this.j = Math.min(i / 4, k.intValue());
    }

    public final long f() {
        return this.i.get();
    }

    public final long g() {
        return this.f67952g.get();
    }

    public final void h(long j) {
        this.i.lazySet(j);
    }

    public final void i(long j) {
        this.f67952g.lazySet(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return g() == f();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f67948e;
            int i = this.f67949f;
            long j = this.f67952g.get();
            int b2 = b(j, i);
            if (j >= this.f67953h) {
                long j2 = this.j + j;
                if (d(atomicReferenceArray, b(j2, i)) == null) {
                    this.f67953h = j2;
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
        return c(a(this.i.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.i.get();
        int a2 = a(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f67948e;
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
