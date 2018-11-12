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
        E[] eArr = this.iqN;
        long j = this.iFu;
        long ccz = ccz();
        long dJ = dJ(ccz);
        if (b(eArr, dJ) != null) {
            if (ccz - ccy() > j) {
                return false;
            }
            do {
            } while (b(eArr, dJ) != null);
            a(eArr, dJ, e);
            dL(1 + ccz);
            return true;
        }
        a(eArr, dJ, e);
        dL(1 + ccz);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long ccy;
        long ccC = ccC();
        do {
            ccy = ccy();
            if (ccy >= ccC) {
                long ccz = ccz();
                if (ccy >= ccz) {
                    return null;
                }
                dM(ccz);
            }
        } while (!u(ccy, 1 + ccy));
        long dJ = dJ(ccy);
        E[] eArr = this.iqN;
        E a = a(eArr, dJ);
        b(eArr, dJ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dK;
        long ccC = ccC();
        do {
            long ccy = ccy();
            if (ccy >= ccC) {
                long ccz = ccz();
                if (ccy >= ccz) {
                    return null;
                }
                dM(ccz);
            }
            dK = dK(dJ(ccy));
        } while (dK == null);
        return dK;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ccy = ccy();
        while (true) {
            long ccz = ccz();
            long ccy2 = ccy();
            if (ccy == ccy2) {
                return (int) (ccz - ccy2);
            }
            ccy = ccy2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ccy() == ccz();
    }
}
