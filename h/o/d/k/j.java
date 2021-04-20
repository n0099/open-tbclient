package h.o.d.k;
/* loaded from: classes7.dex */
public final class j<E> extends n<E> {
    public j(int i) {
        super(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return k() == h();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            E[] eArr = this.f68981f;
            long j = this.f68980e;
            long h2 = h();
            long a2 = a(h2);
            if (e(eArr, a2) != null) {
                if (h2 - k() > j) {
                    return false;
                }
                do {
                } while (e(eArr, a2) != null);
                g(eArr, a2, e2);
                i(h2 + 1);
                return true;
            }
            g(eArr, a2, e2);
            i(h2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        E d2;
        long l = l();
        do {
            long k = k();
            if (k >= l) {
                long h2 = h();
                if (k >= h2) {
                    return null;
                }
                m(h2);
            }
            d2 = d(a(k));
        } while (d2 == null);
        return d2;
    }

    @Override // java.util.Queue, h.o.d.k.h
    public E poll() {
        long k;
        long l = l();
        do {
            k = k();
            if (k >= l) {
                long h2 = h();
                if (k >= h2) {
                    return null;
                }
                m(h2);
            }
        } while (!j(k, 1 + k));
        long a2 = a(k);
        E[] eArr = this.f68981f;
        E c2 = c(eArr, a2);
        f(eArr, a2, null);
        return c2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long k = k();
        while (true) {
            long h2 = h();
            long k2 = k();
            if (k == k2) {
                return (int) (h2 - k2);
            }
            k = k2;
        }
    }
}
