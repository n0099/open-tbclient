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
        E[] eArr = this.kka;
        long j = this.ktn;
        long cMm = cMm();
        long eQ = eQ(cMm);
        if (b(eArr, eQ) != null) {
            if (cMm - cMl() > j) {
                return false;
            }
            do {
            } while (b(eArr, eQ) != null);
            a(eArr, eQ, e);
            eS(1 + cMm);
            return true;
        }
        a(eArr, eQ, e);
        eS(1 + cMm);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cMl;
        long cMp = cMp();
        do {
            cMl = cMl();
            if (cMl >= cMp) {
                long cMm = cMm();
                if (cMl >= cMm) {
                    return null;
                }
                eT(cMm);
            }
        } while (!A(cMl, 1 + cMl));
        long eQ = eQ(cMl);
        E[] eArr = this.kka;
        E a = a(eArr, eQ);
        b(eArr, eQ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E eR;
        long cMp = cMp();
        do {
            long cMl = cMl();
            if (cMl >= cMp) {
                long cMm = cMm();
                if (cMl >= cMm) {
                    return null;
                }
                eT(cMm);
            }
            eR = eR(eQ(cMl));
        } while (eR == null);
        return eR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cMl = cMl();
        while (true) {
            long cMm = cMm();
            long cMl2 = cMl();
            if (cMl == cMl2) {
                return (int) (cMm - cMl2);
            }
            cMl = cMl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMl() == cMm();
    }
}
