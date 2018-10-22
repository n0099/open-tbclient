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
        E[] eArr = this.ipd;
        long j = this.iDK;
        long cdc = cdc();
        long dO = dO(cdc);
        if (b(eArr, dO) != null) {
            if (cdc - cdb() > j) {
                return false;
            }
            do {
            } while (b(eArr, dO) != null);
            a(eArr, dO, e);
            dQ(1 + cdc);
            return true;
        }
        a(eArr, dO, e);
        dQ(1 + cdc);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cdb;
        long cdf = cdf();
        do {
            cdb = cdb();
            if (cdb >= cdf) {
                long cdc = cdc();
                if (cdb >= cdc) {
                    return null;
                }
                dR(cdc);
            }
        } while (!v(cdb, 1 + cdb));
        long dO = dO(cdb);
        E[] eArr = this.ipd;
        E a = a(eArr, dO);
        b(eArr, dO, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dP;
        long cdf = cdf();
        do {
            long cdb = cdb();
            if (cdb >= cdf) {
                long cdc = cdc();
                if (cdb >= cdc) {
                    return null;
                }
                dR(cdc);
            }
            dP = dP(dO(cdb));
        } while (dP == null);
        return dP;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cdb = cdb();
        while (true) {
            long cdc = cdc();
            long cdb2 = cdb();
            if (cdb == cdb2) {
                return (int) (cdc - cdb2);
            }
            cdb = cdb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cdb() == cdc();
    }
}
