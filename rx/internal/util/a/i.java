package rx.internal.util.a;
/* loaded from: classes14.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.pTH;
        long j = this.qkE;
        long eAQ = eAQ();
        long iy = iy(eAQ);
        if (b(eArr, iy) != null) {
            if (eAQ - eAR() > j) {
                return false;
            }
            do {
            } while (b(eArr, iy) != null);
            a(eArr, iy, e);
            iA(1 + eAQ);
            return true;
        }
        a(eArr, iy, e);
        iA(1 + eAQ);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eAR;
        long eGl = eGl();
        do {
            eAR = eAR();
            if (eAR >= eGl) {
                long eAQ = eAQ();
                if (eAR >= eAQ) {
                    return null;
                }
                iB(eAQ);
            }
        } while (!X(eAR, 1 + eAR));
        long iy = iy(eAR);
        E[] eArr = this.pTH;
        E a2 = a(eArr, iy);
        b(eArr, iy, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E iz;
        long eGl = eGl();
        do {
            long eAR = eAR();
            if (eAR >= eGl) {
                long eAQ = eAQ();
                if (eAR >= eAQ) {
                    return null;
                }
                iB(eAQ);
            }
            iz = iz(iy(eAR));
        } while (iz == null);
        return iz;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eAR = eAR();
        while (true) {
            long eAQ = eAQ();
            long eAR2 = eAR();
            if (eAR == eAR2) {
                return (int) (eAQ - eAR2);
            }
            eAR = eAR2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eAR() == eAQ();
    }
}
