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
        E[] eArr = this.kjW;
        long j = this.ktj;
        long cMl = cMl();
        long eQ = eQ(cMl);
        if (b(eArr, eQ) != null) {
            if (cMl - cMk() > j) {
                return false;
            }
            do {
            } while (b(eArr, eQ) != null);
            a(eArr, eQ, e);
            eS(1 + cMl);
            return true;
        }
        a(eArr, eQ, e);
        eS(1 + cMl);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cMk;
        long cMo = cMo();
        do {
            cMk = cMk();
            if (cMk >= cMo) {
                long cMl = cMl();
                if (cMk >= cMl) {
                    return null;
                }
                eT(cMl);
            }
        } while (!A(cMk, 1 + cMk));
        long eQ = eQ(cMk);
        E[] eArr = this.kjW;
        E a = a(eArr, eQ);
        b(eArr, eQ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E eR;
        long cMo = cMo();
        do {
            long cMk = cMk();
            if (cMk >= cMo) {
                long cMl = cMl();
                if (cMk >= cMl) {
                    return null;
                }
                eT(cMl);
            }
            eR = eR(eQ(cMk));
        } while (eR == null);
        return eR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cMk = cMk();
        while (true) {
            long cMl = cMl();
            long cMk2 = cMk();
            if (cMk == cMk2) {
                return (int) (cMl - cMk2);
            }
            cMk = cMk2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMk() == cMl();
    }
}
