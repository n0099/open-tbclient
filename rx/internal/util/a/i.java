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
        E[] eArr = this.nBZ;
        long j = this.nSW;
        long dJw = dJw();
        long ht = ht(dJw);
        if (b(eArr, ht) != null) {
            if (dJw - dJx() > j) {
                return false;
            }
            do {
            } while (b(eArr, ht) != null);
            a(eArr, ht, e);
            hv(1 + dJw);
            return true;
        }
        a(eArr, ht, e);
        hv(1 + dJw);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dJx;
        long dOP = dOP();
        do {
            dJx = dJx();
            if (dJx >= dOP) {
                long dJw = dJw();
                if (dJx >= dJw) {
                    return null;
                }
                hw(dJw);
            }
        } while (!am(dJx, 1 + dJx));
        long ht = ht(dJx);
        E[] eArr = this.nBZ;
        E a = a(eArr, ht);
        b(eArr, ht, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hu;
        long dOP = dOP();
        do {
            long dJx = dJx();
            if (dJx >= dOP) {
                long dJw = dJw();
                if (dJx >= dJw) {
                    return null;
                }
                hw(dJw);
            }
            hu = hu(ht(dJx));
        } while (hu == null);
        return hu;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJx = dJx();
        while (true) {
            long dJw = dJw();
            long dJx2 = dJx();
            if (dJx == dJx2) {
                return (int) (dJw - dJx2);
            }
            dJx = dJx2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJx() == dJw();
    }
}
