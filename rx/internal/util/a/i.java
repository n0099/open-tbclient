package rx.internal.util.a;
/* loaded from: classes16.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.pSe;
        long j = this.qjb;
        long eAP = eAP();
        long iv = iv(eAP);
        if (b(eArr, iv) != null) {
            if (eAP - eAQ() > j) {
                return false;
            }
            do {
            } while (b(eArr, iv) != null);
            a(eArr, iv, e);
            ix(1 + eAP);
            return true;
        }
        a(eArr, iv, e);
        ix(1 + eAP);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eAQ;
        long eGk = eGk();
        do {
            eAQ = eAQ();
            if (eAQ >= eGk) {
                long eAP = eAP();
                if (eAQ >= eAP) {
                    return null;
                }
                iy(eAP);
            }
        } while (!X(eAQ, 1 + eAQ));
        long iv = iv(eAQ);
        E[] eArr = this.pSe;
        E a2 = a(eArr, iv);
        b(eArr, iv, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E iw;
        long eGk = eGk();
        do {
            long eAQ = eAQ();
            if (eAQ >= eGk) {
                long eAP = eAP();
                if (eAQ >= eAP) {
                    return null;
                }
                iy(eAP);
            }
            iw = iw(iv(eAQ));
        } while (iw == null);
        return iw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eAQ = eAQ();
        while (true) {
            long eAP = eAP();
            long eAQ2 = eAQ();
            if (eAQ == eAQ2) {
                return (int) (eAP - eAQ2);
            }
            eAQ = eAQ2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eAQ() == eAP();
    }
}
