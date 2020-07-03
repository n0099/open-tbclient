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
        E[] eArr = this.nPn;
        long j = this.ogs;
        long dPG = dPG();
        long gB = gB(dPG);
        if (b(eArr, gB) != null) {
            if (dPG - dPH() > j) {
                return false;
            }
            do {
            } while (b(eArr, gB) != null);
            a(eArr, gB, e);
            gD(1 + dPG);
            return true;
        }
        a(eArr, gB, e);
        gD(1 + dPG);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dPH;
        long dVa = dVa();
        do {
            dPH = dPH();
            if (dPH >= dVa) {
                long dPG = dPG();
                if (dPH >= dPG) {
                    return null;
                }
                gE(dPG);
            }
        } while (!W(dPH, 1 + dPH));
        long gB = gB(dPH);
        E[] eArr = this.nPn;
        E a = a(eArr, gB);
        b(eArr, gB, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gC;
        long dVa = dVa();
        do {
            long dPH = dPH();
            if (dPH >= dVa) {
                long dPG = dPG();
                if (dPH >= dPG) {
                    return null;
                }
                gE(dPG);
            }
            gC = gC(gB(dPH));
        } while (gC == null);
        return gC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dPH = dPH();
        while (true) {
            long dPG = dPG();
            long dPH2 = dPH();
            if (dPH == dPH2) {
                return (int) (dPG - dPH2);
            }
            dPH = dPH2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dPH() == dPG();
    }
}
