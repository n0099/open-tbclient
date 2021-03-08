package rx.internal.util.a;
/* loaded from: classes4.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.qub;
        long j = this.qEt;
        long eKk = eKk();
        long jA = jA(eKk);
        if (b(eArr, jA) != null) {
            if (eKk - eKl() > j) {
                return false;
            }
            do {
            } while (b(eArr, jA) != null);
            a(eArr, jA, e);
            jC(1 + eKk);
            return true;
        }
        a(eArr, jA, e);
        jC(1 + eKk);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eKl;
        long eNp = eNp();
        do {
            eKl = eKl();
            if (eKl >= eNp) {
                long eKk = eKk();
                if (eKl >= eKk) {
                    return null;
                }
                jD(eKk);
            }
        } while (!ac(eKl, 1 + eKl));
        long jA = jA(eKl);
        E[] eArr = this.qub;
        E a2 = a(eArr, jA);
        b(eArr, jA, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jB;
        long eNp = eNp();
        do {
            long eKl = eKl();
            if (eKl >= eNp) {
                long eKk = eKk();
                if (eKl >= eKk) {
                    return null;
                }
                jD(eKk);
            }
            jB = jB(jA(eKl));
        } while (jB == null);
        return jB;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eKl = eKl();
        while (true) {
            long eKk = eKk();
            long eKl2 = eKl();
            if (eKl == eKl2) {
                return (int) (eKk - eKl2);
            }
            eKl = eKl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKl() == eKk();
    }
}
