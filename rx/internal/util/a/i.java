package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.nXZ;
        long j = this.opd;
        long dTg = dTg();
        long gO = gO(dTg);
        if (b(eArr, gO) != null) {
            if (dTg - dTh() > j) {
                return false;
            }
            do {
            } while (b(eArr, gO) != null);
            a(eArr, gO, e);
            gQ(1 + dTg);
            return true;
        }
        a(eArr, gO, e);
        gQ(1 + dTg);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dTh;
        long dYA = dYA();
        do {
            dTh = dTh();
            if (dTh >= dYA) {
                long dTg = dTg();
                if (dTh >= dTg) {
                    return null;
                }
                gR(dTg);
            }
        } while (!Y(dTh, 1 + dTh));
        long gO = gO(dTh);
        E[] eArr = this.nXZ;
        E a = a(eArr, gO);
        b(eArr, gO, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gP;
        long dYA = dYA();
        do {
            long dTh = dTh();
            if (dTh >= dYA) {
                long dTg = dTg();
                if (dTh >= dTg) {
                    return null;
                }
                gR(dTg);
            }
            gP = gP(gO(dTh));
        } while (gP == null);
        return gP;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dTh = dTh();
        while (true) {
            long dTg = dTg();
            long dTh2 = dTh();
            if (dTh == dTh2) {
                return (int) (dTg - dTh2);
            }
            dTh = dTh2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dTh() == dTg();
    }
}
