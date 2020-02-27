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
        E[] eArr = this.nBM;
        long j = this.nSJ;
        long dJt = dJt();
        long ht = ht(dJt);
        if (b(eArr, ht) != null) {
            if (dJt - dJu() > j) {
                return false;
            }
            do {
            } while (b(eArr, ht) != null);
            a(eArr, ht, e);
            hv(1 + dJt);
            return true;
        }
        a(eArr, ht, e);
        hv(1 + dJt);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dJu;
        long dOM = dOM();
        do {
            dJu = dJu();
            if (dJu >= dOM) {
                long dJt = dJt();
                if (dJu >= dJt) {
                    return null;
                }
                hw(dJt);
            }
        } while (!am(dJu, 1 + dJu));
        long ht = ht(dJu);
        E[] eArr = this.nBM;
        E a = a(eArr, ht);
        b(eArr, ht, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hu;
        long dOM = dOM();
        do {
            long dJu = dJu();
            if (dJu >= dOM) {
                long dJt = dJt();
                if (dJu >= dJt) {
                    return null;
                }
                hw(dJt);
            }
            hu = hu(ht(dJu));
        } while (hu == null);
        return hu;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJu = dJu();
        while (true) {
            long dJt = dJt();
            long dJu2 = dJu();
            if (dJu == dJu2) {
                return (int) (dJt - dJu2);
            }
            dJu = dJu2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJu() == dJt();
    }
}
