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
        long dCS = dCS();
        long gv = gv(dCS);
        if (b(eArr, gv) != null) {
            if (dCS - dCT() > j) {
                return false;
            }
            do {
            } while (b(eArr, gv) != null);
            a(eArr, gv, e);
            gx(1 + dCS);
            return true;
        }
        a(eArr, gv, e);
        gx(1 + dCS);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dCT;
        long dIm = dIm();
        do {
            dCT = dCT();
            if (dCT >= dIm) {
                long dCS = dCS();
                if (dCT >= dCS) {
                    return null;
                }
                gy(dCS);
            }
        } while (!U(dCT, 1 + dCT));
        long gv = gv(dCT);
        E[] eArr = this.mXo;
        E a = a(eArr, gv);
        b(eArr, gv, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gw;
        long dIm = dIm();
        do {
            long dCT = dCT();
            if (dCT >= dIm) {
                long dCS = dCS();
                if (dCT >= dCS) {
                    return null;
                }
                gy(dCS);
            }
            gw = gw(gv(dCT));
        } while (gw == null);
        return gw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dCT = dCT();
        while (true) {
            long dCS = dCS();
            long dCT2 = dCT();
            if (dCT == dCT2) {
                return (int) (dCS - dCT2);
            }
            dCT = dCT2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCT() == dCS();
    }
}
