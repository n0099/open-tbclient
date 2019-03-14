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
        E[] eArr = this.jSl;
        long j = this.kbB;
        long cEQ = cEQ();
        long es = es(cEQ);
        if (b(eArr, es) != null) {
            if (cEQ - cEP() > j) {
                return false;
            }
            do {
            } while (b(eArr, es) != null);
            a(eArr, es, e);
            eu(1 + cEQ);
            return true;
        }
        a(eArr, es, e);
        eu(1 + cEQ);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cEP;
        long cET = cET();
        do {
            cEP = cEP();
            if (cEP >= cET) {
                long cEQ = cEQ();
                if (cEP >= cEQ) {
                    return null;
                }
                ev(cEQ);
            }
        } while (!z(cEP, 1 + cEP));
        long es = es(cEP);
        E[] eArr = this.jSl;
        E a = a(eArr, es);
        b(eArr, es, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E et;
        long cET = cET();
        do {
            long cEP = cEP();
            if (cEP >= cET) {
                long cEQ = cEQ();
                if (cEP >= cEQ) {
                    return null;
                }
                ev(cEQ);
            }
            et = et(es(cEP));
        } while (et == null);
        return et;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEP = cEP();
        while (true) {
            long cEQ = cEQ();
            long cEP2 = cEP();
            if (cEP == cEP2) {
                return (int) (cEQ - cEP2);
            }
            cEP = cEP2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEP() == cEQ();
    }
}
