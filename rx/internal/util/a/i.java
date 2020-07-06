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
        E[] eArr = this.nPq;
        long j = this.ogv;
        long dPK = dPK();
        long gB = gB(dPK);
        if (b(eArr, gB) != null) {
            if (dPK - dPL() > j) {
                return false;
            }
            do {
            } while (b(eArr, gB) != null);
            a(eArr, gB, e);
            gD(1 + dPK);
            return true;
        }
        a(eArr, gB, e);
        gD(1 + dPK);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dPL;
        long dVe = dVe();
        do {
            dPL = dPL();
            if (dPL >= dVe) {
                long dPK = dPK();
                if (dPL >= dPK) {
                    return null;
                }
                gE(dPK);
            }
        } while (!W(dPL, 1 + dPL));
        long gB = gB(dPL);
        E[] eArr = this.nPq;
        E a = a(eArr, gB);
        b(eArr, gB, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gC;
        long dVe = dVe();
        do {
            long dPL = dPL();
            if (dPL >= dVe) {
                long dPK = dPK();
                if (dPL >= dPK) {
                    return null;
                }
                gE(dPK);
            }
            gC = gC(gB(dPL));
        } while (gC == null);
        return gC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dPL = dPL();
        while (true) {
            long dPK = dPK();
            long dPL2 = dPL();
            if (dPL == dPL2) {
                return (int) (dPK - dPL2);
            }
            dPL = dPL2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dPL() == dPK();
    }
}
