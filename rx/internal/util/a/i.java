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
        E[] eArr = this.qsZ;
        long j = this.qDr;
        long eKu = eKu();
        long jB = jB(eKu);
        if (b(eArr, jB) != null) {
            if (eKu - eKv() > j) {
                return false;
            }
            do {
            } while (b(eArr, jB) != null);
            a(eArr, jB, e);
            jD(1 + eKu);
            return true;
        }
        a(eArr, jB, e);
        jD(1 + eKu);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eKv;
        long eNz = eNz();
        do {
            eKv = eKv();
            if (eKv >= eNz) {
                long eKu = eKu();
                if (eKv >= eKu) {
                    return null;
                }
                jE(eKu);
            }
        } while (!ac(eKv, 1 + eKv));
        long jB = jB(eKv);
        E[] eArr = this.qsZ;
        E a2 = a(eArr, jB);
        b(eArr, jB, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jC;
        long eNz = eNz();
        do {
            long eKv = eKv();
            if (eKv >= eNz) {
                long eKu = eKu();
                if (eKv >= eKu) {
                    return null;
                }
                jE(eKu);
            }
            jC = jC(jB(eKv));
        } while (jC == null);
        return jC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eKv = eKv();
        while (true) {
            long eKu = eKu();
            long eKv2 = eKv();
            if (eKv == eKv2) {
                return (int) (eKu - eKv2);
            }
            eKv = eKv2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKv() == eKu();
    }
}
