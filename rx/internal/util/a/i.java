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
        E[] eArr = this.nBk;
        long j = this.nRV;
        long dIm = dIm();
        long hv = hv(dIm);
        if (b(eArr, hv) != null) {
            if (dIm - dIn() > j) {
                return false;
            }
            do {
            } while (b(eArr, hv) != null);
            a(eArr, hv, e);
            hx(1 + dIm);
            return true;
        }
        a(eArr, hv, e);
        hx(1 + dIm);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dIn;
        long dNz = dNz();
        do {
            dIn = dIn();
            if (dIn >= dNz) {
                long dIm = dIm();
                if (dIn >= dIm) {
                    return null;
                }
                hy(dIm);
            }
        } while (!am(dIn, 1 + dIn));
        long hv = hv(dIn);
        E[] eArr = this.nBk;
        E a = a(eArr, hv);
        b(eArr, hv, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hw;
        long dNz = dNz();
        do {
            long dIn = dIn();
            if (dIn >= dNz) {
                long dIm = dIm();
                if (dIn >= dIm) {
                    return null;
                }
                hy(dIm);
            }
            hw = hw(hv(dIn));
        } while (hw == null);
        return hw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dIn = dIn();
        while (true) {
            long dIm = dIm();
            long dIn2 = dIn();
            if (dIn == dIn2) {
                return (int) (dIm - dIn2);
            }
            dIn = dIn2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dIn() == dIm();
    }
}
