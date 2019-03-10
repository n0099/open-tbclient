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
        E[] eArr = this.jSt;
        long j = this.kbJ;
        long cEN = cEN();
        long es = es(cEN);
        if (b(eArr, es) != null) {
            if (cEN - cEM() > j) {
                return false;
            }
            do {
            } while (b(eArr, es) != null);
            a(eArr, es, e);
            eu(1 + cEN);
            return true;
        }
        a(eArr, es, e);
        eu(1 + cEN);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cEM;
        long cEQ = cEQ();
        do {
            cEM = cEM();
            if (cEM >= cEQ) {
                long cEN = cEN();
                if (cEM >= cEN) {
                    return null;
                }
                ev(cEN);
            }
        } while (!z(cEM, 1 + cEM));
        long es = es(cEM);
        E[] eArr = this.jSt;
        E a = a(eArr, es);
        b(eArr, es, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E et;
        long cEQ = cEQ();
        do {
            long cEM = cEM();
            if (cEM >= cEQ) {
                long cEN = cEN();
                if (cEM >= cEN) {
                    return null;
                }
                ev(cEN);
            }
            et = et(es(cEM));
        } while (et == null);
        return et;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEM = cEM();
        while (true) {
            long cEN = cEN();
            long cEM2 = cEM();
            if (cEM == cEM2) {
                return (int) (cEN - cEM2);
            }
            cEM = cEM2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEM() == cEN();
    }
}
