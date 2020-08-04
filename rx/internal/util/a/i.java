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
        E[] eArr = this.nYb;
        long j = this.opf;
        long dTh = dTh();
        long gO = gO(dTh);
        if (b(eArr, gO) != null) {
            if (dTh - dTi() > j) {
                return false;
            }
            do {
            } while (b(eArr, gO) != null);
            a(eArr, gO, e);
            gQ(1 + dTh);
            return true;
        }
        a(eArr, gO, e);
        gQ(1 + dTh);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dTi;
        long dYB = dYB();
        do {
            dTi = dTi();
            if (dTi >= dYB) {
                long dTh = dTh();
                if (dTi >= dTh) {
                    return null;
                }
                gR(dTh);
            }
        } while (!Y(dTi, 1 + dTi));
        long gO = gO(dTi);
        E[] eArr = this.nYb;
        E a = a(eArr, gO);
        b(eArr, gO, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gP;
        long dYB = dYB();
        do {
            long dTi = dTi();
            if (dTi >= dYB) {
                long dTh = dTh();
                if (dTi >= dTh) {
                    return null;
                }
                gR(dTh);
            }
            gP = gP(gO(dTi));
        } while (gP == null);
        return gP;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dTi = dTi();
        while (true) {
            long dTh = dTh();
            long dTi2 = dTi();
            if (dTi == dTi2) {
                return (int) (dTh - dTi2);
            }
            dTi = dTi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dTi() == dTh();
    }
}
