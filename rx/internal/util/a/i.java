package rx.internal.util.a;
/* loaded from: classes2.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.iBh;
        long j = this.iPL;
        long cfs = cfs();
        long dV = dV(cfs);
        if (b(eArr, dV) != null) {
            if (cfs - cfr() > j) {
                return false;
            }
            do {
            } while (b(eArr, dV) != null);
            a(eArr, dV, e);
            dX(1 + cfs);
            return true;
        }
        a(eArr, dV, e);
        dX(1 + cfs);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cfr;
        long cfv = cfv();
        do {
            cfr = cfr();
            if (cfr >= cfv) {
                long cfs = cfs();
                if (cfr >= cfs) {
                    return null;
                }
                dY(cfs);
            }
        } while (!u(cfr, 1 + cfr));
        long dV = dV(cfr);
        E[] eArr = this.iBh;
        E a = a(eArr, dV);
        b(eArr, dV, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dW;
        long cfv = cfv();
        do {
            long cfr = cfr();
            if (cfr >= cfv) {
                long cfs = cfs();
                if (cfr >= cfs) {
                    return null;
                }
                dY(cfs);
            }
            dW = dW(dV(cfr));
        } while (dW == null);
        return dW;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cfr = cfr();
        while (true) {
            long cfs = cfs();
            long cfr2 = cfr();
            if (cfr == cfr2) {
                return (int) (cfs - cfr2);
            }
            cfr = cfr2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cfr() == cfs();
    }
}
