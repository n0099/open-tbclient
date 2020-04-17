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
        E[] eArr = this.mXl;
        long j = this.nor;
        long dCV = dCV();
        long gv = gv(dCV);
        if (b(eArr, gv) != null) {
            if (dCV - dCW() > j) {
                return false;
            }
            do {
            } while (b(eArr, gv) != null);
            a(eArr, gv, e);
            gx(1 + dCV);
            return true;
        }
        a(eArr, gv, e);
        gx(1 + dCV);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dCW;
        long dIp = dIp();
        do {
            dCW = dCW();
            if (dCW >= dIp) {
                long dCV = dCV();
                if (dCW >= dCV) {
                    return null;
                }
                gy(dCV);
            }
        } while (!U(dCW, 1 + dCW));
        long gv = gv(dCW);
        E[] eArr = this.mXl;
        E a = a(eArr, gv);
        b(eArr, gv, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gw;
        long dIp = dIp();
        do {
            long dCW = dCW();
            if (dCW >= dIp) {
                long dCV = dCV();
                if (dCW >= dCV) {
                    return null;
                }
                gy(dCV);
            }
            gw = gw(gv(dCW));
        } while (gw == null);
        return gw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dCW = dCW();
        while (true) {
            long dCV = dCV();
            long dCW2 = dCW();
            if (dCW == dCW2) {
                return (int) (dCV - dCW2);
            }
            dCW = dCW2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCW() == dCV();
    }
}
