package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.qtz;
        long j = this.qDR;
        long eKC = eKC();
        long jB = jB(eKC);
        if (b(eArr, jB) != null) {
            if (eKC - eKD() > j) {
                return false;
            }
            do {
            } while (b(eArr, jB) != null);
            a(eArr, jB, e);
            jD(1 + eKC);
            return true;
        }
        a(eArr, jB, e);
        jD(1 + eKC);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eKD;
        long eNH = eNH();
        do {
            eKD = eKD();
            if (eKD >= eNH) {
                long eKC = eKC();
                if (eKD >= eKC) {
                    return null;
                }
                jE(eKC);
            }
        } while (!ac(eKD, 1 + eKD));
        long jB = jB(eKD);
        E[] eArr = this.qtz;
        E a2 = a(eArr, jB);
        b(eArr, jB, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jC;
        long eNH = eNH();
        do {
            long eKD = eKD();
            if (eKD >= eNH) {
                long eKC = eKC();
                if (eKD >= eKC) {
                    return null;
                }
                jE(eKC);
            }
            jC = jC(jB(eKD));
        } while (jC == null);
        return jC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eKD = eKD();
        while (true) {
            long eKC = eKC();
            long eKD2 = eKD();
            if (eKD == eKD2) {
                return (int) (eKC - eKD2);
            }
            eKD = eKD2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKD() == eKC();
    }
}
