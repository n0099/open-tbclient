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
        E[] eArr = this.nBO;
        long j = this.nSL;
        long dJv = dJv();
        long ht = ht(dJv);
        if (b(eArr, ht) != null) {
            if (dJv - dJw() > j) {
                return false;
            }
            do {
            } while (b(eArr, ht) != null);
            a(eArr, ht, e);
            hv(1 + dJv);
            return true;
        }
        a(eArr, ht, e);
        hv(1 + dJv);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dJw;
        long dOO = dOO();
        do {
            dJw = dJw();
            if (dJw >= dOO) {
                long dJv = dJv();
                if (dJw >= dJv) {
                    return null;
                }
                hw(dJv);
            }
        } while (!am(dJw, 1 + dJw));
        long ht = ht(dJw);
        E[] eArr = this.nBO;
        E a = a(eArr, ht);
        b(eArr, ht, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hu;
        long dOO = dOO();
        do {
            long dJw = dJw();
            if (dJw >= dOO) {
                long dJv = dJv();
                if (dJw >= dJv) {
                    return null;
                }
                hw(dJv);
            }
            hu = hu(ht(dJw));
        } while (hu == null);
        return hu;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJw = dJw();
        while (true) {
            long dJv = dJv();
            long dJw2 = dJw();
            if (dJw == dJw2) {
                return (int) (dJv - dJw2);
            }
            dJw = dJw2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJw() == dJv();
    }
}
