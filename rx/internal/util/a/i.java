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
        E[] eArr = this.nsq;
        long j = this.nJu;
        long dKM = dKM();
        long gw = gw(dKM);
        if (b(eArr, gw) != null) {
            if (dKM - dKN() > j) {
                return false;
            }
            do {
            } while (b(eArr, gw) != null);
            a(eArr, gw, e);
            gy(1 + dKM);
            return true;
        }
        a(eArr, gw, e);
        gy(1 + dKM);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dKN;
        long dQg = dQg();
        do {
            dKN = dKN();
            if (dKN >= dQg) {
                long dKM = dKM();
                if (dKN >= dKM) {
                    return null;
                }
                gz(dKM);
            }
        } while (!V(dKN, 1 + dKN));
        long gw = gw(dKN);
        E[] eArr = this.nsq;
        E a = a(eArr, gw);
        b(eArr, gw, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gx;
        long dQg = dQg();
        do {
            long dKN = dKN();
            if (dKN >= dQg) {
                long dKM = dKM();
                if (dKN >= dKM) {
                    return null;
                }
                gz(dKM);
            }
            gx = gx(gw(dKN));
        } while (gx == null);
        return gx;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dKN() == dKM();
    }
}
