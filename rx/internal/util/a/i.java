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
        E[] eArr = this.nDM;
        long j = this.nUJ;
        long dJW = dJW();
        long hu = hu(dJW);
        if (b(eArr, hu) != null) {
            if (dJW - dJX() > j) {
                return false;
            }
            do {
            } while (b(eArr, hu) != null);
            a(eArr, hu, e);
            hw(1 + dJW);
            return true;
        }
        a(eArr, hu, e);
        hw(1 + dJW);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dJX;
        long dPp = dPp();
        do {
            dJX = dJX();
            if (dJX >= dPp) {
                long dJW = dJW();
                if (dJX >= dJW) {
                    return null;
                }
                hx(dJW);
            }
        } while (!am(dJX, 1 + dJX));
        long hu = hu(dJX);
        E[] eArr = this.nDM;
        E a = a(eArr, hu);
        b(eArr, hu, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hv;
        long dPp = dPp();
        do {
            long dJX = dJX();
            if (dJX >= dPp) {
                long dJW = dJW();
                if (dJX >= dJW) {
                    return null;
                }
                hx(dJW);
            }
            hv = hv(hu(dJX));
        } while (hv == null);
        return hv;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJX = dJX();
        while (true) {
            long dJW = dJW();
            long dJX2 = dJX();
            if (dJX == dJX2) {
                return (int) (dJW - dJX2);
            }
            dJX = dJX2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJX() == dJW();
    }
}
