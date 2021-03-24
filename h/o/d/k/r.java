package h.o.d.k;
/* loaded from: classes7.dex */
public final class r<E> extends w<E> {
    public r(int i) {
        super(i);
    }

    public final long h() {
        return f0.f67967a.d(this, t.l);
    }

    public final long i() {
        return f0.f67967a.d(this, x.k);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return i() == h();
    }

    public final void j(long j) {
        f0.f67967a.i(this, t.l, j);
    }

    public final void k(long j) {
        f0.f67967a.i(this, x.k, j);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            E[] eArr = this.f67966f;
            long j = this.producerIndex;
            long a2 = a(j);
            if (e(eArr, a2) != null) {
                return false;
            }
            f(eArr, a2, e2);
            k(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        return d(a(this.consumerIndex));
    }

    @Override // java.util.Queue, h.o.d.k.h
    public E poll() {
        long j = this.consumerIndex;
        long a2 = a(j);
        E[] eArr = this.f67966f;
        E e2 = e(eArr, a2);
        if (e2 == null) {
            return null;
        }
        f(eArr, a2, null);
        j(j + 1);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long h2 = h();
        while (true) {
            long i = i();
            long h3 = h();
            if (h2 == h3) {
                return (int) (i - h3);
            }
            h2 = h3;
        }
    }
}
