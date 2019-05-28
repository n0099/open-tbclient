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
        E[] eArr = this.kjX;
        long j = this.ktk;
        long cMn = cMn();
        long eQ = eQ(cMn);
        if (b(eArr, eQ) != null) {
            if (cMn - cMm() > j) {
                return false;
            }
            do {
            } while (b(eArr, eQ) != null);
            a(eArr, eQ, e);
            eS(1 + cMn);
            return true;
        }
        a(eArr, eQ, e);
        eS(1 + cMn);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cMm;
        long cMq = cMq();
        do {
            cMm = cMm();
            if (cMm >= cMq) {
                long cMn = cMn();
                if (cMm >= cMn) {
                    return null;
                }
                eT(cMn);
            }
        } while (!A(cMm, 1 + cMm));
        long eQ = eQ(cMm);
        E[] eArr = this.kjX;
        E a = a(eArr, eQ);
        b(eArr, eQ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E eR;
        long cMq = cMq();
        do {
            long cMm = cMm();
            if (cMm >= cMq) {
                long cMn = cMn();
                if (cMm >= cMn) {
                    return null;
                }
                eT(cMn);
            }
            eR = eR(eQ(cMm));
        } while (eR == null);
        return eR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cMm = cMm();
        while (true) {
            long cMn = cMn();
            long cMm2 = cMm();
            if (cMm == cMm2) {
                return (int) (cMn - cMm2);
            }
            cMm = cMm2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMm() == cMn();
    }
}
