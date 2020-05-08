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
        E[] eArr = this.mXo;
        long j = this.nov;
        long dCR = dCR();
        long gv = gv(dCR);
        if (b(eArr, gv) != null) {
            if (dCR - dCS() > j) {
                return false;
            }
            do {
            } while (b(eArr, gv) != null);
            a(eArr, gv, e);
            gx(1 + dCR);
            return true;
        }
        a(eArr, gv, e);
        gx(1 + dCR);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dCS;
        long dIl = dIl();
        do {
            dCS = dCS();
            if (dCS >= dIl) {
                long dCR = dCR();
                if (dCS >= dCR) {
                    return null;
                }
                gy(dCR);
            }
        } while (!U(dCS, 1 + dCS));
        long gv = gv(dCS);
        E[] eArr = this.mXo;
        E a = a(eArr, gv);
        b(eArr, gv, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gw;
        long dIl = dIl();
        do {
            long dCS = dCS();
            if (dCS >= dIl) {
                long dCR = dCR();
                if (dCS >= dCR) {
                    return null;
                }
                gy(dCR);
            }
            gw = gw(gv(dCS));
        } while (gw == null);
        return gw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dCS = dCS();
        while (true) {
            long dCR = dCR();
            long dCS2 = dCS();
            if (dCS == dCS2) {
                return (int) (dCR - dCS2);
            }
            dCS = dCS2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCS() == dCR();
    }
}
